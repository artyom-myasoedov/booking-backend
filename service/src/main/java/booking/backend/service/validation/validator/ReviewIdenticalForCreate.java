package booking.backend.service.validation.validator;

import booking.backend.db.provider.ReviewProvider;
import booking.backend.service.model.ReviewCreateDto;
import booking.backend.service.validation.ReviewIdentical;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReviewIdenticalForCreate implements ConstraintValidator<ReviewIdentical, ReviewCreateDto> {

  private final ReviewProvider provider;

  @Autowired
  public ReviewIdenticalForCreate(ReviewProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(ReviewCreateDto value, ConstraintValidatorContext context) {
    if (value == null ||
      value.getAuthorId() == null ||
      value.getRatedEntityId() == null ||
      value.getReviewTarget() == null) {
      return true;
    }

    return provider.countIdenticalTuplesOfPrimaryKey(
      value.getAuthorId(),
      value.getRatedEntityId(),
      value.getReviewTarget().getId()) == 0;
  }
}
