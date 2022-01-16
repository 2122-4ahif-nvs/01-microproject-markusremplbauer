package at.htl.vehicleworkshop.control.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class HasLegalAgeValidator implements ConstraintValidator<HasLegalAgeConstraint, LocalDate> {

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext constraintValidatorContext) {
        int age = Period.between(dob, LocalDate.now()).getYears();
        return age >= 18;
    }
}
