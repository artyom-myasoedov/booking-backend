package booking.backend.service.logic.impl;

import booking.backend.db.provider.ReviewProvider;
import booking.backend.service.exceptions.EntityNotFoundException;
import booking.backend.service.logic.ReviewService;
import booking.backend.service.mapper.ReviewMapper;

import booking.backend.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class ReviewServiceImpl implements ReviewService {
  private final ReviewMapper reviewMapper;
  private final ReviewProvider reviewProvider;

  @Autowired
  public ReviewServiceImpl(ReviewMapper reviewMapper, ReviewProvider reviewProvider) {
    this.reviewMapper = reviewMapper;
    this.reviewProvider = reviewProvider;
  }

  @Override
  public ReviewDto createReview(ReviewCreateDto dto) {
    return
      Optional.ofNullable(dto)
        .map(reviewMapper::toEntity)
        .map(reviewProvider::save)
        .map(reviewMapper::fromEntity)
        .orElseThrow();
  }

  @Override
  @Transactional
  public ReviewDto updateReview(ReviewUpdateDto dto) {
    var userEntity = reviewProvider.findById(dto.getId())
      .orElseThrow(() -> new EntityNotFoundException(dto.getId(), "Review"));
    reviewMapper.toEntity(dto, userEntity);

    return reviewMapper.fromEntity(reviewProvider.save(userEntity));
  }

  @Override
  public void deleteReviewById(Integer id) {
    reviewProvider.deleteById(id);
  }

  @Override
  public ReviewDto findById(Integer id) {
    return reviewProvider.findById(id)
      .map(reviewMapper::fromEntity)
      .orElse(null);
  }

  @Override
  public PageDto<ReviewDto> find(String search, Integer pageSize, Integer pageNumber) {
    var values = reviewProvider.findReviews(
        search,
        Pageable
          .ofSize(pageSize)
          .withPage(pageNumber)
      )
      .map(reviewMapper::fromEntity);

    return ImmutablePageDto.<ReviewDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
