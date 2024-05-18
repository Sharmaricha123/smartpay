package com.smartpay.service.serviceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartpay.dto.UserDto;
import com.smartpay.enums.EnumValue;
import com.smartpay.enums.EnumValue.IsActive;
import com.smartpay.enums.EnumValue.UserRole;
import com.smartpay.model.MainWallet;
import com.smartpay.model.User;
import com.smartpay.model.roleandprivilege.Role;
import com.smartpay.repository.AdminRepository;
import com.smartpay.repository.RoleRepository;
import com.smartpay.repository.UserRepository;
import com.smartpay.service.AdminService;
import com.smartpay.utility.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User registerAdmin(UserDto userDto) {

		log.info("Inside User Service : registerAdmin");

//		User userRegistration = new User();
		User user = userRepository.findByEmailIdOrMobileNo(userDto.getEmailId(), userDto.getMobileNo());
		if (user == null) {
			Role role = roleRepository.findByRoleName(UserRole.ADMIN.getRoleName());
			User userRegistration = new User();
			userRegistration.setFirstName(userDto.getFirstName());
			userRegistration.setMiddleName(userDto.getMiddleName());
			userRegistration.setLastName(userDto.getLastName());
			userRegistration.setEmailId(userDto.getEmailId());
			userRegistration.setMobileNo(userDto.getMobileNo());
			userRegistration.setDateOfBirth(StringUtil.convertStringToDate(userDto.getDateOfBirth()));
			userRegistration.setIsActive(EnumValue.IsActive.ACTIVE);
			userRegistration.setBankingServiceStatus(EnumValue.BankingServiceStatus.NO);
			userRegistration.setCustomerId(StringUtil.generateRandomNumber());
			userRegistration.setUsername("AD" + StringUtil.generateLastSixDigit(userDto.getMobileNo()));
			userRegistration.setParentUserName("undefined");
			userRegistration
					.setPassword(passwordEncoder.encode(StringUtil.generateDefaultPassword(userDto.getFirstName())));
			userRegistration.setRoles(Arrays.asList(role).stream().collect(Collectors.toSet()));
			userRegistration.setRole(UserRole.ADMIN.getRoleName());

			MainWallet mainWallet = new MainWallet();
			mainWallet.setCharges(BigDecimal.ZERO);
			mainWallet.setUserName(userRegistration.getUsername());
			mainWallet.setCommissionCredit(BigDecimal.ZERO);
			mainWallet.setCreditAmount(BigDecimal.ZERO);
			mainWallet.setCurrentBalance(BigDecimal.ZERO);
			mainWallet.setDebitAmount(BigDecimal.ZERO);
			mainWallet.setTds(BigDecimal.ZERO);
			mainWallet.setCreditType("NA");
			mainWallet.setDebitType("NA");
			mainWallet.setIsActive(IsActive.ACTIVE);
			mainWallet.setUser(userRegistration);
			userRegistration.setMainWallet(mainWallet);
			return userRepository.save(userRegistration);

		} else {
			throw new RuntimeException("User already registered");

		}

//		return userRegistration;

	}

}
