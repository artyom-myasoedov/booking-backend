package booking.backend.rest.api;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.repository.AdminRepository;
import booking.backend.service.logic.AdminService;
import booking.backend.service.model.AdminCreateDto;
import booking.backend.service.model.AdminDto;
import booking.backend.service.model.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/admin")
public class AdminController {
  private final AdminService adminService;

  @Autowired
  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @GetMapping("/admins")
  PageDto<AdminDto> find(
    @RequestParam(required = false) String search,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {
    return adminService.find(search, pageSize, pageNumber);
  }

  @GetMapping("/{id}")
  AdminDto findById(@PathVariable Integer id){
    return adminService.findById(id);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  AdminDto addAdmin(@RequestBody AdminCreateDto admin){
    return adminService.createAdmin(admin);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  AdminDto updateAdmin(@RequestBody AdminCreateDto admin){
    return adminService.updateAdmin(admin);
  }

  @DeleteMapping("/{id}")
  void deleteById(@PathVariable int id) {
    adminService.deleteAdminById(id);
  }

//  @DeleteMapping("/{id}")
//  void deleteUser(@PathVariable int id, Filter filter) {
//    adminRepository.deleteById(id);
//  }
//
//  static class Filter {
//    private List<String> users;
//    private String search;
//
//  }
}
