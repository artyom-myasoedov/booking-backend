package booking.backend.db.repository;

import booking.backend.db.entity.EquipmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Integer> {

  Page<EquipmentEntity> findByRoomId(Integer roomId, Pageable pageable);


}
