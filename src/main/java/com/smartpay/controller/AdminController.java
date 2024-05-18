package com.smartpay.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartpay.Validation.UserDtoValidation;
import com.smartpay.dto.UserDto;
import com.smartpay.enums.ErrorMsg;
import com.smartpay.enums.userRequest.UserRegistrationSuccessMsg;
import com.smartpay.model.User;
import com.smartpay.response.Response;
import com.smartpay.service.AdminService;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {
	
	@Lazy
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> registerAdmin(@Valid @RequestBody UserDto userDto) {
		List<String> errList = UserDtoValidation.validateUserRegistrationRequest(userDto);
		User result = null;

		if (errList.isEmpty()) {
			result = adminService.registerAdmin(userDto);

		} else {
			return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.BAD_REQUEST, false,
					ErrorMsg.Error001.getValue(), errList), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.CREATED, true,
				UserRegistrationSuccessMsg.Success001.getValue(), result), HttpStatus.CREATED);

	}

}
