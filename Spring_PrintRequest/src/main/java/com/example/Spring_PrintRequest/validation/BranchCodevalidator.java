package com.example.Spring_PrintRequest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BranchCodevalidator implements ConstraintValidator<PersonnelCodeValid,String>{

    @Override
    public void initialize(PersonnelCodeValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String branchCode, ConstraintValidatorContext constraintValidatorContext) {
        if(branchCode.length()<3){
            return false;
        }
        return true;
    }
}
