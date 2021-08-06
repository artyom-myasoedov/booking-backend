package booking.backend.service.logic;

import booking.backend.service.model.EquipmentCreateDto;
import booking.backend.service.model.EquipmentDto;
import booking.backend.service.model.PageDto;

public interface EquipmentService {

  EquipmentDto findById(Integer equipmentId);

  void deleteById(Integer equipmentId);

  PageDto<EquipmentDto> findByRoomId(Integer roomId, Integer pageSize, Integer pageNumber);

  EquipmentDto updateEquipment(EquipmentDto equipment);

  EquipmentDto addEquipment(EquipmentCreateDto equipment);

}
