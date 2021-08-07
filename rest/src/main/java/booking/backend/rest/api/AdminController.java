package booking.backend.rest.api;

import booking.backend.service.logic.AdminService;
import booking.backend.service.model.AdminDto;
import booking.backend.service.model.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
  private final AdminService adminService;

  @Autowired
  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @GetMapping
  PageDto<AdminDto> findAdmins(
          @RequestParam(required = false) String search,
          @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
          @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {
    return adminService.find(search, pageSize, pageNumber);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  AdminDto addAdmin(@RequestBody AdminDto admin) {
    return adminService.createAdmin(admin);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  AdminDto updateAdmin(@RequestBody AdminDto admin) {
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
