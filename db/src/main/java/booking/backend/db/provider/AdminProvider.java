package booking.backend.db.provider;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AdminProvider {

  Page<UserEntity> findByUsername(String search, Pageable pageable);

  UserEntity save(UserEntity userEntity);

  Optional<UserEntity> findById(Integer id);

  Iterable<UserEntity> findAll();

  void deleteById(Integer id);

  boolean isUsernameUnique(String value);

  boolean isUsernameUnique(Integer id, String username);
}
