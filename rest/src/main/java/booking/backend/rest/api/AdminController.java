package booking.backend.rest.api;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.repository.AdminRepository;
import booking.backend.service.logic.AdminService;
import booking.backend.service.model.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping
  List<AdminDto> findUsers(){
    return StreamSupport
      .stream(adminService.findAll().spliterator(), false)
      .collect(Collectors.toList());
  }
  @PostMapping
  AdminDto createAdmin(@RequestBody AdminDto admin){
    return adminService.createAdmin(admin);
  }

  @PutMapping("/{id}")
  AdminDto updateAdmin(@RequestBody AdminDto admin, @PathVariable Integer id){
    admin.setId(id);
    return adminService.updateAdmin(admin);
  }

  @DeleteMapping("/{id}")
  void deleteUser(@PathVariable int id) {
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
