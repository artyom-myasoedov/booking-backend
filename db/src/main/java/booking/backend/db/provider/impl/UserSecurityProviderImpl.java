package booking.backend.db.provider.impl;

import booking.backend.db.entity.UserEntity;
import booking.backend.db.provider.UserSecurityProvider;
import booking.backend.db.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityProviderImpl implements UserSecurityProvider {

  private final UserRepository repository;

  public UserSecurityProviderImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public UserEntity findByUsername(String username) {
    return repository.findByUsernameEqualsIgnoreCase(username);
  }
}
