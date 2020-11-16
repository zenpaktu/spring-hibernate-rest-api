package com.springboot.upworkproject.virusrestapi.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValidYearConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidYearConstraint {
	
	String message() default "Invalid input Year";
	
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
