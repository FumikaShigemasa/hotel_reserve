package com.example.demo.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.account.AdminLoginForm;

@Controller

public class AdminLoginController {

	@GetMapping("/admin/login")
	public String login(
			@ModelAttribute AdminLoginForm adminLoginFrom) {

		return "admin/adminLogin";
	}

	@GetMapping("/admin")
	public String index() {
		return "admin/adminTop";
	}

}
