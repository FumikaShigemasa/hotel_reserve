package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.entity.Prefecture;
import com.example.demo.repository.PrefectureRepository;

@Service

public class AccountService {

	private final PrefectureRepository prefectureRepository;

	public AccountService(PrefectureRepository prefectureRepository) {
		this.prefectureRepository = prefectureRepository;
	}

	//=======入力フォームに必要な情報を取得する=======
	//都道府県一覧を取得
	public List<Prefecture> getPrefecture() {
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
			FieldError postCodeError = validPriorityError(postCodeErrorList, "NotBlank", "Size");
			errorMap.put("postCode", postCodeError.getDefaultMessage());
		}

		//電話番号のエラーを優先順位に沿って取得
		List<FieldError> tellErrorList = bindingResult.getFieldErrors("tell");

		if (!tellErrorList.isEmpty()) {
			FieldError tellError = validPriorityError(tellErrorList, "NotBlank", "Size");
			errorMap.put("tell", tellError.getDefaultMessage());
		}

		//パスワードのエラーを優先順位に沿って取得
		List<FieldError> passwordErrorList = bindingResult.getFieldErrors("password");

		if (!passwordErrorList.isEmpty()) {
			FieldError passwordError = validPriorityError(passwordErrorList, "NotBlank", "Size", "Password");
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

}
