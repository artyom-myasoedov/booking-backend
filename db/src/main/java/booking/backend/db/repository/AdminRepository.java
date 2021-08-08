package booking.backend.db.repository;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

  Page<AdminEntity>getAllByUsernameIsContaining(String search, Pageable pageable);

  boolean existsByUsernameIgnoreCase(String value);

  @Query(
    ""
      + "SELECT COUNT(u) "
      + "FROM admins u "
      + "WHERE LOWER(username) = LOWER(?2) "
      + "AND user_id <> ?1"
  )
  Integer countUniqueForUpdate(Integer id, String username);
}
