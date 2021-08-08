package booking.backend.service.logic.impl;

import booking.backend.db.provider.UserProvider;
import booking.backend.service.exceptions.EntityNotFoundException;
import booking.backend.service.logic.UserService;
import booking.backend.service.mapper.UserMapper;
import booking.backend.service.model.*;
import booking.backend.service.security.BookingPasswordEncoder;
import booking.backend.service.security.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class UserServiceImpl implements UserService {
  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
  private final ObjectProvider<Profile> profileProvider;
  private final BookingPasswordEncoder passwordEncoder;
  private final UserMapper userMapper;
  private final UserProvider userProvider;

  @Autowired
  public UserServiceImpl(
    ObjectProvider<Profile> profileProvider,
    BookingPasswordEncoder passwordEncoder,
    UserProvider userProvider,
    UserMapper userMapper
  ) {
    this.profileProvider = profileProvider;
    this.passwordEncoder = passwordEncoder;
    this.userProvider = userProvider;
    this.userMapper = userMapper;
  }

  @Override
  public UserDto createUser(@Valid UserCreateDto userDto) {
    if (profileProvider.getIfAvailable() == null) {
      logger.info("Create new User by anonymous");
    } else {
      logger.info("Create new User by {}", profileProvider.getIfAvailable());
    }

    String encodePassword = passwordEncoder.encode(userDto.getPassword());
    userDto.setPassword(encodePassword);

    return Optional.of(userDto)
      .map(userMapper::toEntity)
      .map(userProvider::save)
      .map(userMapper::fromEntity)
      .orElseThrow();
  }

  @Override
  @Transactional
  public UserDto updateUser(@Valid UserUpdateDto user) {
    var userEntity = userProvider.findById(user.getId())
      .orElseThrow(() -> new EntityNotFoundException(user.getId(), "User"));

    String encodePassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodePassword);

    userMapper.toEntity(user, userEntity);

    return userMapper.fromEntity(userProvider.save(userEntity));
  }

  @Override
  public void deleteUserById(Integer id) {
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
  public UserDto findById(Integer id) {
    return userProvider.findById(id)
      .map(userMapper::fromEntity)
      .orElse(null);
  }
}
