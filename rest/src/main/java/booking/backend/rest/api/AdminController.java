package booking.backend.rest.api;

import booking.backend.db.entity.AdminEntity;
import booking.backend.db.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/admin")
public class AdminController {
  private final AdminRepository adminRepository;
  @Autowired
  public AdminController(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @GetMapping
  List<AdminEntity> findUsers(){
    return StreamSupport
      .stream(adminRepository.findAll().spliterator(), false)
      .collect(Collectors.toList());
  }
  @PostMapping
  AdminEntity createAdmin(@RequestBody AdminEntity admin){
    return adminRepository.save(admin);
  }

  @DeleteMapping("/{id}")
  void deleteUser(@PathVariable int id) {
    adminRepository.deleteById(id);
  }
}
