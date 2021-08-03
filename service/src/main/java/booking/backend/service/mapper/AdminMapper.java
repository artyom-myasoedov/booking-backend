package booking.backend.service.mapper;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.BookingEntity;
import booking.backend.service.model.AdminDto;
import booking.backend.service.model.BookingDto;
import org.mapstruct.Mapper;

import java.awt.*;
import java.util.List;

@Mapper
public interface AdminMapper {

  AdminDto fromEntity(AdminEntity adminEntity);

  AdminEntity toEntity(AdminDto aminDto);

  List<AdminDto> fromEntities(Iterable<AdminEntity> bookingEntities);
}
