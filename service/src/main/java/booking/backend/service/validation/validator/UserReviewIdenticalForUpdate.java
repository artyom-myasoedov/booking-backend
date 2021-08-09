package booking.backend.service.validation.validator;

import booking.backend.db.provider.UserReviewProvider;
import booking.backend.service.model.UserReviewUpdateDto;
import booking.backend.service.validation.UserReviewIdentical;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserReviewIdenticalForUpdate implements ConstraintValidator<UserReviewIdentical, UserReviewUpdateDto> {

  private final UserReviewProvider provider;

  @Autowired
  public UserReviewIdenticalForUpdate(UserReviewProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(UserReviewUpdateDto value, ConstraintValidatorContext context) {
    if (value == null ||
      value.getId() == null ||
      value.getAuthorId() == null ||
      value.getUserId() == null) {
      return true;
    }

    return provider.countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(
      value.getId(),
      value.getAuthorId(),
      value.getUserId()) == 0;
  }
}
