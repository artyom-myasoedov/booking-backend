package booking.backend.service.validation.validator;

import booking.backend.db.provider.AdminProvider;
import booking.backend.db.provider.UserProvider;
import booking.backend.service.validation.UsernameUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringAdminUsernameUnique implements ConstraintValidator<UsernameUnique, String> {

  private final AdminProvider adminProvider;

  @Autowired

  public StringAdminUsernameUnique(AdminProvider adminProvider) {
    this.adminProvider = adminProvider;
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    return !adminProvider.isUsernameUnique(value);
  }
}
