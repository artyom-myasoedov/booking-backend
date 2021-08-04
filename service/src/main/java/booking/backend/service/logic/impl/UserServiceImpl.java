package booking.backend.service.logic.impl;

import booking.backend.db.provider.UserProvider;
import booking.backend.service.logic.UserService;
import booking.backend.service.mapper.UserMapper;
import booking.backend.service.model.UserDto;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;
  private final UserProvider userProvider;

  public UserServiceImpl(UserMapper userMapper, UserProvider userProvider) {
    this.userMapper = userMapper;
    this.userProvider = userProvider;
  }

  @Override
  public UserDto createUser(UserDto dto) {
    return
            Optional.ofNullable(dto)
                    .map(userMapper::toEntity)
                    .map(userProvider::save)
                    .map(userMapper::fromEntity)
                    .orElseThrow();
  }

  @Override
  public UserDto updateUser(UserDto dto) {
    return createUser(dto);
  }

  @Override
  public void deleteUserById(int id) {
    userProvider.deleteById(id);
  }

  @Override
  public List<UserDto> find(String search, Integer pageSize, Integer pageNumber) {
    return null;
  }

  @Override
  public List<UserDto> findAll() {
    return userMapper.fromEntities(userProvider.findAll());
  }
}
