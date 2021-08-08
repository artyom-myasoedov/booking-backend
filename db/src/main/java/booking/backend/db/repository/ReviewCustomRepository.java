package booking.backend.db.repository;

import booking.backend.db.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewCustomRepository {
  Page<ReviewEntity> findByCriteria(Integer ratedEntityId,
                                    Integer authorId,
                                    Integer reviewTargetId,
                                    Integer minRating,
                                    Integer maxRating,
                                    String sortOrder,
                                    String sortBy,
                                    Pageable pageable);
}
