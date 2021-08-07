package booking.backend.service.logic;

import booking.backend.service.model.AdminDto;
import booking.backend.service.model.PageDto;

import java.util.List;

public interface AdminService {

  AdminDto createAdmin(AdminDto dto);

  AdminDto updateAdmin(AdminDto dto);

  void deleteAdminById(int id);

  PageDto<AdminDto> find(String search, Integer pageSize, Integer pageNumber);

  List<AdminDto> findAll();
}
