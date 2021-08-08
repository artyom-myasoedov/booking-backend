package booking.backend.service.validation.validator;

import booking.backend.db.provider.RoomReviewProvider;
import booking.backend.service.model.RoomReviewUpdateDto;
import booking.backend.service.validation.ReviewIdentical;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomReviewIdenticalForUpdate implements ConstraintValidator<ReviewIdentical, RoomReviewUpdateDto> {

  private final RoomReviewProvider provider;

  @Autowired
  public RoomReviewIdenticalForUpdate(RoomReviewProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(RoomReviewUpdateDto value, ConstraintValidatorContext context) {
    if (value == null ||
      value.getId() == null ||
      value.getAuthorId() == null ||
      value.getRoomId() == null) {
      return true;
    }

    return provider.countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(
      value.getId(),
      value.getAuthorId(),
      value.getRoomId()) == 0;
  }
}
