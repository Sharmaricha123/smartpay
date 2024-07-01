package com.smartpay.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartpay.enums.ErrorMsg;
import com.smartpay.enums.userRequest.UserRegistrationSuccessMsg;
import com.smartpay.model.User;
import com.smartpay.repository.UserRepository;
import com.smartpay.response.Response;
import com.smartpay.response.TwoFactorResponse;
import com.smartpay.security.SmartPayAuthenticationProvider;
import com.smartpay.utility.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

	@Autowired
	private SmartPayAuthenticationProvider smartPayAuthenticationProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	

	@PostMapping("/sendotp")
	public ResponseEntity<Response> loginUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		Authentication authentication = smartPayAuthenticationProvider
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		if (authentication.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			 log.debug("Authentication details: {}", authentication.getDetails());
             log.debug("Authenticated user: {}", authentication.getName());
			User user = userRepository.findUserByUsername(authentication.getName());
			if (user != null) {
				TwoFactorResponse twoFactorResponse = Util.sendLoginOtp(user.getMobileNo());
				if(twoFactorResponse.getStatus().equalsIgnoreCase("Success"))
				{
					return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.OK, true,
							UserRegistrationSuccessMsg.Success002.getValue(), twoFactorResponse), HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, false,
							ErrorMsg.Error005.getValue(), null), HttpStatus.INTERNAL_SERVER_ERROR);
				}

			} else {
				return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.NOT_FOUND, false,
						ErrorMsg.Error006.getValue(), null), HttpStatus.NOT_FOUND);
			}
		}

		
		return new ResponseEntity<Response>(
				new Response(LocalDateTime.now(), HttpStatus.UNAUTHORIZED, false, ErrorMsg.Error004.getValue(), null),
				HttpStatus.UNAUTHORIZED);

	}
	
	@PostMapping("/verifyotp")
	public ResponseEntity<Response> loginAndVerifyOtp(@RequestParam("sessionId") String sessionId,@RequestParam("otp") String otp)
	{
		TwoFactorResponse twoFactorResponse=Util.verifyOtp(sessionId,otp);
		if(twoFactorResponse.getStatus().equalsIgnoreCase("Success"))
		{
			return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.OK, true, UserRegistrationSuccessMsg.Success003.getValue(),twoFactorResponse),HttpStatus.OK );
			
		}
		return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.NOT_ACCEPTABLE, true, ErrorMsg .Error007.getValue(),null),HttpStatus.NOT_ACCEPTABLE );
		
		
	}

}
