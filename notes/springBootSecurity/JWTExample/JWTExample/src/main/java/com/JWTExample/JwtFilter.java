package com.JWTExample;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	UserDetailsService userdetailsservice;

	@Autowired
	AuthenticationManager authmanager;

	@Autowired
	JwtUtils jwtutils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authentication = request.getHeader("Authorization");
		String username = null;
		String token = null;
		System.out.println("** authentication : " + authentication);

		try {
			if (authentication != null && authentication.startsWith("BEARER")) {
				token = authentication.substring(7);
				System.out.println("token : " + token);
				username = jwtutils.getUsernameFromToken(token);
				System.out.println("User Name : " + username);
			}

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails user = userdetailsservice.loadUserByUsername(username);

				if (jwtutils.validateToken(token, user)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							user, null, user.getAuthorities());

					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			filterChain.doFilter(request, response);
		}

	}

}
