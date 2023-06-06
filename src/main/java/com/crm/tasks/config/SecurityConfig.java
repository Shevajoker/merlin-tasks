package com.crm.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig{


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.anyRequest()
		.authenticated();
		
		http.oauth2ResourceServer()
		.jwt();
		
		http.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		return http.getOrBuild();
	}
	
}
