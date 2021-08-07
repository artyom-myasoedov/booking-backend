package booking.backend.service.mapper;

import booking.backend.db.entity.BookingEntity;
import booking.backend.service.model.BookingCreateDto;
import booking.backend.service.model.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {UserMapper.class, RoomMapper.class})
public interface BookingMapper {

  @Mapping(target = "room.id", source = "room.id")
  @Mapping(target = "tenant.id", source = "tenant.id")
  BookingDto fromEntity(BookingEntity adminEntity);

  BookingEntity toEntity(BookingDto bookingDto);

  List<BookingDto> fromEntities(Iterable<BookingEntity> bookingEntities);

//  @Mapping(source = "room.id", target = "room.id")
//  @Mapping(source = "tenant.id", target = "tenant.id")

  @Mapping(source = "room.id", target = "room.id")
  @Mapping(source = "tenant.id", target = "tenant.id")
  BookingEntity toEntity(BookingCreateDto bookingCreateDto);
}
