package booking.backend.db.repository;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.BookingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
//  @Query(
//    ""
//      + "SELECT u "
//      + "FROM bookings u "
//      + "WHERE LOWER(room_id) like '?1'"
//  )
  Page<BookingEntity> findBookingEntitiesByTenantUsername(String search, Pageable pageable);

  Page<BookingEntity> findBookingEntitiesByRoomId(Integer id, Pageable page);

  Page<BookingEntity> findBookingEntitiesByTenantId(Integer id, Pageable page);
}
