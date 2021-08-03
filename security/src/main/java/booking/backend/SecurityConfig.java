//package booking.backend;
//
//import booking.backend.db.repository.AdminRepository;
//import booking.backend.service.impl.UserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
////
//import org.springframework.con
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//  private AdminRepository adminRepository;
//
//  public SecurityConfig(AdminRepository adminRepository) {
//    this.adminRepository = adminRepository;
//  }
//
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(userDetailsService());
//  }
//  @Bean
//  @Override
//  public UserDetailsService userDetailsServiceBean() throws Exception{
//    return new UserDetailsServiceImpl(adminRepository);
//  }
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.formLogin()
//      .loginProcessingUrl("auth/login")
//      .successHandler(null)
//      .failureHandler(null)
//      ;
//  }
//}
