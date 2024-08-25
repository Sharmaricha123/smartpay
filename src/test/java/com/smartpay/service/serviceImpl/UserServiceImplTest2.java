/**
 * 
 */
package com.smartpay.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smartpay.dto.UserDto;
import com.smartpay.model.User;
import com.smartpay.repository.UserRepository;
import com.smartpay.service.UserService;
import com.smartpay.utility.StringUtil;

/**
 * 
 */
@SpringBootTest
class UserServiceImplTest2 {

	@Autowired
	private UserService userService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.smartpay.service.serviceImpl.UserServiceImpl#registerUser(com.smartpay.dto.UserDto)}.
	 */
	@Test
	void testRegisterUser() {
		UserDto user = new UserDto();
		user.setFirstName("Abhishek");
		user.setMiddleName("Sharma");
		user.setLastName("Prakash");
		user.setDateOfBirth("1997-01-09");
		user.setEmailId("abhi@gmail.com");
		user.setMobileNo("9990378610");

		User savedUser = userService.registerUser(user);

	}

}
