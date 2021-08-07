package booking.backend.service.logic;

import booking.backend.service.model.AdminCreateDto;
import booking.backend.service.model.AdminDto;
import booking.backend.service.model.PageDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {

  AdminDto createAdmin(AdminCreateDto dto);

  AdminDto updateAdmin(AdminCreateDto dto);

  void deleteAdminById(int id);

  PageDto<AdminDto> find(String search, Integer pageSize, Integer pageNumber);

  AdminDto findById(Integer id);

  List<AdminDto> findAll();
}
