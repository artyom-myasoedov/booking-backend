package booking.backend.security.service.impl;

import booking.backend.db.entity.UserEntity;
import booking.backend.db.provider.UserSecurityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserSecurityProvider provider;

  @Autowired
  public UserDetailsServiceImpl(UserSecurityProvider provider) {
    this.provider = provider;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity x = provider.findByUsername(username);

    return new User(x.getUsername(),
      x.getPassword(),
      List.of(new SimpleGrantedAuthority("ROLE_" + x.getRole().name())));
  }
}
