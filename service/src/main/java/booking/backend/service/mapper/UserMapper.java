package booking.backend.service.mapper;

import booking.backend.db.entity.UserEntity;
import booking.backend.service.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

  UserDto fromEntity(UserEntity userEntity);

  @Mapping(target = "password", ignore = true)
  UserEntity toEntity(UserDto userDto);

  List<UserDto> fromEntities(Iterable<UserEntity> userEntities);
}
