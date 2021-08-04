package booking.backend.service.logic.impl;

import booking.backend.db.provider.ReviewProvider;
import booking.backend.service.logic.ReviewService;
import booking.backend.service.mapper.ReviewMapper;
import booking.backend.service.model.ReviewDto;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImpl implements ReviewService {
  private final ReviewMapper reviewMapper;
  private final ReviewProvider reviewProvider;

  public ReviewServiceImpl(ReviewMapper reviewMapper, ReviewProvider reviewProvider) {
    this.reviewMapper = reviewMapper;
    this.reviewProvider = reviewProvider;
  }

  @Override
  public ReviewDto createReview(ReviewDto dto) {
    return
            Optional.ofNullable(dto)
                    .map(reviewMapper::toEntity)
                    .map(reviewProvider::save)
                    .map(reviewMapper::fromEntity)
                    .orElseThrow();
  }

  @Override
  public ReviewDto updateReview(ReviewDto dto) {
    return createReview(dto);
  }

  @Override
  public void deleteReviewById(int id) {
    reviewProvider.deleteById(id);
  }

  @Override
  public List<ReviewDto> find(String search, Integer pageSize, Integer pageNumber) {
    return null;
  }

  @Override
  public List<ReviewDto> findAll() {
    return reviewMapper.fromEntities(reviewProvider.findAll());
  }
}
