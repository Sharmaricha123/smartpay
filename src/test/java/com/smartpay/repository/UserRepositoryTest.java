/**
 * 
 */
package com.smartpay.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smartpay.model.User;
import com.smartpay.to.UserDetailsTo;

/**
 * 
 */

@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

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
	 * Test method for {@link com.smartpay.repository.UserRepository#findByEmailIdOrMobileNo(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindByEmailIdOrMobileNo() {
		UserDetailsTo userDetailsTo=userRepository.findByEmailIdOrMobileNo("ritik@gmail.com", "7488425850");
		Assertions.assertNotNull(userDetailsTo);
	     
	}

	/**
	 * Test method for {@link com.smartpay.repository.UserRepository#findAdminUser(java.lang.String)}.
	 */
	@Test
	void testFindAdminUser() {
		UserDetailsTo userDetailsTo=userRepository.findAdminUser("ACTIVE");
		Assertions.assertNotNull(userDetailsTo);
	}

	/**
	 * Test method for {@link com.smartpay.repository.UserRepository#findUserByUsername(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindUserByUsername() {
		User user=userRepository.findUserByUsername("AD424879", "ACTIVE");
		Assertions.assertEquals("AD424879", user.getUsername());
	}

	/**
	 * Test method for {@link com.smartpay.repository.UserRepository#updateBankingServiceStatus(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testUpdateBankingServiceStatus() {
	userRepository.updateBankingServiceStatus("402880f390204ea601902058cb3f0004", "NO", "ACTIVE");
	
		
	}

}
