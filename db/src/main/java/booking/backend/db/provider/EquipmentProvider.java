package booking.backend.db.provider;

import booking.backend.db.entity.EquipmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EquipmentProvider {

  Optional<EquipmentEntity> findById(Integer equipmentId);

  void deleteById(Integer equipmentId);

  Page<EquipmentEntity> findByRoomId(Integer roomId, Pageable pageable);

  EquipmentEntity save(EquipmentEntity entity);
}
