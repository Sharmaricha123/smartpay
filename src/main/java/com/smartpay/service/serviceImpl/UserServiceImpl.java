package com.smartpay.service.serviceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartpay.dto.UserDto;
import com.smartpay.enums.EnumValue;
import com.smartpay.enums.ErrorMsg;
import com.smartpay.enums.EnumValue.BankingServiceStatus;
import com.smartpay.enums.EnumValue.IsActive;
import com.smartpay.enums.EnumValue.UserRole;
import com.smartpay.exception.SmartPayExceptionHandle;
import com.smartpay.exception.SmartPayGlobalException;
import com.smartpay.exception.UserRegistrationException;
import com.smartpay.model.MainWallet;
import com.smartpay.model.User;
import com.smartpay.model.roleandprivilege.Role;
import com.smartpay.repository.RoleRepository;
import com.smartpay.repository.UserRepository;
import com.smartpay.response.Response;
import com.smartpay.service.UserService;
import com.smartpay.to.UserDetailsTo;
import com.smartpay.utility.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User registerUser(UserDto userDto) {
		log.info("Inside User Service : registerUser");

//		User userRegistration = new User();
		UserDetailsTo user = userRepository.findByEmailIdOrMobileNo(userDto.getEmailId(), userDto.getMobileNo());
		if (user == null) {
			Role role = roleRepository.findByRoleName(UserRole.MERCHANT.getRoleName());
			User userRegistration = new User();
			userRegistration.setFirstName(userDto.getFirstName());
			userRegistration.setMiddleName(userDto.getMiddleName());
			userRegistration.setLastName(userDto.getLastName());
			userRegistration.setEmailId(userDto.getEmailId());
			userRegistration.setMobileNo(userDto.getMobileNo());
			userRegistration.setDateOfBirth(StringUtil.convertStringToDate(userDto.getDateOfBirth()));
			userRegistration.setIsActive(EnumValue.IsActive.ACTIVE.toString());
			userRegistration.setBankingServiceStatus(EnumValue.BankingServiceStatus.NO.toString());
			userRegistration.setCustomerId(StringUtil.generateRandomNumber());
			userRegistration.setUsername("IR" + StringUtil.generateLastSixDigit(userDto.getMobileNo()));

			UserDetailsTo parentUser = userRepository.findAdminUser(EnumValue.IsActive.ACTIVE.toString());
			
			if (parentUser != null) {
				userRegistration.setParentUserName(parentUser.getUsername());

			} else {
				throw new RuntimeException("Parent user not found");
			}
			userRegistration
					.setPassword(passwordEncoder.encode(StringUtil.generateDefaultPassword(userDto.getFirstName())));
			userRegistration.setRoles(Arrays.asList(role).stream().collect(Collectors.toSet()));
			userRegistration.setRole(UserRole.MERCHANT.getRoleName());

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
		return	userRepository.save(userRegistration);
			
		} else {
//			throw new RuntimeException("User already registered");
			throw new SmartPayGlobalException(ErrorMsg.Error002.getValue(),HttpStatus.INTERNAL_SERVER_ERROR);


		}

//		return userRegistration;

	}

}
