package booking.backend.db.provider;

import booking.backend.db.entity.ReviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewProvider {

  Page<ReviewDto> findReviews(String search, Pageable pageable);

  ReviewDto save(ReviewDto reviewDto);

  Optional<ReviewDto> findById(Integer id);

  Iterable<ReviewDto> findAll();

  void deleteById(Integer id);

  Integer countIdenticalTuplesOfPrimaryKey(Integer authorId,
                                           Integer ratedEntityId,
                                           Integer reviewTargetId);

  Integer countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(Integer id,
                                                                 Integer authorId,
                                                                 Integer ratedEntityId,
                                                                 Integer reviewTargetId);

  Page<ReviewDto> findByCriteria(Integer ratedEntityId,
                                 Integer authorId,
                                 Integer reviewTargetId,
                                 Integer minRating,
                                 Integer maxRating,
                                 String sortOrder,
                                 String sortBy,
                                 Pageable pageable);
}
