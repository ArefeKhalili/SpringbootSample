package com.example.Spring_PrintRequest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonnelCodeValidator implements ConstraintValidator<PersonnelCodeValid,String>
{
    @Override
    public void initialize(PersonnelCodeValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String personnelCode, ConstraintValidatorContext constraintValidatorContext) {
        if(personnelCode.length()<5 || personnelCode.length()>15){
            return false;
        }
        return true;
    }
}
