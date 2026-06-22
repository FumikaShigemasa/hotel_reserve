package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.security.LoginUser;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;

@Service

public class LoginUserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRipository;
	private final AdminRepository adminRepository;

	public LoginUserDetailsServiceImpl(UserRepository userRipository, AdminRepository adminRepository) {
		this.userRipository = userRipository;
		this.adminRepository = adminRepository;
	}

	public List<GrantedAuthority> getRoleList(Role role) {

		List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
		roleList.add(new SimpleGrantedAuthority("ROLE_" + role.name()));//hasRoleを使うと強制的にROLE_が付くため合わせる

		return roleList;
	}

	@Override
	@Qualifier("userFilterChain")
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		//DBから該当するUserを取得
		User user = userRipository.findByEmail(email);

		if (user != null) {
			//usernameが正しい時、LoginUserを返す

			//			System.out.println(new BCryptPasswordEncoder().encode(user.getPassword()));

			//権限のリストを取得
			List<GrantedAuthority> roleList = getRoleList(user.getAuthority());

			return new LoginUser(
					user.getEmail(),
					user.getPassword(),
					roleList);

		} else {
			throw new UsernameNotFoundException(email + " => 指定しているユーザー名は存在しません");
		}

	}

}
