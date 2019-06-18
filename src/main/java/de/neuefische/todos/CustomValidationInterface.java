package de.neuefische.todos;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = SwearwordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidationInterface {
    String message() default "Not allowed to use swearwords";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
