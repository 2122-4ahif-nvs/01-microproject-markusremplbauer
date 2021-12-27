package at.htl.vehicleworkshop.control.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class HasLegalAgeValidator implements ConstraintValidator<HasLegalAgeConstraint, LocalDate> {

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext constraintValidatorContext) {
        return dob.isBefore(LocalDate.now().minusYears(18));
    }
}
