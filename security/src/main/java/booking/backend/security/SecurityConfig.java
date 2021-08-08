package booking.backend.security;

import booking.backend.db.provider.UserSecurityProvider;
import booking.backend.security.handler.BookingAccessDeniedHandler;
import booking.backend.security.handler.BookingFailureHandler;
import booking.backend.security.handler.BookingSuccessHandler;
import booking.backend.security.service.impl.UserDetailsServiceImpl;
import booking.backend.service.security.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserSecurityProvider userSecurityProvider;
  private final ProfileMapper profileMapper;

  @Autowired
  public SecurityConfig(
    UserSecurityProvider userSecurityProvider,
    ProfileMapper profileMapper
  ) {
    this.userSecurityProvider = userSecurityProvider;
    this.profileMapper = profileMapper;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.userDetailsService(userDetailsServiceBean());
    var daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService());
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

    auth.authenticationProvider(daoAuthenticationProvider);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public UserDetailsService userDetailsServiceBean() {
    return new UserDetailsServiceImpl(userSecurityProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .cors().disable()
      .csrf().disable()
      .logout()
      .logoutUrl("/user/logout")
      .and()
      .formLogin()
      .loginProcessingUrl("/user/login")
      .successHandler(new BookingSuccessHandler(userSecurityProvider, profileMapper))
      .failureHandler(new BookingFailureHandler())
      .and()
      .authorizeRequests()
      .mvcMatchers(HttpMethod.POST, "/user/login").not().authenticated()
      .anyRequest().permitAll()
      .and()
      .exceptionHandling().accessDeniedHandler(new BookingAccessDeniedHandler())
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
    ;
  }
}
