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

import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
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

	public List<GrantedAuthority> getRoleList(Role role) {

		List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
		roleList.add(new SimpleGrantedAuthority("ROLE_" + role.name()));

		if (role == Role.ADMIN) {
			roleList.add(new SimpleGrantedAuthority("ROLE_" + Role.USER.toString()));
		}

		return roleList;
	}

	@Override
	@Qualifier("adminFilterChain")
	public UserDetails loadUserByUsername(String idStr) throws UsernameNotFoundException {

		Integer id = Integer.parseInt(idStr);

		//DBから該当するUserを取得
		Admin admin = adminRepository.findById(id).get();

		if (admin != null) {
			//usernameが正しい時、LoginUserを返す

			String adminIdStr = String.valueOf(admin.getId());
			List<GrantedAuthority> roleList = getRoleList(admin.getAuthority());

			return new LoginAdmin(
					adminIdStr,
					admin.getPassword(),
					roleList);

		} else {
			throw new UsernameNotFoundException(idStr + " => 指定しているユーザー名は存在しません");
		}

	}

}
