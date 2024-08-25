package com.smartpay.repository.parameterizedTest;



	import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.Assertions;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

import com.smartpay.model.User;
import com.smartpay.repository.UserRepository;
import com.smartpay.to.UserDetailsTo;

	/**
	 * 
	 */

	@SpringBootTest
	public class UserRepoParameterizedTest {
		
		
		
		

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
		@ParameterizedTest
		@MethodSource("testFindByEmailOrMobile")
		void testFindByEmailIdOrMobileNo(String email,String mobile) {
			UserDetailsTo userDetailsTo=userRepository.findByEmailIdOrMobileNo(email, mobile) ;
			Assertions.assertNotNull(userDetailsTo);
		     
		}

		/**
		 * Test method for {@link com.smartpay.repository.UserRepository#findAdminUser(java.lang.String)}.
		 */
		
		static Stream<Arguments> testFindByEmailOrMobile() {
		    return Stream.of(
		    		Arguments.of("ritik@gmail.com","7488425850"),
		    		Arguments.of("richa111@gamil.com","9430080344"));
		}
		
		
		
		
		@ParameterizedTest
		@MethodSource("testFindAdminUser")
		void testFindAdminUser(String isActive) {
			UserDetailsTo userDetailsTo=userRepository.findAdminUser(isActive);
			Assertions.assertNotNull(userDetailsTo);
		}
		
		
		static Stream<Arguments> testFindAdminUser() {
		    return Stream.of(
		    		Arguments.of("ACTIVE"),
		    		Arguments.of("INACTIVE"),
		    		Arguments.of("ACTIVE"));
		}

		/**
		 * Test method for {@link com.smartpay.repository.UserRepository#findUserByUsername(java.lang.String, java.lang.String)}.
		 */
		@ParameterizedTest
		@MethodSource("testFindUserByUsername")
		void testFindUserByUsername(String username,String isActive) {
			User user=userRepository.findUserByUsername(username, isActive);
			Assertions.assertEquals("AD424879", user.getUsername());
		}
		
		
		static Stream<Arguments> testFindUserByUsername() {
		    return Stream.of(
		    		Arguments.of("AD424879", "ACTIVE"),
		    		Arguments.of("richa111@gamil.com","9430080344"));
		}
		

		/**
		 * Test method for {@link com.smartpay.repository.UserRepository#updateBankingServiceStatus(java.lang.String, java.lang.String, java.lang.String)}.
		 */
//		@ParameterizedTest
//		void testUpdateBankingServiceStatus() {
//			fail("Not yet implemented");
//		}

	}

	


