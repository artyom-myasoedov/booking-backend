package booking.backend.service.validation;

import booking.backend.db.provider.UserProvider;
import booking.backend.service.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqueForUpdate implements ConstraintValidator<UsernameUnique, UserDto> {

  private final UserProvider provider;

  @Autowired
  public UsernameUniqueForUpdate(UserProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(UserDto value, ConstraintValidatorContext context) {
    if (value == null || value.getId() == null || value.getUsername() == null) {
      return true;
    }

    return !provider.isUsernameExists(value.getId(), value.getUsername());
  }
}
