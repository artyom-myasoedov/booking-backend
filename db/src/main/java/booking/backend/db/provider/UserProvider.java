package booking.backend.db.provider;

import booking.backend.commons.Role;
import booking.backend.db.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserProvider {

  Page<UserEntity> findUsers(String search, Pageable pageable);

  UserEntity save(UserEntity userEntity);

  Optional<UserEntity> findById(int id);

  void deleteById(int id);

  boolean isUsernameUnique(String value);

  boolean isUsernameUnique(Integer id, String username);

  boolean isRoleIdentical(Integer id, Role role);
}
