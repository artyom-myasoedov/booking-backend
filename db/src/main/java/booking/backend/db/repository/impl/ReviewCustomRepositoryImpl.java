package booking.backend.db.repository.impl;

import booking.backend.db.entity.ReviewEntity;
import booking.backend.db.repository.ReviewCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReviewCustomRepositoryImpl implements ReviewCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Page<ReviewEntity> findByCriteria(Integer ratedEntityId,
                                           Integer authorId,
                                           Integer reviewTargetId,
                                           Integer minRating,
                                           Integer maxRating,
                                           String sortOrder,
                                           String sortBy,
                                           Pageable pageable) {
   List<ReviewEntity> reviews = null;

    return Page.empty();
  }
}
