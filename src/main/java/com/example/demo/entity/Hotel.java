package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")

public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//宿ID

	private String name;//宿名
	private String exolanation;//宿説明
	private String prefecture;//都道府県
	private String location;//住所

	@Column(name = "post_code")
	private String postCode;//郵便番号

	private String tell;//電話番号

	//コンストラクタ
	public Hotel() {
		super();
	}

	public Hotel(String name, String exolanation, String prefecture, String location, String postCode, String tell) {
		super();
		this.name = name;
		this.exolanation = exolanation;
		this.prefecture = prefecture;
		this.location = location;
		this.postCode = postCode;
		this.tell = tell;
	}

	//ゲッターとセッター
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExolanation() {
		return exolanation;
	}

	public void setExolanation(String exolanation) {
		this.exolanation = exolanation;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public Integer getId() {
		return id;
	}

}
