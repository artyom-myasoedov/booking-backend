package booking.backend.service.mapper;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.UserEntity;
import booking.backend.service.model.AdminCreateDto;
import booking.backend.service.model.AdminDto;
import booking.backend.service.model.AdminUpdateDto;
import booking.backend.service.model.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AdminMapper {

  AdminDto fromEntity(AdminEntity adminEntity);

  void toEntity(AdminUpdateDto dto, @MappingTarget AdminEntity original);

  AdminEntity toEntity(AdminDto aminDto);

  List<AdminDto> fromEntities(Iterable<AdminEntity> bookingEntities);

  AdminEntity toEntity(AdminCreateDto dto);
}
