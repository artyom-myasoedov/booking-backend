package booking.backend.service.validation;

import booking.backend.service.validation.validator.RoomReviewIdenticalForCreate;
import booking.backend.service.validation.validator.RoomReviewIdenticalForUpdate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RoomReviewIdenticalForCreate.class, RoomReviewIdenticalForUpdate.class})
public @interface ReviewIdentical {
  String message() default "authorId_ratedEntityId_reviewTarget.existing";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
