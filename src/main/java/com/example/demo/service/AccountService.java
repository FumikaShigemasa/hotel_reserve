package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.entity.Prefecture;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.form.account.UserAddForm;
import com.example.demo.repository.PrefectureRepository;
import com.example.demo.repository.UserRepository;

@Service

public class AccountService {

	private final PrefectureRepository prefectureRepository;
	private final UserRepository userRepository;

	public AccountService(PrefectureRepository prefectureRepository, UserRepository userRepository) {
		this.prefectureRepository = prefectureRepository;
		this.userRepository = userRepository;
	}

	//=======入力フォームに必要な情報を取得する=======
	//都道府県一覧を取得
	public List<Prefecture> getAllPrefecture() {
		return prefectureRepository.findAll();
	}
	//------------------------------------------

	//======バリデーションの優先順位処理======

	public Map<String, String> validUserAdd(BindingResult bindingResult) {

		//空のMapを生成
		Map<String, String> errorMap = new HashMap<String, String>();

		//メールアドレスのエラーを優先順位に沿って取得しMapに追加
		List<FieldError> emailErrorList = bindingResult.getFieldErrors("email");

		if (!emailErrorList.isEmpty()) {
			FieldError emailError = validPriorityError(emailErrorList, "NotBlank", "Email", "EmailDuplication");
			errorMap.put("email", emailError.getDefaultMessage());
		}

		//郵便番号のエラーを優先順位に沿って取得
		List<FieldError> postCodeErrorList = bindingResult.getFieldErrors("postCode");

		if (!postCodeErrorList.isEmpty()) {
			FieldError postCodeError = validPriorityError(postCodeErrorList, "NotBlank", "Pattern");
			errorMap.put("postCode", postCodeError.getDefaultMessage());
		}

		//電話番号のエラーを優先順位に沿って取得
		List<FieldError> tellErrorList = bindingResult.getFieldErrors("tell");

		if (!tellErrorList.isEmpty()) {
			FieldError tellError = validPriorityError(tellErrorList, "NotBlank", "Pattern");
			errorMap.put("tell", tellError.getDefaultMessage());
		}

		//パスワードのエラーを優先順位に沿って取得
		List<FieldError> passwordErrorList = bindingResult.getFieldErrors("password");

		if (!passwordErrorList.isEmpty()) {
			FieldError passwordError = validPriorityError(passwordErrorList, "NotBlank", "Pattern", "Password");
			errorMap.put("password", passwordError.getDefaultMessage());
		}

		return errorMap;
	}

	public FieldError validPriorityError(
			List<FieldError> errorList,
			String... priority) {

		for (String code : priority) {
			for (FieldError error : errorList) {
				if (code.equals(error.getCode())) {
					return error;
				}
			}
		}

		return errorList.get(0);
	}
	//----------------------------------

	//======データベース登録処理======
	//都道府県を変換
	public Prefecture setPrefecture(String name) {

		return prefectureRepository.findByName(name);
	}

	//性別を変換
	public Integer setGender(String gender) {
		if (gender.equals("男性")) {
			return 0;
		} else if (gender.equals("女性")) {
			return 1;
		} else {
			return 2;
		}
	}

	@Transactional
	public void createUser(UserAddForm userAddForm) {

		Prefecture prefecture = setPrefecture(userAddForm.getPrefecture());
		Integer gender = setGender(userAddForm.getGender());
		String password = new BCryptPasswordEncoder().encode(userAddForm.getPassword());

		User user = new User(
				userAddForm.getEmail(),
				password,
				userAddForm.getName(),
				gender,
				prefecture,
				userAddForm.getLocation(),
				userAddForm.getPostCode(),
				userAddForm.getTell(),
				false,
				Role.USER);

		userRepository.save(user);

	}
	//----------------------------
}
