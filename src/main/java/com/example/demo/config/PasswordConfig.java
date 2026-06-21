package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class PasswordConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {//ユーザー認証で自動的にこのメソッドが走る

		return new BCryptPasswordEncoder();//パスワードをハッシュ化する
	}

}
