package booking.backend.db.provider;

import booking.backend.db.entity.BookingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.Optional;

public interface BookingProvider {

  Page<BookingEntity> findByUserName(String search, Pageable pageable);

  BookingEntity save(BookingEntity bookingEntity);

  void deleteById(Integer id);

  Optional<BookingEntity> findById(Integer id);

  Iterable<BookingEntity> findAll();

  Page<BookingEntity> findByRoomId(Integer id, Pageable page);

  Page<BookingEntity> findByTenantId(Integer id, Pageable page);

}
