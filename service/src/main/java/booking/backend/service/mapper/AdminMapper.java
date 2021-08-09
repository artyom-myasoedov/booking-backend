package booking.backend.service.mapper;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.UserEntity;
import booking.backend.service.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AdminMapper {

  AdminDto fromEntity(UserEntity adminEntity);

  void toEntity(AdminUpdateDto dto, @MappingTarget UserEntity original);

  UserEntity toEntity(AdminDto aminDto);

  List<AdminDto> fromEntities(Iterable<UserEntity> bookingEntities);

  UserEntity toEntity(AdminCreateDto dto);
}
