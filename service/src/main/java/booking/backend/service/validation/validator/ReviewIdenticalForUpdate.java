package booking.backend.service.validation.validator;

import booking.backend.db.provider.ReviewProvider;
import booking.backend.service.model.ReviewUpdateDto;
import booking.backend.service.validation.ReviewIdentical;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReviewIdenticalForUpdate implements ConstraintValidator<ReviewIdentical, ReviewUpdateDto> {

  private final ReviewProvider provider;

  @Autowired
  public ReviewIdenticalForUpdate(ReviewProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(ReviewUpdateDto value, ConstraintValidatorContext context) {
    if (value == null ||
      value.getId() == null ||
      value.getAuthorId() == null ||
      value.getRatedEntityId() == null ||
      value.getReviewTarget() == null) {
      return true;
    }

    return provider.countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(
      value.getId(),
      value.getAuthorId(),
      value.getRatedEntityId(),
      value.getReviewTarget().getId()) == 0;
  }
}
