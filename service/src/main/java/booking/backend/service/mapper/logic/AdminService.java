package booking.backend.service.mapper.logic;

import booking.backend.service.mapper.AdminDto;

import java.util.List;

public interface AdminService {
  AdminDto createAdmin(AdminDto dto);

  AdminDto updateAdmin(AdminDto dto);

  void deleteAdminById(int id);

  List<AdminDto> find(String search, Integer pageSize, Integer pageNumber);
}
