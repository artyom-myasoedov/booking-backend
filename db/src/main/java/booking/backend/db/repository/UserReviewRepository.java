package booking.backend.db.repository;

import booking.backend.db.entity.UserReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewRepository extends
  JpaRepository<UserReviewEntity, Integer>,
  JpaSpecificationExecutor<UserReviewEntity>,
  ReviewCustomRepository
{
  @Query(
    ""
      + "SELECT u "
      + "FROM user_reviews u "
      + "WHERE description like CONCAT('%', lower(?1), '%') "
  )
  Page<UserReviewEntity> findReviews(String search, Pageable pageable);

  @Query(
    ""
      + "SELECT COUNT(u) "
      + "FROM user_reviews u "
      + "WHERE author_id = ?1 "
      + "AND user_id = ?2 ")
  Integer checkIdentityForPrimaryKey(Integer authorId, Integer userId);

  @Query(
    ""
      + "SELECT COUNT(u) "
      + "FROM user_reviews u "
      + "WHERE review_id <> ?1 "
      + "AND author_id = ?2 "
      + "AND user_id = ?3 "
  )
  Integer checkIdentityForPrimaryKeyAccountingCurrentTuple(Integer id,
                                                           Integer authorId,
                                                           Integer userId);

}
