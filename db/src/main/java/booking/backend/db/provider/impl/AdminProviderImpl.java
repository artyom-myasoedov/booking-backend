package booking.backend.db.provider.impl;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.entity.UserEntity;
import booking.backend.db.provider.AdminProvider;
import booking.backend.db.repository.AdminRepository;
import booking.backend.db.repository.UserRepository;
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
  public Page<UserEntity> findByUsername(String search, Pageable pageable) {
    if (search == null) {
      return adminRepository.findAllAdmins(pageable);
    }
    return adminRepository.getVal(search, pageable);
  }

  @Override
  public UserEntity save(UserEntity adminEntity) {
    return adminRepository.save(adminEntity);
  }

  @Override
  public Optional<UserEntity> findById(Integer id) {
    return adminRepository.findById(id);
  }

  @Override
  public Iterable<UserEntity> findAll() {
    return adminRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    adminRepository.deleteById(id);
  }

  @Override
  public boolean isUsernameUnique(String value) {
    return !adminRepository.existsByUsernameIgnoreCase(value);
  }

  @Override
  public boolean isUsernameUnique(Integer id, String username) {
    return adminRepository.countUniqueForUpdate(id, username) == 0;
  }
}
