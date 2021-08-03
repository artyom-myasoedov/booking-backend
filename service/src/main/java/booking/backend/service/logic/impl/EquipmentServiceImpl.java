package booking.backend.service.logic.impl;

import booking.backend.db.repository.EquipmentRepository;
import booking.backend.db.repository.RoomRepository;
import booking.backend.service.logic.EquipmentService;
import booking.backend.service.mapper.EquipmentMapper;
import booking.backend.service.mapper.RoomMapper;
import booking.backend.service.model.EquipmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService{

  private final EquipmentMapper equipmentMapper;

  private final EquipmentRepository equipmentRepository;

  @Autowired
  public EquipmentServiceImpl(EquipmentMapper equipmentMapper, EquipmentRepository equipmentRepository) {
    this.equipmentMapper = equipmentMapper;
    this.equipmentRepository = equipmentRepository;
  }

  @Override
  public EquipmentDto findById(Integer equipmentId) {
    return null;
  }

  @Override
  public void deleteById(Integer equipmentId) {

  }

  @Override
  public List<EquipmentDto> findByRoomId(Integer roomId) {
    return null;
  }

  @Override
  public EquipmentDto updateEquipment(EquipmentDto equipment) {
    return null;
  }

  @Override
  public EquipmentDto addEquipment(EquipmentDto equipment) {
    return null;
  }
}
