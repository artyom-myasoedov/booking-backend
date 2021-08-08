package booking.backend.rest.api;

import booking.backend.service.logic.ReviewService;
import booking.backend.service.model.PageDto;

import booking.backend.service.model.ReviewCreateDto;
import booking.backend.service.model.ReviewDto;

import booking.backend.service.model.ReviewUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping
  PageDto<ReviewDto> findReviews(
    @RequestParam(required = false) String search,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {

    return reviewService.find(search, pageSize, pageNumber);
  }

  @GetMapping("/{id}")
  ReviewDto getReview(@PathVariable int id) {
    return reviewService.findById(id);
  }

  @ResponseStatus(HttpStatus.CREATED) // возвращаем 201 как в каноничномъ REST
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ReviewDto createReview(@RequestBody ReviewCreateDto review) {
    return reviewService.createReview(review);
  }

  @PutMapping
  ReviewDto updateReview(@RequestBody ReviewUpdateDto review) {
    return reviewService.updateReview(review);
  }

  @DeleteMapping("/{id}")
  void deleteReview(@PathVariable int id) {
    reviewService.deleteReviewById(id);
  }
}
