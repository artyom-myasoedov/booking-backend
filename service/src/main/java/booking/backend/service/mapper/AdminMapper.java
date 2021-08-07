package booking.backend.service.mapper;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.RoomEntity;
import booking.backend.service.model.AdminCreateDto;
import booking.backend.service.model.AdminDto;
import booking.backend.service.model.RoomCreateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

  AdminDto fromEntity(AdminEntity adminEntity);

  AdminEntity toEntity(AdminDto aminDto);

  List<AdminDto> fromEntities(Iterable<AdminEntity> bookingEntities);

  AdminEntity toEntity(AdminCreateDto dto);
}
