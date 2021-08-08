package booking.backend.service.validation;

import booking.backend.service.validation.validator.ReviewIdenticalForCreate;
import booking.backend.service.validation.validator.ReviewIdenticalForUpdate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ReviewIdenticalForCreate.class, ReviewIdenticalForUpdate.class})
public @interface ReviewIdentical {
  String message() default "authorId_ratedEntityId_reviewTarget.existing";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
