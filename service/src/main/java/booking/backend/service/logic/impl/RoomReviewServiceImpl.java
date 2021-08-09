package booking.backend.service.logic.impl;

import booking.backend.db.provider.RoomReviewProvider;
import booking.backend.service.exceptions.EntityNotFoundException;
import booking.backend.service.logic.RoomReviewService;
import booking.backend.service.mapper.RoomReviewMapper;

import booking.backend.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class RoomReviewServiceImpl implements RoomReviewService {
  private final RoomReviewMapper roomReviewMapper;
  private final RoomReviewProvider roomReviewProvider;

  @Autowired
  public RoomReviewServiceImpl(RoomReviewMapper roomReviewMapper, RoomReviewProvider roomReviewProvider) {
    this.roomReviewMapper = roomReviewMapper;
    this.roomReviewProvider = roomReviewProvider;
  }

  @Override
  public RoomReviewDto createReview(RoomReviewCreateDto dto) {
    return
      Optional.ofNullable(dto)
        .map(roomReviewMapper::toEntity)
        .map(roomReviewProvider::save)
        .map(roomReviewMapper::fromEntity)
        .orElseThrow();
  }

  @Override
  @Transactional
  public RoomReviewDto updateReview(RoomReviewUpdateDto dto) {
    var userEntity = roomReviewProvider.findById(dto.getId())
      .orElseThrow(() -> new EntityNotFoundException(dto.getId(), "Review"));
    roomReviewMapper.toEntity(dto, userEntity);

    return roomReviewMapper.fromEntity(roomReviewProvider.save(userEntity));
  }

  @Override
  public void deleteReviewById(Integer id) {
    roomReviewProvider.deleteById(id);
  }

  @Override
  public RoomReviewDto findById(Integer id) {
    return roomReviewProvider.findById(id)
      .map(roomReviewMapper::fromEntity)
      .orElse(null);
  }

  @Override
  public PageDto<RoomReviewDto> find(String search, Integer pageSize, Integer pageNumber) {
    var values = roomReviewProvider.findReviews(
        search,
        Pageable
          .ofSize(pageSize)
          .withPage(pageNumber)
      )
      .map(roomReviewMapper::fromEntity);

    return ImmutablePageDto.<RoomReviewDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<RoomReviewDto> findByCriteria(Integer ratedEntityId,
                                               Integer authorId,
                                               Integer reviewTargetId,
                                               Integer minRating,
                                               Integer maxRating,
                                               String sortOrder,
                                               String sortBy,
                                               Integer pageSize,
                                               Integer pageNumber) {
    var values = roomReviewProvider.findByCriteria(
        ratedEntityId,
        authorId,
        reviewTargetId,
        minRating,
        maxRating,
        sortOrder,
        sortBy,
        Pageable
          .ofSize(pageSize)
          .withPage(pageNumber)
      )
      .map(roomReviewMapper::fromEntity);

    return ImmutablePageDto.<RoomReviewDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
