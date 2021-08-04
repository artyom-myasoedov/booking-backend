package booking.backend.service.logic;

import booking.backend.service.model.BookingDto;

import java.util.List;

public interface BookingService {
  BookingDto createBooking(BookingDto bookingDto);

  BookingDto updateBooking(BookingDto bookingDto);

  void deleteAdminById(Integer id);

  List<BookingDto> find(String search, Integer pageSize, Integer pageNumber);

  List<BookingDto> findAll(Iterable<BookingDto> bookings);
}
