package booking.backend.service.validation;

import booking.backend.service.validation.validator.UserReviewIdenticalForCreate;
import booking.backend.service.validation.validator.UserReviewIdenticalForUpdate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UserReviewIdenticalForCreate.class, UserReviewIdenticalForUpdate.class})
public @interface UserReviewIdentical {
  String message() default "authorId_ratedEntityId_reviewTarget.existing";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
