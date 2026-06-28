package com.example.demo.form.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<Password, Object> {

	private String passwordVal;
	private String passwordConfirmVal;

	@Override
	public void initialize(Password annotation) {
		this.passwordVal = annotation.password();
		this.passwordConfirmVal = annotation.passwordConfirm();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(value);
		String password = (String) beanWrapper.getPropertyValue(passwordVal);
		String passwordConfirm = (String) beanWrapper.getPropertyValue(passwordConfirmVal);

		if (password == null || passwordConfirm == null) {
			return false;
		}

		if (password.equals(passwordConfirm)) {
			return true;
		}

		context.disableDefaultConstraintViolation();

		context.buildConstraintViolationWithTemplate(
				context.getDefaultConstraintMessageTemplate())
				.addPropertyNode(passwordVal)
				.addConstraintViolation();

		return false;

	}

}
