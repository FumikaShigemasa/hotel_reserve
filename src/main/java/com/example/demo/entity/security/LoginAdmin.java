package com.example.demo.entity.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginAdmin extends User {//このUserはSpring SecurityのUserクラス（UserDetailsを実装）

	public LoginAdmin(String id, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(id, password, authorities);
		//Collection<? extends GrantedAuthority> authorities　権限のリスト
	}

}
