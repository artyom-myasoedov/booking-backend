package booking.backend.service.validation.validator;

import booking.backend.db.provider.RoomProvider;
import booking.backend.service.validation.RoomExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomExistsChecker implements ConstraintValidator<RoomExists, Integer> {

  @Autowired
  private RoomProvider provider;

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    return provider.isRoomExists(value);
  }
}
