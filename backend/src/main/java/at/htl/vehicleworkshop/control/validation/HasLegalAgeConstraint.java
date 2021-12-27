package at.htl.vehicleworkshop.control.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HasLegalAgeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HasLegalAgeConstraint  {
    String message() default "Person has to be of legal age!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}