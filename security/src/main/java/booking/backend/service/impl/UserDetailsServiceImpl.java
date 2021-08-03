//package booking.backend.service.impl;
//
//import booking.backend.db.entity.UserEntity;
//import booking.backend.db.repository.AdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//  private AdminRepository adminRepository;
//
//  @Bean
//  @Autowired
//  public UserDetailsServiceImpl(AdminRepository adminRepository) {
//    this.adminRepository = adminRepository;
//  }
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    UserEntity x = adminRepository.findAllByUsernameEqualsIgnoreCase(username);
//    return new User(x.getUsername(), x.getPassword(), List.of());
//  }
//}
