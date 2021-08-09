package booking.backend.db.provider;

import booking.backend.db.entity.RoomReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoomReviewProvider {

  Page<RoomReviewEntity> findReviews(String search, Pageable pageable);

  RoomReviewEntity save(RoomReviewEntity reviewDto);

  Optional<RoomReviewEntity> findById(Integer id);

  Iterable<RoomReviewEntity> findAll();

  void deleteById(Integer id);

  Integer countIdenticalTuplesOfPrimaryKey(Integer authorId, Integer roomId);

  Integer countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(Integer id,
                                                                 Integer authorId,
                                                                 Integer roomId);

  Page<RoomReviewEntity> findByCriteria(Integer ratedEntityId,
                                        Integer authorId,
                                        Integer reviewTargetId,
                                        Integer minRating,
                                        Integer maxRating,
                                        String sortOrder,
                                        String sortBy,
                                        Pageable pageable);
}
