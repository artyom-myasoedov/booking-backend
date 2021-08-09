package booking.backend.service.validation;

import booking.backend.service.validation.validator.AdminUsernameUniqueForUpdate;
import booking.backend.service.validation.validator.StringAdminUsernameUnique;
import booking.backend.service.validation.validator.StringUsernameUnique;
import booking.backend.service.validation.validator.UsernameUniqueForUpdate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
  validatedBy = {
    StringAdminUsernameUnique.class,
    AdminUsernameUniqueForUpdate.class
  })
public @interface AdminUsernameUnique {

  String message() default "username.already-exists";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
