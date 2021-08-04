package booking.backend.db.provider.impl;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.provider.AdminProvider;
import booking.backend.db.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminProviderImpl implements AdminProvider {

  private final AdminRepository adminRepository;

  @Autowired
  public AdminProviderImpl(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @Override
  public Page<AdminEntity> findUsers(String search, Pageable pageable) {
//    if (search == null) {
//      return adminRepository.findAll(pageable);
//    }
//    return adminRepository.findUsers(search, pageable);
    return null;
  }

  @Override
  public AdminEntity save(AdminEntity adminEntity) {
    return adminRepository.save(adminEntity);
  }

  @Override
  public Optional<AdminEntity> findById(Integer id) {
    return adminRepository.findById(id);
  }

  @Override
  public Iterable<AdminEntity> findAll() {
    return adminRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    adminRepository.deleteById(id);
  }
}
