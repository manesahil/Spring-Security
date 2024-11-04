package com.ty.SpringSecurityTrial.SecurityConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ty.SpringSecurityTrial.Service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	MyUserDetailsService detailsService;
	
	@Autowired
	 DataSource dataSource;
	
	@Bean
	public SecurityFilterChain defaultsecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(request) -> request.requestMatchers("h1/hello").permitAll().anyRequest().authenticated());
		http.httpBasic();
		http.formLogin();
		http.csrf(csrf -> csrf.disable());
		return http.build();

	}

//	@Bean
//	public UserDetailsService UserDetailsService() {
//		PasswordEncoder PasswordEncoder = new BCryptPasswordEncoder();
////		UserDetails user1 = User.withUsername("user").password("{noop}user@123").roles("USER").build();
////		UserDetails admin1 = User.withUsername("admin").password("{noop}admin@123").roles("ADMIN").build();
//
//		UserDetails user1 = User.withUsername("user").password(PasswordEncoder.encode("user@123")).roles("USER")
//				.build();
//		UserDetails admin1 = User.withUsername("admin").password(PasswordEncoder.encode("admin@123")).roles("ADMIN")
//			.build();
//		
//		//JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
//		
//		return new InMemoryUserDetailsManager(user1, admin1);
//	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
	DaoAuthenticationProvider provide = new DaoAuthenticationProvider();
	provide.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	provide.setUserDetailsService(detailsService);
	return provide;
	}
	
	 

//	@Bean
//	public PasswordEncoder Passwordencoder() {
//		return new BCryptPasswordEncoder();
//	}
}
