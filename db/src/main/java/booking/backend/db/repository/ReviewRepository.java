package booking.backend.db.repository;

import booking.backend.db.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>, JpaSpecificationExecutor<ReviewEntity> {
  @Query(
          ""
                  + "SELECT u "
                  + "FROM reviews u "
                  + "WHERE description like CONCAT('%', lower(?1), '%') "
  )
  Page<ReviewEntity> findReviews(String search, Pageable pageable);
}
