package booking.backend.db.provider.impl;

import booking.backend.commons.Role;
import booking.backend.db.entity.UserEntity;
import booking.backend.db.provider.UserProvider;
import booking.backend.db.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserProviderImpl implements UserProvider {
  private static final Logger logger = LoggerFactory.getLogger(UserProviderImpl.class);

  private final UserRepository userRepository;

  @Autowired
  public UserProviderImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Page<UserEntity> findUsers(String search, Pageable pageable) {
    if (search == null) {
      return userRepository.findAll(pageable);
    }
    return userRepository.findUsers(search, pageable);
  }

  @Override
  public UserEntity save(UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  @Override
  public Optional<UserEntity> findById(int id) {
    return userRepository.findById(id);
  }

  @Override
  public void deleteById(int id) {
    userRepository.deleteById(id);
  }

  @Override
  public boolean isUsernameExists(String value) {
    return userRepository.existsByUsernameIgnoreCase(value);
  }

  @Override
  public boolean isUsernameExists(Integer id, String username) {
    return userRepository.existsByIdIsNotAndUsernameIgnoreCase(id, username);
  }

  @Override
  public boolean isRoleIdentical(Integer id, Role role) {
    return userRepository.existsByIdAndRole(id, role);
  }
}
