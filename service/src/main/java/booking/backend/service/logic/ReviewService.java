package booking.backend.service.logic;

import booking.backend.service.model.PageDto;
import booking.backend.service.model.ReviewCreateDto;
import booking.backend.service.model.ReviewDto;
import booking.backend.service.model.ReviewUpdateDto;

import javax.validation.Valid;

public interface ReviewService {
  
  ReviewDto createReview(@Valid ReviewCreateDto dto);

  ReviewDto updateReview(@Valid ReviewUpdateDto dto);

  void deleteReviewById(Integer id);

  ReviewDto findById(Integer id);

  PageDto<ReviewDto> find(String search, Integer pageSize, Integer pageNumber);
}
