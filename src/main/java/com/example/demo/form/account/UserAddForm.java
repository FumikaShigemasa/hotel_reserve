package com.example.demo.form.account;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data

public class UserAddForm {

	@NotNull(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスの形式で入力してください")
	private String email;

	@NotNull(message = "名前を入力してください")
	private String name;

	private Integer gender;
	private Integer prefectureId;

	@NotNull(message = "住所を入力してください")
	private String location;

	@NotNull(message = "郵便番号を入力してください")
	@Size(min = 7, max = 7, message = "有効な郵便番号を入力してください")
	private String postCode;

	@NotNull(message = "電話番号を入力してください")
	@Size(min = 11, max = 15, message = "電話番号は7桁で入力してください")
	private String tell;

	@NotNull(message = "パスワードを入力してください")
	@Size(min = 8, message = "パスワードは8桁以上で設定してください")
	private String password;

	private String passwordConfirm;

	@AssertTrue(message = "パスワードが一致していません")
	public boolean isPasswordCheck() {
		if (password != null && passwordConfirm != null) {
			if (!password.equals(passwordConfirm)) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

}