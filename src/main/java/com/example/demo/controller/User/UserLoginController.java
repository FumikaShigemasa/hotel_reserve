package com.example.demo.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.account.UserAddForm;
import com.example.demo.form.account.UserLoginForm;
import com.example.demo.form.hotel.HotelSearchForm;
import com.example.demo.service.AccountService;

@Controller

public class UserLoginController {

	private final AccountService accountService;

	public UserLoginController(
			AccountService accountService) {
		this.accountService = accountService;
	}

	//======TOP======
	@GetMapping("/")
	public String top(
			HotelSearchForm hotelSearch,
			Model model) {

		model.addAttribute("prefectureList", accountService.getAllPrefecture());
		return "user/top";
	}
	//----------------

	//======ログイン======
	@GetMapping("/user/login")
	public String login(
			@ModelAttribute UserLoginForm userLoginFrom) {

		return "user/userLogin";
	}

	@GetMapping("/user")
	public String index() {
		return "user/userTop";
	}
	//----------------------

	//======会員新規登録======
	@GetMapping("/add/account")
	public String addAccount(
			UserAddForm userAddForm,
			Model model) {

		model.addAttribute("prefectureList", accountService.getAllPrefecture());

		return "user/userAdd";
	}

	@PostMapping("/add/account/confirm")
	public String addConfirm(
			@ModelAttribute @Validated UserAddForm userAddForm,
			BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("errorMap", accountService.validUserAdd(bindingResult));
			model.addAttribute("prefectureList", accountService.getAllPrefecture());

			return "user/userAdd";
		} else {

			model.addAttribute("userAddForm", userAddForm);
			System.out.println(userAddForm.getGender());

			return "user/userAddConfirm";
		}
	}

	@PostMapping("/add/account")
	public String create(
			@ModelAttribute UserAddForm userAddForm) {

		System.out.println(userAddForm.getGender());
		System.out.println(userAddForm.getName());

		accountService.createUser(userAddForm);
		return "redirect:/user/login";
	}
	//-----------------------

}
