package com.example.Spring_PrintRequest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IpAddressValidator implements ConstraintValidator<IpAddressValid,String> {
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    @Override
    public void initialize(IpAddressValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String ipAddress, ConstraintValidatorContext constraintValidatorContext) {
        return PATTERN.matcher(ipAddress).matches();
    }

}
