package booking.backend.db.provider;

import booking.backend.db.entity.UserEntity;

public interface UserSecurityProvider {
  UserEntity findByUsername(String username);
}
