package booking.backend.service.logic.impl;

import booking.backend.db.provider.UserProvider;
import booking.backend.service.exceptions.EntityNotFoundException;
import booking.backend.service.logic.UserService;
import booking.backend.service.mapper.UserMapper;
import booking.backend.service.model.ImmutablePageDto;
import booking.backend.service.model.PageDto;
import booking.backend.service.model.UserCreateDto;
import booking.backend.service.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;
  private final UserProvider userProvider;

  @Autowired
  public UserServiceImpl(
          UserProvider userProvider,
          UserMapper userMapper
  ) {
    this.userProvider = userProvider;
    this.userMapper = userMapper;
  }

  @Override
  public UserDto createUser(@Valid UserCreateDto userDto) {
    return Optional.ofNullable(userDto)
            .map(userMapper::toEntity)
            .map(userProvider::save)
            .map(userMapper::fromEntity)
            .orElseThrow();
  }

  @Override
  @Transactional
  public UserDto updateUser(UserDto user) {
    var userEntity = userProvider.findById(user.getId())
            .orElseThrow(() -> new EntityNotFoundException(user.getId(), "User"));

    userMapper.toEntity(user, userEntity);

    return userMapper.fromEntity(userProvider.save(userEntity));

  }

  @Override
  public void deleteUserById(int id) {
    userProvider.deleteById(id);
  }

  @Override
  public PageDto<UserDto> find(String search, Integer pageSize, Integer pageNumber) {
    var values = userProvider.findUsers(
            search,
            Pageable
                    .ofSize(pageSize)
                    .withPage(pageNumber)
    )
            .map(userMapper::fromEntity);

    return ImmutablePageDto.<UserDto>builder()
            .pageNumber(pageNumber)
            .totalPages(values.getTotalPages())
            .items(values.getContent())
            .build();
  }

  @Override
  public List<UserDto> findAll() {
    return userMapper.fromEntities(userProvider.findAll());
  }
}
