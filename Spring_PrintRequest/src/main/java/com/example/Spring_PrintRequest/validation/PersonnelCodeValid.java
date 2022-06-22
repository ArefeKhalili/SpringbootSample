package com.example.Spring_PrintRequest.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Constraint(validatedBy = PersonnelCodeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public  @interface PersonnelCodeValid {
    String message() default "{personnelCode.isNotValid}";

    Class<?>[] groups() default {};

//    Class<? extends Payload>[] payload() default {};
}
