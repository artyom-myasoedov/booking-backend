package booking.backend.service.logic;

import booking.backend.service.model.EquipmentDto;

import java.util.List;

public interface EquipmentService {

  EquipmentDto findById(Integer equipmentId);

  void deleteById(Integer equipmentId);

  List<EquipmentDto> findByRoomId(Integer roomId);

  EquipmentDto updateEquipment(EquipmentDto equipment);

  EquipmentDto addEquipment(EquipmentDto equipment);

}
