package booking.backend.service.validation.validator;

import booking.backend.db.provider.UserProvider;
import booking.backend.service.model.UserUpdateDto;
import booking.backend.service.validation.RoleIdentical;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleIdenticalForUpdate implements ConstraintValidator<RoleIdentical, UserUpdateDto> {

  private final UserProvider provider;

  @Autowired
  public RoleIdenticalForUpdate(UserProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(UserUpdateDto value, ConstraintValidatorContext context) {
    if (value == null || value.getRole() == null || value.getId() == null) {
      return true;
    }

    return provider.isRoleIdentical(value.getId(), value.getRole());
  }
}
