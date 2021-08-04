package booking.backend.db.provider;

import booking.backend.db.entity.BookingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookingProvider {

  Page<BookingEntity> findBookings(String search, Pageable pageable);

  BookingEntity save(BookingEntity bookingEntity);

  void deleteById(Integer id);

  Optional<BookingEntity> findById(Integer id);

  Iterable<BookingEntity> findAll();
}
