package booking.backend.db.repository;

import booking.backend.db.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity , Integer> {

}
