package booking.backend.service.mapper.logic.impl;

import booking.backend.service.mapper.AdminDto;
import booking.backend.service.mapper.logic.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
  @Override
  public AdminDto createAdmin(AdminDto dto) {
    return null;
  }

  @Override
  public AdminDto updateAdmin(AdminDto dto) {
    return null;
  }

  @Override
  public void deleteAdminById(int id) {

  }

  @Override
  public List<AdminDto> find(String search, Integer pageSize, Integer pageNumber) {
    return null;
  }
}
