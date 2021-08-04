package booking.backend.service.logic.impl;

import booking.backend.db.provider.BookingProvider;
import booking.backend.service.logic.BookingService;
import booking.backend.service.mapper.BookingMapper;
import booking.backend.service.model.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
  private final BookingMapper bookingMapper;

  private final BookingProvider bookingProvider;

  @Autowired
  public BookingServiceImpl(BookingMapper bookingMapper, BookingProvider bookingProvider) {
    this.bookingMapper = bookingMapper;
    this.bookingProvider = bookingProvider;
  }

  @Override
  public BookingDto createBooking(BookingDto bookingDto) {
    return
            Optional.ofNullable(bookingDto)
                    .map(bookingMapper::toEntity)
                    .map(bookingProvider::save)
                    .map(bookingMapper::fromEntity)
                    .orElseThrow();
  }

  @Override
  public BookingDto updateBooking(BookingDto bookingDto) {
    return createBooking(bookingDto);
  }

  @Override
  public void deleteAdminById(Integer id) {
    bookingProvider.deleteById(id);
  }

  @Override
  public List<BookingDto> find(String search, Integer pageSize, Integer pageNumber) {
    return null;
  }

  @Override
  public List<BookingDto> findAll(Iterable<BookingDto> bookings) {
    return bookingMapper.fromEntities(bookingProvider.findAll());
  }
}
