package com.smartpay.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartpay.dto.UserDto;
import com.smartpay.exception.UserRegistrationException;
import com.smartpay.mapper.UserMapper;
import com.smartpay.model.User;
import com.smartpay.repository.UserRepository;
import com.smartpay.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto registerUser(UserDto userDto) {

		Optional<User> existingUser = userRepository.findByEmailId(userDto.getEmailId());
		if (existingUser.isPresent()) {
			throw new UserRegistrationException("User with email " + userDto.getEmailId() + " already exists");
		}
		User user = UserMapper.mapToUser(userDto);
		User savedUser = userRepository.save(user);

		return UserMapper.mapToUserDto(savedUser);

	}


}
