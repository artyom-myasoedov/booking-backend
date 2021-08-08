package booking.backend.service.logic;

import booking.backend.service.model.PageDto;
import booking.backend.service.model.UserCreateDto;
import booking.backend.service.model.UserDto;
import booking.backend.service.model.UserUpdateDto;

import javax.validation.Valid;

public interface UserService {

  UserDto createUser(@Valid UserCreateDto userDto);

  UserDto updateUser(@Valid UserUpdateDto dto);

  void deleteUserById(Integer id);

  UserDto findById(Integer id);

  PageDto<UserDto> find(String search, Integer pageSize, Integer pageNumber);
}
