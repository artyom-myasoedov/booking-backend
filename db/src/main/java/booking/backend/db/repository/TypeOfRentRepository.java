package booking.backend.db.repository;

import booking.backend.db.entity.RoomTypeOfRentId;
import booking.backend.db.entity.TypeOfRentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfRentRepository extends JpaRepository<TypeOfRentEntity, RoomTypeOfRentId> {
}
