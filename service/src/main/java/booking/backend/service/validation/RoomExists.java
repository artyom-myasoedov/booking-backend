package booking.backend.service.validation;

import booking.backend.service.validation.validator.RoleIdenticalForUpdate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RoleIdenticalForUpdate.class)
public @interface RoomExists {

  String message() default "room.does-not-exist";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
