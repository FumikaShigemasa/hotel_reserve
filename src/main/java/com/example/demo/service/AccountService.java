package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
