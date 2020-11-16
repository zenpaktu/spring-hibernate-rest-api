package com.springboot.upworkproject.virusrestapi.customvalidator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidYearConstraintValidator 
	implements ConstraintValidator<ValidYearConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
        }
		
		if (!(LocalDate.now().getYear() >= Integer.parseInt(value) && Integer.parseInt(value) >= 0)) {
			throw new IllegalArgumentException(
		              "Year Discovered is an invalid Year value");
		}
		
		return true; 
			
	}

}
