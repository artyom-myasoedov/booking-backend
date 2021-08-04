package booking.backend.db.provider;

import booking.backend.db.entity.AdminEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AdminProvider {

  Page<AdminEntity> findAdmins(String search, Pageable pageable);

  AdminEntity save(AdminEntity userEntity);

  Optional<AdminEntity> findById(Integer id);

  Iterable<AdminEntity> findAll();

  void deleteById(Integer id);
}
