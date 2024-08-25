package com.smartpay.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smartpay.dto.UserDto;
import com.smartpay.model.User;
import com.smartpay.service.UserService;

@SpringBootTest
class UserServiceImplParametrizedTest {
	
	@Autowired
	private UserService userService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("testRegisterUser")
	void testRegisterUser(String firstName,String middleName,String lastName,String dateOfBirth,String emailId,String mobileNumber ) {
		UserDto user = new UserDto();
		user.setFirstName(firstName);
		user.setMiddleName(middleName);
		user.setLastName(lastName);
		user.setDateOfBirth(dateOfBirth);
		user.setEmailId(emailId);
		user.setMobileNo(mobileNumber);

		User savedUser = userService.registerUser(user);
	}
	
	 static Stream<Arguments> testRegisterUser() {
	        return Stream.of(
	            Arguments.of("John", "", "Doe", "1990-05-21", "john.doe@example.com", "8888888888"),
	            Arguments.of("Jane", "Marie", "Doe", "1985-12-15", "jane.doe@example.com", "7777777777")
	        );
	    }

}
