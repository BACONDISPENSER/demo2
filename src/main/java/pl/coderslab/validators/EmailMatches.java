package pl.coderslab.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailMatchesValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailMatches {

    String message() default "{emailMatches.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}



