package booking.backend.db.repository;

import booking.backend.db.entity.EquipmentEntity;
import booking.backend.db.entity.RoomEquipmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, RoomEquipmentId> {
}
