package booking.backend.service.logic;

import booking.backend.service.model.PageDto;
import booking.backend.service.model.UserCreateDto;
import booking.backend.service.model.UserDto;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

  UserDto createUser(@Valid UserCreateDto userDto);

  UserDto updateUser(UserDto dto);

  void deleteUserById(int id);

  PageDto<UserDto> find(String search, Integer pageSize, Integer pageNumber);

  List<UserDto> findAll();
}
