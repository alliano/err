package com.web.validators;

import com.web.utils.GetUser;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsPasswordCorrect implements ConstraintValidator<PasswordCorrect,Object> {


	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String lastPassword = GetUser.getMe().get().getPassword();

		return false;
	}

}
