package booking.backend.db.provider.impl;

import booking.backend.db.entity.RoomReviewEntity;
import booking.backend.db.provider.RoomReviewProvider;
import booking.backend.db.repository.RoomReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoomReviewProviderImpl implements RoomReviewProvider {

  private final RoomReviewRepository roomReviewRepository;

  @Autowired
  public RoomReviewProviderImpl(RoomReviewRepository roomReviewRepository) {
    this.roomReviewRepository = roomReviewRepository;
  }

  @Override
  public Page<RoomReviewEntity> findReviews(String search, Pageable pageable) {
    if (search == null) {
      return roomReviewRepository.findAll(pageable);
    }
    return roomReviewRepository.findReviews(search, pageable);
  }

  @Override
  public RoomReviewEntity save(RoomReviewEntity reviewDto) {
    return roomReviewRepository.save(reviewDto);
  }

  @Override
  public Optional<RoomReviewEntity> findById(Integer id) {
    return roomReviewRepository.findById(id);
  }

  @Override
  public Iterable<RoomReviewEntity> findAll() {
    return roomReviewRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    roomReviewRepository.deleteById(id);
  }

  @Override
  public Integer countIdenticalTuplesOfPrimaryKey(Integer authorId, Integer roomId) {
    return roomReviewRepository.checkIdentityForPrimaryKey(authorId, roomId);
  }

  @Override
  public Integer countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(Integer id,
                                                                        Integer authorId,
                                                                        Integer roomId) {
    return roomReviewRepository.checkIdentityForPrimaryKeyAccountingCurrentTuple(id, authorId, roomId);
  }

  @Override
  public Page<RoomReviewEntity> findByCriteria(Integer ratedEntityId,
                                               Integer authorId,
                                               Integer reviewTargetId,
                                               Integer minRating,
                                               Integer maxRating,
                                               String sortOrder,
                                               String sortBy,
                                               Pageable pageable) {
    return roomReviewRepository.findByCriteria(
      ratedEntityId,
      authorId,
      reviewTargetId,
      minRating,
      maxRating,
      sortOrder,
      sortBy,
      pageable);
  }
}
