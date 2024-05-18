package com.smartpay.service;

import com.smartpay.dto.UserDto;
import com.smartpay.model.User;
import com.smartpay.response.Response;

public interface UserService {
	
	public User registerUser(UserDto userDto) ;

}
