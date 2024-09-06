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

import com.smartpay.model.Merchant;

@SpringBootTest
class MerchantRepositoryTest {
	
	@Autowired
	private MerchantRepository merchantRepository;

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

//	@Test
	void testFindMerchantByMerchantIdentificationNumber() {
		fail("Not yet implemented");
	}

//	@Test
	void testUpdateUploadStatus() {
		fail("Not yet implemented");
	}

	@Test
	void testFindMerchantByUsernameAndOnboardingStatus() {
		Merchant merchantData=merchantRepository.findMerchantByUsernameAndOnboardingStatus("IR424899", "INACTIVE");
		Assertions.assertEquals("IR424899", merchantData.getUserName());
		Assertions.assertEquals("INACTIVE", merchantData.getBankOnboardStatus());
//		fail("Not yet implemented");
	}

}
