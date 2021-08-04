package booking.backend.service.logic;

import booking.backend.service.model.ReviewDto;

import java.util.List;

public interface ReviewService {
  
  ReviewDto createReview(ReviewDto dto);

  ReviewDto updateReview(ReviewDto dto);

  void deleteReviewById(int id);

  List<ReviewDto> find(String search, Integer pageSize, Integer pageNumber);

  List<ReviewDto> findAll();
}
