package booking.backend.db.repository;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<UserEntity, Integer> {

  @Query(
    ""
      + "SELECT u "
      + "FROM users u "
      + "WHERE"
      + "(LOWER(first_name) like CONCAT('%', lower(?1), '%') "
      + "OR LOWER(last_name) like CONCAT('%', lower(?1),'%'))"
      + "AND role_id = 3"
  )
  Page<UserEntity>getVal
    (String search, Pageable pageable);

  boolean existsByUsernameIgnoreCase(String value);

  @Query(
    ""
      + "SELECT COUNT(u) "
      + "FROM users u "
      + "WHERE LOWER(username) = LOWER(?2) "
      + "AND user_id <> ?1"
  )
  Integer countUniqueForUpdate(Integer id, String username);
  @Query(
    "SELECT u FROM users u WHERE role_id = 3"
  )
  Page<UserEntity> findAllAdmins(Pageable page);
}
