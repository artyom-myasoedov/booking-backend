package booking.backend.rest.api;


import booking.backend.service.logic.RoomService;
import booking.backend.service.model.RoomCreateDto;
import booking.backend.service.model.RoomDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {


  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping("/{roomId}")
  public RoomDto findById(@PathVariable Integer roomId) {
    return roomService.findById(roomId);
  }

  @DeleteMapping("/{roomId}")
  public void deleteById(@PathVariable Integer roomId) {
    roomService.deleteById(roomId);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public RoomDto addRoom(@RequestBody RoomCreateDto room) {
    return roomService.addRoom(room);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public RoomDto updateRoom(@RequestBody RoomDto room) {
    return roomService.updateRoom(room);
  }

  @GetMapping("/byLandlordId")
  public List<RoomDto> findByLandlordId(@RequestParam Integer landlordId) {
    return roomService.findByLandlordId(landlordId);
  }

  @GetMapping("/getAllRooms")
  public List<RoomDto> findAll() {
    return roomService.findAll();
  }

  //TODO запрос на список комнат со сложными критериями выбора
}
