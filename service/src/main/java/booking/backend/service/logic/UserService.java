package booking.backend.service.logic;

import booking.backend.service.model.UserDto;

import java.util.List;

public interface UserService {

  UserDto createUser(UserDto dto);

  UserDto updateUser(UserDto dto);

  void deleteUserById(int id);

  List<UserDto> find(String search, Integer pageSize, Integer pageNumber);

  List<UserDto> findAll();
}
