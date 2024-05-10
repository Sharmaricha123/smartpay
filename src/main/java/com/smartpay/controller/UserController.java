package com.smartpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartpay.dto.UserDto;
import com.smartpay.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
//	

	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto)
	{
		UserDto savedUser= userService.registerUser(userDto);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}

}
