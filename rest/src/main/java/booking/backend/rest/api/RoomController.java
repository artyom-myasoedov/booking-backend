package booking.backend.rest.api;


import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRoom;
import booking.backend.service.logic.RoomService;
import booking.backend.service.model.PageDto;
import booking.backend.service.model.RoomCreateDto;
import booking.backend.service.model.RoomDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
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
  public PageDto<RoomDto> findByLandlordId(
    @RequestParam Integer landlordId,
    @RequestParam(defaultValue = "10") Integer pageSize,
    @RequestParam(defaultValue = "0") Integer pageNumber) {
    return roomService.findByLandlordId(landlordId, pageSize, pageNumber);
  }

  @GetMapping("/getAllRooms")
  public PageDto<RoomDto> findAll(
    @RequestParam(defaultValue = "10") Integer pageSize,
    @RequestParam(defaultValue = "0") Integer pageNumber
  ) {
    return roomService.findAll(pageSize, pageNumber);
  }

  @GetMapping("/byCriteria")
  @ResponseStatus(HttpStatus.OK)
  public PageDto<RoomDto> findByCriteria(
    @RequestParam(defaultValue = "0") Integer minSquare,
    @RequestParam(defaultValue = "99999999") Integer maxSquare,
    @RequestParam(defaultValue = "0") Integer minNumberOfPeople,
    @RequestParam(defaultValue = "99999999") Integer maxNumberOfPeople,
    @RequestParam(defaultValue = "0") Integer minRentalPeriod,
    @RequestParam(defaultValue = "BY_HOUR,BY_DAY,BY_WEEK,BY_MONTH") List<TypeOfRent> typesOfRent,
    @RequestParam(defaultValue = "CLASS,THEATRE,ROUND_TABLE,CONVERSATION") List<TypeOfRoom> typesOfRoom,
    @RequestParam(defaultValue = "0") BigDecimal minPrice,
    @RequestParam(defaultValue = "99999999") BigDecimal maxPrice,
    @RequestParam(defaultValue = "") String addressLike,
    @RequestParam(defaultValue = "") String landlordUsernameLike,
    @RequestParam(defaultValue = "0") Double minRating,
    @RequestParam(defaultValue = "") String startOfBooking,
    @RequestParam(defaultValue = "") String endOfBooking,
    @RequestParam(defaultValue = "ASC") String sortOrder,
    @RequestParam(defaultValue = "rating") String sortBy,
    @RequestParam(defaultValue = "10") Integer pageSize,
    @RequestParam(defaultValue = "0") Integer pageNumber
  ) {

    return roomService.findByCriteria(
      minSquare, maxSquare, minNumberOfPeople,
      maxNumberOfPeople, minRentalPeriod, typesOfRent,
      typesOfRoom, minPrice, maxPrice,
      addressLike, landlordUsernameLike, minRating,
      startOfBooking, endOfBooking, sortOrder,
      sortBy, pageSize, pageNumber);
  }
}
