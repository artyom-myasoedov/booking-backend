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
//  @Query(
//    ""
//      + "SELECT u "
//      + "FROM admins u "
//      + "WHERE LOWER(first_name) like CONCAT('%', lower(?1), '%') "
//      + "OR LOWER(last_name) like CONCAT('%', lower(?1),'%')"
//  )
//  Page<AdminEntity> findAdmins(String search, Pageable pageable);
  Page<AdminEntity>getAllByUsernameIsContaining(String search, Pageable pageable);
}
