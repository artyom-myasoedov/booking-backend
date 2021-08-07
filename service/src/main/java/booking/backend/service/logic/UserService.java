package booking.backend.service.logic;

import booking.backend.service.model.PageDto;
import booking.backend.service.model.UserCreateDto;
import booking.backend.service.model.UserDto;
import booking.backend.service.model.UserUpdateDto;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

  UserDto createUser(@Valid UserCreateDto userDto);

  UserDto updateUser(@Valid UserUpdateDto dto);

  void deleteUserById(int id);

  PageDto<UserDto> find(String search, Integer pageSize, Integer pageNumber);

  List<UserDto> findAll();
}
