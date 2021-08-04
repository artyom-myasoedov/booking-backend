package booking.backend.db.provider.impl;

import booking.backend.db.entity.BookingEntity;
import booking.backend.db.provider.BookingProvider;
import booking.backend.db.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingProviderImpl implements BookingProvider {

  private final BookingRepository bookingRepository;

  @Autowired
  public BookingProviderImpl(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  @Override
  public Page<BookingEntity> findBookings(String search, Pageable pageable) {
    if (search == null) {
      return bookingRepository.findAll(pageable);
    }
    return bookingRepository.findBookings(search, pageable);
  }

  @Override
  public BookingEntity save(BookingEntity bookingEntity) {
    return bookingRepository.save(bookingEntity);
  }

  @Override
  public void deleteById(Integer id) {
    bookingRepository.deleteById(id);
  }

  @Override
  public Optional<BookingEntity> findById(Integer id) {
    return bookingRepository.findById(id);
  }

  @Override
  public Iterable<BookingEntity> findAll() {
    return bookingRepository.findAll();
  }
}
