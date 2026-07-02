package com.example.demo.form.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import com.example.demo.form.validation.EmailDuplication;
import com.example.demo.form.validation.Password;

import lombok.Data;

@Data
@Password(password = "password", passwordConfirm = "passwordConfirm")

public class UserAddForm {

	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスの形式で入力してください")
	@EmailDuplication(email = "email")
	private String email;

	@NotBlank(message = "名前を入力してください")
	private String name;

	private Integer gender;
	private Integer prefectureId;

	@NotBlank(message = "住所を入力してください")
	private String location;

	@NotBlank(message = "郵便番号を入力してください")
	@Pattern(regexp = "^[0-9]{7}$", message = "有効な郵便番号を入力してください")
	private String postCode;

	@NotBlank(message = "電話番号を入力してください")
	@Pattern(regexp = "^[0-9]{11,15}$", message = "有効な電話番号を入力してください")
	private String tell;

	@NotBlank(message = "パスワードを入力してください")
	@Pattern(regexp = "^[A-Z]+[0-9a-zA-Z]{7,}$", message = "大文字を含む英数字8桁以上で設定してください")
	private String password;

	private String passwordConfirm;

}