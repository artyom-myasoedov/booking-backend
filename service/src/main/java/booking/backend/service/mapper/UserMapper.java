package booking.backend.service.mapper;

import booking.backend.db.entity.UserEntity;
import booking.backend.service.model.UserCreateDto;
import booking.backend.service.model.UserDto;
import booking.backend.service.model.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface UserMapper {

  UserDto fromEntity(UserEntity userEntity);

  void toEntity(UserUpdateDto dto, @MappingTarget UserEntity original);

  UserEntity toEntity(UserCreateDto dto);

  List<UserDto> fromEntities(Iterable<UserEntity> userEntities);
}
