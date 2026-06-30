package com.example.demo.form.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class EmailDuplicationValidator implements ConstraintValidator<EmailDuplication, String> {

	private final UserRepository userRepository;

	public EmailDuplicationValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private String emailVal;

	@Override
	public void initialize(EmailDuplication annotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null || value.isEmpty()) {
			return true;
		}

		User user = userRepository.findByEmail(value);

		if (user != null) {
			return false;
		} else {
			return true;
		}
	}

}
