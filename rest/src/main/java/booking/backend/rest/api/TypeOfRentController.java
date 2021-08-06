package booking.backend.rest.api;

import booking.backend.service.logic.TypeOfRentService;
import booking.backend.service.model.TypeOfRentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeOfRent")
public class TypeOfRentController {

  private final TypeOfRentService typeOfRentService;

  @Autowired
  public TypeOfRentController(TypeOfRentService typeOfRentService) {
    this.typeOfRentService = typeOfRentService;
  }

  @GetMapping
  public TypeOfRentDto getTypeOfRent(
    @RequestParam(name = "type_of_rent_id") Integer typeOfRentId,
    @RequestParam(name = "room_id") Integer roomId) {
    return typeOfRentService.findById(typeOfRentId, roomId);
  }

  @DeleteMapping
  public void deleteTypeOfRent(
    @RequestParam(name = "type_of_rent_id") Integer typeOfRentId,
    @RequestParam(name = "room_id") Integer roomId) {
    typeOfRentService.deleteById(typeOfRentId, roomId);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public TypeOfRentDto updateTypeOfRent(@RequestBody TypeOfRentDto typeOfRent) {
    return typeOfRentService.updateTypeOfRent(typeOfRent);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public TypeOfRentDto addTypeOfRent(@RequestBody TypeOfRentDto typeOfRent) {
    return typeOfRentService.addTypeOfRent(typeOfRent);
  }

  @GetMapping("/byRoomId")
  @ResponseStatus(HttpStatus.OK)
  public List<TypeOfRentDto> getTypesOfRentByRoomId(
    @RequestParam Integer roomId) {
    return typeOfRentService.findByRoomId(roomId);
  }


}
