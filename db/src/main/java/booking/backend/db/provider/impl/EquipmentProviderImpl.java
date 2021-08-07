package booking.backend.db.provider.impl;

import booking.backend.db.entity.EquipmentEntity;
import booking.backend.db.provider.EquipmentProvider;
import booking.backend.db.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EquipmentProviderImpl implements EquipmentProvider {

  private final EquipmentRepository equipmentRepository;

  @Autowired
  public EquipmentProviderImpl(EquipmentRepository equipmentRepository) {
    this.equipmentRepository = equipmentRepository;
  }

  @Override
  public Optional<EquipmentEntity> findById(Integer equipmentId) {
    return equipmentRepository.findById(equipmentId);
  }

  @Override
  public void deleteById(Integer equipmentId) {
    equipmentRepository.deleteById(equipmentId);
  }

  @Override
  public Page<EquipmentEntity> findByRoomId(Integer roomId, Pageable pageable) {
    return equipmentRepository.findByRoomId(roomId, pageable);
  }

  @Override
  public EquipmentEntity save(EquipmentEntity entity) {
    return equipmentRepository.save(entity);
  }
}
