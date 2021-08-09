package booking.backend.service.logic.impl;

import booking.backend.db.provider.UserReviewProvider;
import booking.backend.service.exceptions.EntityNotFoundException;
import booking.backend.service.logic.UserReviewService;
import booking.backend.service.mapper.UserReviewMapper;
import booking.backend.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class UserReviewServiceImpl implements UserReviewService {
  private final UserReviewMapper userReviewMapper;
  private final UserReviewProvider userReviewProvider;

  @Autowired
  public UserReviewServiceImpl(UserReviewMapper userReviewMapper, UserReviewProvider userReviewProvider) {
    this.userReviewMapper = userReviewMapper;
    this.userReviewProvider = userReviewProvider;
  }

  @Override
  public UserReviewDto createReview(UserReviewCreateDto dto) {
    return
      Optional.ofNullable(dto)
        .map(userReviewMapper::toEntity)
        .map(userReviewProvider::save)
        .map(userReviewMapper::fromEntity)
        .orElseThrow();
  }

  @Override
  @Transactional
  public UserReviewDto updateReview(UserReviewUpdateDto dto) {
    var userEntity = userReviewProvider.findById(dto.getId())
      .orElseThrow(() -> new EntityNotFoundException(dto.getId(), "Review"));
    userReviewMapper.toEntity(dto, userEntity);

    return userReviewMapper.fromEntity(userReviewProvider.save(userEntity));
  }

  @Override
  public void deleteReviewById(Integer id) {
    userReviewProvider.deleteById(id);
  }

  @Override
  public UserReviewDto findById(Integer id) {
    return userReviewProvider.findById(id)
      .map(userReviewMapper::fromEntity)
      .orElse(null);
  }

  @Override
  public PageDto<UserReviewDto> find(String search, Integer pageSize, Integer pageNumber) {
    var values = userReviewProvider.findReviews(
        search,
        Pageable
          .ofSize(pageSize)
          .withPage(pageNumber)
      )
      .map(userReviewMapper::fromEntity);

    return ImmutablePageDto.<UserReviewDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
