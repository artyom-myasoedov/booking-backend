package booking.backend.db.repository;

import booking.backend.db.entity.ReviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDto, Integer>, JpaSpecificationExecutor<ReviewDto> {
  @Query(
    ""
      + "SELECT u "
      + "FROM reviews u "
      + "WHERE description like CONCAT('%', lower(?1), '%') "
  )
  Page<ReviewDto> findReviews(String search, Pageable pageable);

  @Query(
    ""
      + "SELECT COUNT(u) "
      + "FROM reviews u "
      + "WHERE rated_entity_id = ?1 "
      + "AND author_id = ?2 "
      + "AND review_target_id = ?3 "
  )
  Integer checkIdentityForPrimaryKey(Integer ratedEntityId, Integer authorId, Integer reviewTargetId);

  @Query(
    ""
      + "SELECT COUNT(u) "
      + "FROM reviews u "
      + "WHERE review_id <> ?1 "
      + "AND rated_entity_id = ?2 "
      + "AND author_id = ?3 "
      + "AND review_target_id = ?4 "
  )
  Integer checkIdentityForPrimaryKeyAccountingCurrentTuple(Integer id,
                                                           Integer ratedEntityId,
                                                           Integer authorId,
                                                           Integer reviewTargetId);
}
