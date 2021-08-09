package booking.backend.service.logic;

import booking.backend.service.model.PageDto;
import booking.backend.service.model.UserReviewCreateDto;
import booking.backend.service.model.UserReviewDto;
import booking.backend.service.model.UserReviewUpdateDto;

import javax.validation.Valid;

public interface UserReviewService {
  UserReviewDto createReview(@Valid UserReviewCreateDto dto);

  UserReviewDto updateReview(@Valid UserReviewUpdateDto dto);

  void deleteReviewById(Integer id);

  UserReviewDto findById(Integer id);

  PageDto<UserReviewDto> find(String search, Integer pageSize, Integer pageNumber);

}
