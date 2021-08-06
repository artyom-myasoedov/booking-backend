package booking.backend.rest.api;

import booking.backend.service.logic.EquipmentService;
import booking.backend.service.model.EquipmentCreateDto;
import booking.backend.service.model.EquipmentDto;
import booking.backend.service.model.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

  private final EquipmentService equipmentService;

  @Autowired
  public EquipmentController(EquipmentService equipmentService) {
    this.equipmentService = equipmentService;
  }

  @GetMapping(path = "/{equipmentId}")
  public EquipmentDto getEquipment(
    @PathVariable Integer equipmentId) {
    return equipmentService.findById(equipmentId);
  }

  @DeleteMapping(path = "/{equipmentId}")
  public void deleteEquipment(
    @PathVariable Integer equipmentId) {
    equipmentService.deleteById(equipmentId);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public EquipmentDto updateEquipment(@RequestBody EquipmentDto equipment) {
    return equipmentService.updateEquipment(equipment);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public EquipmentDto addEquipment(@RequestBody EquipmentCreateDto equipment) {
    return equipmentService.addEquipment(equipment);
  }

  @GetMapping("/byRoomId")
  @ResponseStatus(HttpStatus.OK)
  public PageDto<EquipmentDto> getEquipmentsByRoomId(
    @RequestParam Integer roomId,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber) {
    return equipmentService.findByRoomId(roomId, pageSize, pageNumber);
  }
}
