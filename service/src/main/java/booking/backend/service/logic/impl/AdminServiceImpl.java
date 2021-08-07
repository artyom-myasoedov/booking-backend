package booking.backend.service.logic.impl;

import booking.backend.db.provider.AdminProvider;
import booking.backend.service.logic.AdminService;
import booking.backend.service.mapper.AdminMapper;
import booking.backend.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
  private final AdminMapper adminMapper;
  private final AdminProvider adminProvider;

  public AdminServiceImpl(AdminMapper adminMapper, AdminProvider adminProvider) {
    this.adminMapper = adminMapper;
    this.adminProvider = adminProvider;
  }

  @Override
  public AdminDto createAdmin(AdminCreateDto dto) {
    return
            Optional.ofNullable(dto)
                    .map(adminMapper::toEntity)
                    .map(adminProvider::save)
                    .map(adminMapper::fromEntity)
                    .orElseThrow();
  }

  @Override
  public AdminDto updateAdmin(AdminCreateDto dto) {
    return createAdmin(dto);
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
