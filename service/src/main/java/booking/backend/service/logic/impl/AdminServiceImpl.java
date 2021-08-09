package booking.backend.service.logic.impl;

import booking.backend.db.provider.AdminProvider;
import booking.backend.service.exceptions.EntityNotFoundException;
import booking.backend.service.logic.AdminService;
import booking.backend.service.mapper.AdminMapper;
import booking.backend.service.model.*;
import booking.backend.service.security.BookingPasswordEncoder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
  private final AdminMapper adminMapper;
  private final AdminProvider adminProvider;
  private final BookingPasswordEncoder passwordEncoder;

  public AdminServiceImpl(AdminMapper adminMapper, AdminProvider adminProvider, BookingPasswordEncoder passwordEncoder) {
    this.adminMapper = adminMapper;
    this.adminProvider = adminProvider;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public AdminDto createAdmin(@Valid AdminCreateDto admin) {
    String encodePassword = passwordEncoder.encode(admin.getPassword());
    admin.setPassword(encodePassword);
    return
            Optional.of(admin)
                    .map(adminMapper::toEntity)
                    .map(adminProvider::save)
                    .map(adminMapper::fromEntity)
                    .orElseThrow();
  }

  @Override
  public AdminDto updateAdmin(@Valid AdminUpdateDto admin) {
    var adminEntity = adminProvider.findById(admin.getId())
      .orElseThrow(() -> new EntityNotFoundException(admin.getId(), "Admin"));

    String encodePassword = passwordEncoder.encode(admin.getPassword());
    admin.setPassword(encodePassword);

    adminMapper.toEntity(admin, adminEntity);

    return adminMapper.fromEntity(adminProvider.save(adminEntity));
  }

  @Override
  public void deleteAdminById(int id) {
    adminProvider.deleteById(id);
  }

  @Override
  public PageDto<AdminDto> find(String search, Integer pageSize, Integer pageNumber) {
    var values = adminProvider
      .findByUsername(
        search,
        Pageable
          .ofSize(pageSize)
          .withPage(pageNumber)
      )
      .map(adminMapper::fromEntity);

    return ImmutablePageDto.<AdminDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public AdminDto findById(Integer id) {
    return adminProvider.findById(id)
      .map(adminMapper::fromEntity)
      .orElse(null);
  }

  @Override
  public List<AdminDto> findAll() {
    return adminMapper.fromEntities(adminProvider.findAll());
  }
}
