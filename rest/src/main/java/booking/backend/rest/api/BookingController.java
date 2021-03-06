package booking.backend.rest.api;

import booking.backend.service.logic.BookingService;
import booking.backend.service.model.BookingCreateDto;
import booking.backend.service.model.BookingDto;
import booking.backend.service.model.PageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
  private final BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }
  @GetMapping("/bookings")
  @Secured({"ROLE_ADMIN"})
  PageDto<BookingDto> findBookings(
    @RequestParam(required = false) String search,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {
    return bookingService.find(search, pageSize, pageNumber);
  }

  @GetMapping("/{id}")
  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  BookingDto findById(@PathVariable Integer id){
    return bookingService.findById(id);
  }

  @GetMapping("/byRoomId/{id}")
  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  PageDto<BookingDto> findByRoomId(
    @PathVariable Integer id,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {
    return bookingService.findByRoomId(id, pageSize, pageNumber);
  }

  @GetMapping("/byTenantId/{id}")
  @Secured({"ROLE_CLIENT", "ROLE_ADMIN"})
  PageDto<BookingDto> findByTenantId(
    @PathVariable Integer id,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {
    return bookingService.findByTenantId(id, pageSize, pageNumber);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  BookingDto addBooking(@RequestBody BookingCreateDto bookingDto){
    return bookingService.createBooking(bookingDto);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  BookingDto updateBooking(@RequestBody BookingDto bookingDto){
    return bookingService.updateBooking(bookingDto);
  }

  @DeleteMapping("/{id}")
  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  void deleteBooking(@PathVariable int id) {
    bookingService.deleteBookingById( id);
  }

}
