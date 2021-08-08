package booking.backend.rest.api;

import booking.backend.service.logic.RoomReviewService;
import booking.backend.service.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class RoomReviewController {
  private final RoomReviewService roomReviewService;

  public RoomReviewController(RoomReviewService roomReviewService) {
    this.roomReviewService = roomReviewService;
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping
  PageDto<RoomReviewDto> findReviews(
    @RequestParam(required = false) String search,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {

    return roomReviewService.find(search, pageSize, pageNumber);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping("/{id}")
  RoomReviewDto getReview(@PathVariable int id) {
    return roomReviewService.findById(id);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping("/byCriteria")
  @ResponseStatus(HttpStatus.OK)
  public PageDto<RoomReviewDto> findByCriteria(
    @RequestParam(defaultValue = "") Integer ratedEntityId,
    @RequestParam(defaultValue = "") Integer authorId,
    @RequestParam(defaultValue = "") Integer reviewTargetId,
    @RequestParam(defaultValue = "0") Integer minRating,
    @RequestParam(defaultValue = "99999999") Integer maxRating,
    @RequestParam(defaultValue = "ASC") String sortOrder,
    @RequestParam(defaultValue = "rating") String sortBy,
    @RequestParam(defaultValue = "10") Integer pageSize,
    @RequestParam(defaultValue = "0") Integer pageNumber
  ) {
    return roomReviewService.findByCriteria(ratedEntityId, authorId,
      reviewTargetId, minRating,
      maxRating, sortOrder,
      sortBy, pageSize, pageNumber);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @ResponseStatus(HttpStatus.CREATED) // возвращаем 201 как в каноничномъ REST
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  RoomReviewDto createReview(@RequestBody RoomReviewCreateDto review) {
    return roomReviewService.createReview(review);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @PutMapping
  RoomReviewDto updateReview(@RequestBody RoomReviewUpdateDto review) {
    return roomReviewService.updateReview(review);
  }

  @Secured("ROLE_ADMIN")
  @DeleteMapping("/{id}")
  void deleteReview(@PathVariable int id) {
    roomReviewService.deleteReviewById(id);
  }
}
