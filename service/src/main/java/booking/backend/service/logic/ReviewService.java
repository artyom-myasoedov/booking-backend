package booking.backend.service.logic;

import booking.backend.service.model.*;

import javax.validation.Valid;

public interface ReviewService {

  ReviewDto createReview(@Valid ReviewCreateDto dto);

  ReviewDto updateReview(@Valid ReviewUpdateDto dto);

  void deleteReviewById(Integer id);

  ReviewDto findById(Integer id);

  PageDto<ReviewDto> find(String search, Integer pageSize, Integer pageNumber);

  PageDto<ReviewDto> findByCriteria(Integer ratedEntityId,
                                  Integer authorId,
                                  Integer reviewTargetId,
                                  Integer minRating,
                                  Integer maxRating,
                                  String sortOrder,
                                  String sortBy,
                                  Integer pageSize,
                                  Integer pageNumber);
}
