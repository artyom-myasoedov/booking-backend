package booking.backend.service.validation;

import booking.backend.service.validation.validator.RoleIdenticalForUpdate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RoleIdenticalForUpdate.class)
public @interface RoleIdentical {

  String message() default "username.role-differs-from-existing";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
