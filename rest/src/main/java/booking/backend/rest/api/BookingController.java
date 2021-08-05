package booking.backend.rest.api;

import booking.backend.service.logic.BookingService;
import booking.backend.service.model.AdminDto;
import booking.backend.service.model.BookingDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/booking")
public class BookingController {
  private final BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }
  @GetMapping
  List<BookingDto> findBookings(){
    return StreamSupport
      .stream(bookingService.findAll().spliterator(), false)
      .collect(Collectors.toList());
  }
  @PostMapping
  BookingDto createBooking(@RequestBody BookingDto bookingDto){
    return bookingService.createBooking(bookingDto);
  }

  @PutMapping
  BookingDto updateBooking(@RequestBody BookingDto bookingDto){
    return bookingService.updateBooking(bookingDto);
  }

  @DeleteMapping("/{id}")
  void deleteBooking(@PathVariable int id) {
    bookingService.deleteBookingById( id);
  }
}
