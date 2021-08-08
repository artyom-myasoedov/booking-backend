package booking.backend.rest.api;

import booking.backend.service.logic.ReviewService;
import booking.backend.service.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping
  PageDto<ReviewDto> findReviews(
    @RequestParam(required = false) String search,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {

    return reviewService.find(search, pageSize, pageNumber);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping("/{id}")
  ReviewDto getReview(@PathVariable int id) {
    return reviewService.findById(id);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping("/byCriteria")
  @ResponseStatus(HttpStatus.OK)
  public PageDto<ReviewDto> findByCriteria(
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
    return reviewService.findByCriteria(ratedEntityId, authorId,
      reviewTargetId, minRating,
      maxRating, sortOrder,
      sortBy, pageSize, pageNumber);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @ResponseStatus(HttpStatus.CREATED) // возвращаем 201 как в каноничномъ REST
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ReviewDto createReview(@RequestBody ReviewCreateDto review) {
    return reviewService.createReview(review);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @PutMapping
  ReviewDto updateReview(@RequestBody ReviewUpdateDto review) {
    return reviewService.updateReview(review);
  }

  @Secured("ROLE_ADMIN")
  @DeleteMapping("/{id}")
  void deleteReview(@PathVariable int id) {
    reviewService.deleteReviewById(id);
  }
}
