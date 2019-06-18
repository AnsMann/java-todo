package de.neuefische.todos;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SwearwordValidator implements
        ConstraintValidator<CustomValidationInterface, String> {

    @Override
    public void initialize(CustomValidationInterface title) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return !contactField.toLowerCase().contains("fuck");
    }

}