package booking.backend.rest.api;

import booking.backend.service.logic.AdminService;
import booking.backend.service.logic.UserService;
import booking.backend.service.model.AdminCreateDto;
import booking.backend.service.model.AdminDto;
import booking.backend.service.model.AdminUpdateDto;
import booking.backend.service.model.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
  private final AdminService adminService;

  @Autowired
  public AdminController(AdminService userService) {
    this.adminService = userService;
  }

  @GetMapping("/admins")
  @Secured({"ROLE_ADMIN"})
  PageDto<AdminDto> find(
    @RequestParam(required = false) String search,
    @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
    @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {
    return adminService.find(search, pageSize, pageNumber);
  }

  @GetMapping("/{id}")
  @Secured({"ROLE_ADMIN"})
  AdminDto findById(@PathVariable Integer id){
    return adminService.findById(id);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @Secured({"ROLE_ADMIN"})
  AdminDto addAdmin(@RequestBody AdminCreateDto admin){
    return adminService.createAdmin(admin);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @Secured({"ROLE_ADMIN"})
  AdminDto updateAdmin(@RequestBody AdminUpdateDto admin){
    return adminService.updateAdmin(admin);
  }

  @DeleteMapping("/{id}")
  @Secured({"ROLE_ADMIN"})
  void deleteById(@PathVariable int id) {
    adminService.deleteAdminById(id);
  }

}
