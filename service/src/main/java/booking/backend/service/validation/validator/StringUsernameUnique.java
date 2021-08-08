package booking.backend.service.validation.validator;

import booking.backend.db.provider.UserProvider;
import booking.backend.service.validation.UsernameUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringUsernameUnique implements ConstraintValidator<UsernameUnique, String> {

  private final UserProvider userProvider;

  @Autowired
  public StringUsernameUnique(UserProvider userProvider) {
    this.userProvider = userProvider;
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    return !userProvider.isUsernameUnique(value);
  }
}
