package booking.backend.service.logic;

import booking.backend.service.model.BookingCreateDto;
import booking.backend.service.model.BookingDto;
import booking.backend.service.model.PageDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookingService {
  BookingDto createBooking(BookingCreateDto bookingDto);

  BookingDto updateBooking(BookingDto bookingDto);

  BookingDto findById(Integer id);

  void deleteBookingById(Integer id);

  PageDto<BookingDto> find(String search, Integer pageSize, Integer pageNumber);

  List<BookingDto> findAll();

  PageDto<BookingDto> findByRoomId(Integer id, Integer pageSize, Integer pageNumber);

  PageDto<BookingDto> findByTenantId(Integer id, Integer pageSize, Integer pageNumber);
}
