package booking.backend.rest.api;

import booking.backend.service.logic.UserReviewService;
import booking.backend.service.model.PageDto;
import booking.backend.service.model.UserReviewCreateDto;
import booking.backend.service.model.UserReviewDto;
import booking.backend.service.model.UserReviewUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userReview")
public class UserReviewController {
  private final UserReviewService userReviewService;

  public UserReviewController(UserReviewService userReviewService) {
    this.userReviewService = userReviewService;
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping
  PageDto<UserReviewDto> findReviews(
    @RequestParam(required = false) String search,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {

    return userReviewService.find(search, pageSize, pageNumber);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping("/{id}")
  UserReviewDto getReview(@PathVariable int id) {
    return userReviewService.findById(id);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @ResponseStatus(HttpStatus.CREATED) // возвращаем 201 как в каноничномъ REST
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  UserReviewDto createReview(@RequestBody UserReviewCreateDto review) {
    return userReviewService.createReview(review);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @PutMapping
  UserReviewDto updateReview(@RequestBody UserReviewUpdateDto review) {
    return userReviewService.updateReview(review);
  }

  @Secured("ROLE_ADMIN")
  @DeleteMapping("/{id}")
  void deleteReview(@PathVariable int id) {
    userReviewService.deleteReviewById(id);
  }
}
