package booking.backend.db.provider.impl;

import booking.backend.db.EndDate;
import booking.backend.db.entity.AdminEntity;
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
  public Page<BookingEntity> findByUserName(String search, Pageable pageable) {
    if (search == null) {
      return bookingRepository.findAll(pageable);
    }
    return bookingRepository.findBookingEntitiesByTenantUsername(search, pageable);
  }

  @Override
  public BookingEntity save(BookingEntity bookingEntity) {
    bookingEntity.setRentalEndDate(EndDate.calculate(bookingEntity.getRentalStartDate(),
                                                      bookingEntity.getPeriodOfBooking()));
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

  @Override
  public Page<BookingEntity> findByRoomId(Integer id, Pageable pageable) {
    return bookingRepository.findBookingEntitiesByRoomId(id, pageable);
  }

  @Override
  public Page<BookingEntity> findByTenantId(Integer id, Pageable page) {
    return bookingRepository.findBookingEntitiesByTenantId(id, page);
  }
}
