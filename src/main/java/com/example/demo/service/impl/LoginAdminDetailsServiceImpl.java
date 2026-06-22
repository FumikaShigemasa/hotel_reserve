package com.example.demo.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.security.LoginAdmin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;

@Service

public class LoginAdminDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRipository;
	private final AdminRepository adminRepository;

	public LoginAdminDetailsServiceImpl(UserRepository userRipository, AdminRepository adminRepository) {
		this.userRipository = userRipository;
		this.adminRepository = adminRepository;
	}

	@Override
	@Qualifier("adminFilterChain")
	public UserDetails loadUserByUsername(String idStr) throws UsernameNotFoundException {

		Integer id = Integer.parseInt(idStr);

		//DBから該当するUserを取得
		Admin admin = adminRepository.findById(id).get();

		if (admin != null) {
			//usernameが正しい時、LoginUserを返す

			System.out.println("あどみん");

			String adminIdStr = String.valueOf(admin.getId());

			return new LoginAdmin(
					adminIdStr,
					admin.getPassword(),
					Collections.emptyList());

		} else {
			throw new UsernameNotFoundException(idStr + " => 指定しているユーザー名は存在しません");
		}

	}

}
