package booking.backend.service.validation.validator;

import booking.backend.db.provider.RoomReviewProvider;
import booking.backend.service.model.RoomReviewCreateDto;
import booking.backend.service.validation.RoomReviewIdentical;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomReviewIdenticalForCreate implements ConstraintValidator<RoomReviewIdentical, RoomReviewCreateDto> {

  private final RoomReviewProvider provider;

  @Autowired
  public RoomReviewIdenticalForCreate(RoomReviewProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(RoomReviewCreateDto value, ConstraintValidatorContext context) {
    if (value == null ||
      value.getAuthorId() == null ||
      value.getRoomId() == null) {
      return true;
    }

    return provider.countIdenticalTuplesOfPrimaryKey(
      value.getAuthorId(),
      value.getRoomId()) == 0;
  }
}
