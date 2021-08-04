package booking.backend.db.provider;

import booking.backend.db.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewProvider {

  Page<ReviewEntity> findReviews(String search, Pageable pageable);

  ReviewEntity save(ReviewEntity reviewEntity);

  Optional<ReviewEntity> findById(Integer id);

  Iterable<ReviewEntity> findAll();

  void deleteById(Integer id);
}
