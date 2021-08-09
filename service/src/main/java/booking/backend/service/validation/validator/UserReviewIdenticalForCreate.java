package booking.backend.service.validation.validator;

import booking.backend.db.provider.UserReviewProvider;
import booking.backend.service.model.UserReviewCreateDto;
import booking.backend.service.validation.UserReviewIdentical;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserReviewIdenticalForCreate implements ConstraintValidator<UserReviewIdentical, UserReviewCreateDto> {

  private final UserReviewProvider provider;

  @Autowired
  public UserReviewIdenticalForCreate(UserReviewProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(UserReviewCreateDto value, ConstraintValidatorContext context) {
    if (value == null ||
      value.getAuthorId() == null ||
      value.getUserId() == null) {
      return true;
    }

    return provider.countIdenticalTuplesOfPrimaryKey(
      value.getAuthorId(),
      value.getUserId()) == 0;
  }
}
