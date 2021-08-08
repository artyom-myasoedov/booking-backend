package booking.backend.rest.api;

import booking.backend.service.logic.UserService;
import booking.backend.service.model.PageDto;
import booking.backend.service.model.UserCreateDto;
import booking.backend.service.model.UserDto;
import booking.backend.service.model.UserUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping("/{id}")
  UserDto getUser(@PathVariable int id) {
    return userService.findById(id);
  }

  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  @GetMapping
  PageDto<UserDto> findUsers(
          @RequestParam(required = false) String search,
          @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
          @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber
  ) {

    return userService.find(search, pageSize, pageNumber);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  UserDto createUser(@RequestBody UserCreateDto user) {
    return userService.createUser(user);
  }

  @Secured("ROLE_ADMIN")
  @PutMapping
  UserDto updateUser(@RequestBody UserUpdateDto user) {
    return userService.updateUser(user);
  }

  @Secured("ROLE_ADMIN")
  @DeleteMapping("/{id}")
  void deleteUser(@PathVariable int id) {
    userService.deleteUserById(id);
  }
}
