package com.example.spring_hibernate_validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Object> {
	private String values;

	@Override
	public void initialize(FlagValidator flagValidator) {
		this.values = flagValidator.values();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		List<String> valueList = Arrays.asList(values.split(","));
		boolean isFlag = false;
		for(String valueItem: valueList){
			if(valueItem.equals(value)){
				isFlag = true;
				break;
			}
		}
		return isFlag;
	}
}
