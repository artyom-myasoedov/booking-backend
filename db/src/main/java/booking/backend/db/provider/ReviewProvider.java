package booking.backend.db.provider;

import booking.backend.db.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewProvider {

  Page<ReviewEntity> findReviews(String search, Pageable pageable);

  ReviewEntity save(ReviewEntity reviewDto);

  Optional<ReviewEntity> findById(Integer id);

  Iterable<ReviewEntity> findAll();

  void deleteById(Integer id);

  Integer countIdenticalTuplesOfPrimaryKey(Integer authorId,
                                           Integer ratedEntityId,
                                           Integer reviewTargetId);

  Integer countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(Integer id,
                                                                 Integer authorId,
                                                                 Integer ratedEntityId,
                                                                 Integer reviewTargetId);

  Page<ReviewEntity> findByCriteria(Integer ratedEntityId,
                                    Integer authorId,
                                    Integer reviewTargetId,
                                    Integer minRating,
                                    Integer maxRating,
                                    String sortOrder,
                                    String sortBy,
                                    Pageable pageable);
}
