package com.becoder.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.becoder.confiq.CustomUserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfiq {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return   new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetails() {
		
		return new CustomUserDetails();
	}
	@Bean
	public DaoAuthenticationProvider dao() {
		DaoAuthenticationProvider d=new DaoAuthenticationProvider();
		d.setUserDetailsService(userDetails());
		d.setPasswordEncoder(passwordEncoder());
		return d;
	}
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().requestMatchers("/index")
		.permitAll().anyRequest().authenticated().and().formLogin();
		return http.build();
	}
}
