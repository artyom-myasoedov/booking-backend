package booking.backend.service.logic;

import booking.backend.service.model.AdminDto;

import java.util.List;

public interface AdminService {
  AdminDto createAdmin(AdminDto dto);

  AdminDto updateAdmin(AdminDto dto);

  void deleteAdminById(int id);

  List<AdminDto> find(String search, Integer pageSize, Integer pageNumber);
}
