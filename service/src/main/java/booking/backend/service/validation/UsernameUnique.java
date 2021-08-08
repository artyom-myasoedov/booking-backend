package booking.backend.service.validation;

import booking.backend.service.validation.validator.StringUsernameUnique;
import booking.backend.service.validation.validator.UsernameUniqueForUpdate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StringUsernameUnique.class, UsernameUniqueForUpdate.class})
public @interface UsernameUnique {

  String message() default "username.already-exists";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
