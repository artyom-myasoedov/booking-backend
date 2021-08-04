package booking.backend.db.repository;

import booking.backend.db.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {
  @Query(
          ""
                  + "SELECT u "
                  + "FROM users u "
                  + "WHERE LOWER(first_name) like CONCAT('%', lower(?1), '%') "
                  + "OR LOWER(last_name) like CONCAT('%', lower(?1),'%')"
  )
  Page<UserEntity> findUsers(String search, Pageable pageable);

  boolean existsByUsernameIgnoreCase(String value);

  boolean existsByIdIsNotAndUsernameIgnoreCase(int id, String username);
}