package booking.backend.service.mapper;

import booking.backend.db.entity.BookingEntity;
import booking.backend.service.model.BookingCreateDto;
import booking.backend.service.model.BookingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {UserMapper.class, RoomMapper.class})
public interface BookingMapper {


  BookingDto fromEntity(BookingEntity adminEntity);

  BookingEntity toEntity(BookingDto bookingDto);

  List<BookingDto> fromEntities(Iterable<BookingEntity> bookingEntities);

  BookingEntity toEntity(BookingCreateDto bookingCreateDto);
}
