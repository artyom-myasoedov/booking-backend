package booking.backend.db.provider;

import booking.backend.db.entity.UserReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserReviewProvider {

  Page<UserReviewEntity> findReviews(String search, Pageable pageable);

  UserReviewEntity save(UserReviewEntity reviewDto);

  Optional<UserReviewEntity> findById(Integer id);

  Iterable<UserReviewEntity> findAll();

  void deleteById(Integer id);

  Integer countIdenticalTuplesOfPrimaryKey(Integer authorId, Integer userId);

  Integer countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(Integer id,
                                                                 Integer authorId,
                                                                 Integer userId);
}
