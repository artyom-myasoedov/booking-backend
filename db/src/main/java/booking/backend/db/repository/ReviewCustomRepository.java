package booking.backend.db.repository;

import booking.backend.db.entity.RoomReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewCustomRepository {
  Page<RoomReviewEntity> findByCriteria(Integer ratedEntityId,
                                        Integer authorId,
                                        Integer reviewTargetId,
                                        Integer minRating,
                                        Integer maxRating,
                                        String sortOrder,
                                        String sortBy,
                                        Pageable pageable);
}
