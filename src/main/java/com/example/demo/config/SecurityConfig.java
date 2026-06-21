package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.repository.UserRepository;

@Configuration //設定クラスのアノテーション
@EnableWebSecurity //Spring Securityを有効化

public class SecurityConfig {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	private final UserRepository userRepository;

	@Autowired
	public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder,
			UserRepository userRepository) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}

	@Bean //SecurityFilterChainオブジェクト（Spring Securityにある）をSpringに登録
	@Order(1) //処理の優先順位を設定
	public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {

		http
				.securityMatcher("/admin/**")
				.authorizeHttpRequests(authz -> authz//アクセスのルールを定義
						.requestMatchers("/admin/login").permitAll()//　/loginには誰でもアクセス可能
						.anyRequest().authenticated()//他のページはログインが必須
				)
				.formLogin(form -> form//フォームパッケージのログイン設定
						.loginPage("/admin/login")//カスタムのログインページを設定(ログインしていない場合はすべてこのURLへ)
						.loginProcessingUrl("/admin/authentication")//ログイン用のURL
						.usernameParameter("id")//HTMLのname属性をusernameとして指定
						.passwordParameter("password")//HTMLのname属性をpasswordとして指定
						.defaultSuccessUrl("/admin")//ログイン成功時のリダイレクト先
						.failureUrl("/admin/login?error")//ログイン失敗時のリダイレクト先
				)
				.logout(logout -> logout//ログアウト設定
						.logoutUrl("/admin/logout")//ログアウト処理をするURL
						.logoutSuccessUrl("/admin/logout?logout")//ログアウト成功時のリダイレクト先
						.invalidateHttpSession(true)//ログアウト時にセッションを切る
						.deleteCookies("JSESSIONID"));//ログアウト時にcookieを削除する

		return http.build();//httpの設定を反映させたSecurityFilterChainオブジェクトとして生成
		//このとき、UserDetailsServiceとPasswordEncoderが動いている。
	}

	@Bean //SecurityFilterChainオブジェクト（Spring Securityにある）をSpringに登録
	@Order(2) //処理の優先順位を設定
	public SecurityFilterChain userfilterChain(HttpSecurity http) throws Exception {

		http
				.securityMatcher("/user/**")
				.authorizeHttpRequests(authz -> authz//アクセスのルールを定義
						.requestMatchers("/user/login/**").permitAll()//　/loginには誰でもアクセス可能
						.anyRequest().authenticated()//他のページはログインが必須
				)
				.formLogin(form -> form//フォームパッケージのログイン設定
						.loginPage("/user/login")//カスタムのログインページを設定(ログインしていない場合はすべてこのURLへ)
						.loginProcessingUrl("/user/authentication")//ログイン用のURL
						.usernameParameter("email")//HTMLのname属性をusernameとして指定
						.passwordParameter("password")//HTMLのname属性をpasswordとして指定
						.defaultSuccessUrl("/")//ログイン成功時のリダイレクト先
						.failureUrl("/login?error")//ログイン失敗時のリダイレクト先
				)
				.logout(logout -> logout//ログアウト設定
						.logoutUrl("/user/logout")//ログアウト処理をするURL
						.logoutSuccessUrl("/user/login?logout")//ログアウト成功時のリダイレクト先
						.invalidateHttpSession(true)//ログアウト時にセッションを切る
						.deleteCookies("JSESSIONID"));//ログアウト時にcookieを削除する

		return http.build();//httpの設定を反映させたSecurityFilterChainオブジェクトとして生成
		//このとき、UserDetailsServiceとPasswordEncoderが動いている。
	}

}
