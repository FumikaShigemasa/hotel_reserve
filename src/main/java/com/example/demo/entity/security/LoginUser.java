package com.example.demo.entity.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {//このUserはSpring SecurityのUserクラス（UserDetailsを実装）

	public LoginUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		//Collection<? extends GrantedAuthority> authorities　権限のリスト
	}

}
