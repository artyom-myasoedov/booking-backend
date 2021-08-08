package booking.backend.service.security;

import booking.backend.db.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProfileMapper {

  Profile toProfile(UserEntity entity);
}
