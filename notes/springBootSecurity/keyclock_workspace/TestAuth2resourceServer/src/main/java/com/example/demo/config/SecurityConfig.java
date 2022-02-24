package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		JwtAuthenticationConverter jwtAuthenticationConverter=new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyClockRoleConverter());;
		
		
		http.authorizeRequests()
		.antMatchers("/test")
//		.hasAuthority("SCOPE_profile")
		.hasRole("developer")
		.anyRequest().fullyAuthenticated().and()
		.oauth2ResourceServer()
		.jwt()
		.jwtAuthenticationConverter(jwtAuthenticationConverter);
		
	}
}
