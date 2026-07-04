package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//顧客ID

	private String email;//メールアドレス
	private String password;//パスワード
	private Integer gender;//性別（0：男 1:女 2:その他）

	@ManyToOne
	@JoinColumn(name = "prefecture")
	private Prefecture prefecture;//都道府県

	private String location;//住所

	@Column(name = "post_code")
	private String postCode;//郵便番号

	private String tell;//電話番号

	@Column(name = "is_deleted")
	private boolean isDelete;//退会判定

	@Enumerated(EnumType.STRING)
	private Role authority;

	//コンストラクタ
	public User() {
	}

	public User(String email, String password, Integer gender, Prefecture prefecture, String location, String postCode,
			String tell, boolean isDelete, Role authority) {
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.prefecture = prefecture;
		this.location = location;
		this.postCode = postCode;
		this.tell = tell;
		this.isDelete = isDelete;
		this.authority = authority;
	}

	//ゲッターとセッター
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Prefecture getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(Prefecture prefecture) {
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

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public Role getAuthority() {
		return authority;
	}

	public void setAuthority(Role authority) {
		this.authority = authority;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}
