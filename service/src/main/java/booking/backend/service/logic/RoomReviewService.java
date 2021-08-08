package booking.backend.service.logic;

import booking.backend.service.model.*;

import javax.validation.Valid;

public interface RoomReviewService {

  RoomReviewDto createReview(@Valid RoomReviewCreateDto dto);

  RoomReviewDto updateReview(@Valid RoomReviewUpdateDto dto);

  void deleteReviewById(Integer id);

  RoomReviewDto findById(Integer id);

  PageDto<RoomReviewDto> find(String search, Integer pageSize, Integer pageNumber);

  PageDto<RoomReviewDto> findByCriteria(Integer ratedEntityId,
                                        Integer authorId,
                                        Integer reviewTargetId,
                                        Integer minRating,
                                        Integer maxRating,
                                        String sortOrder,
                                        String sortBy,
                                        Integer pageSize,
                                        Integer pageNumber);
}
