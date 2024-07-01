package com.smartpay.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.smartpay.enums.ErrorMsg;
import com.smartpay.exception.BadCredentialsException;
import com.smartpay.model.User;
import com.smartpay.repository.UserRepository;

@Component
public class SmartPayAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		User userPresent = userRepository.findUserByUsername(username);
		if (userPresent != null) {
			if (passwordEncoder.matches(password, userPresent.getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(userPresent.getRole()));
				return new UsernamePasswordAuthenticationToken( username, password,authorities);
			} else {
				throw new BadCredentialsException(ErrorMsg.Error003.getValue(), HttpStatus.BAD_REQUEST);
			}

		} else {
			throw new BadCredentialsException(ErrorMsg.Error004.getValue(), HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
