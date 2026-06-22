package com.example.demo.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.UserLoginForm;

@Controller

public class UserLoginController {

	@GetMapping("/")
	public String top() {
		return "top";
	}

	@GetMapping("/user/login")
	public String login(
			@ModelAttribute UserLoginForm userLoginFrom) {

		return "userLogin";
	}

	@GetMapping("/user")
	public String index() {
		return "userTop";
	}

}
