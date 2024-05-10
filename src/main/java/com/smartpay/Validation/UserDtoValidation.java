package com.smartpay.Validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.smartpay.constant.Constant;
import com.smartpay.dto.UserDto;
import com.smartpay.enums.userRequest.UserRegistrationErrorMsg;

public class UserDtoValidation {

	public static List<String> errorList = new ArrayList<>();

	public static void validateUserRegistrationRequest(UserDto userDto) {
		validateFirstName(userDto.getFirstName());
		validateMiddleName(userDto.getMiddleName());
		validateLastName(userDto.getLastName());
		validateMobileNo(userDto.getMobileNo());
		validateDateOfBirth(userDto.getDateOfBirth());
		validateEmailId(userDto.getEmailId());

	}

	
	private static void validateFirstName(String firstName) {
		if (StringUtils.isNotBlank(firstName)) {
			if (firstName.length() < 1 || firstName.length() > 150) {
				errorList.add(UserRegistrationErrorMsg.FIRSTNAMELENGTH.getValue());

			} else {
				if (!firstName.matches(Constant.namePattern)) {
					errorList.add(UserRegistrationErrorMsg.INVALIDFIRSTNAME.getValue());
				}
			}

		} else {
			errorList.add(UserRegistrationErrorMsg.FIRSTNAMEREQUIRED.getValue());
		}

	}

	private static void validateMiddleName(String middleName) {
		if (middleName.length() < 1 || middleName.length() > 150) {
			errorList.add(UserRegistrationErrorMsg.MIDDLENAMELENGTH.getValue());
		} else {
			if (!middleName.matches(Constant.namePattern)) {
				errorList.add(UserRegistrationErrorMsg.INVALIDMIDDLENAME.getValue());
			}
		}

	}

	private static void validateLastName(String lastName) {
		if (StringUtils.isNotBlank(lastName)) {
			if (lastName.length() < 1 || lastName.length() > 150) {
				errorList.add(UserRegistrationErrorMsg.LASTNAMELENGTH.getValue());
			} else {
				if (!lastName.matches(Constant.namePattern)) {
					errorList.add(UserRegistrationErrorMsg.INVALIDLASTNAME.getValue());
				}
			}

		} else {
			errorList.add(UserRegistrationErrorMsg.LASTNAMEREQUIRED.getValue());
		}

	}

	private static void validateMobileNo(String mobileNo) {
		if (StringUtils.isNotBlank(mobileNo)) {
			if (mobileNo.length() != 10) {
				errorList.add(UserRegistrationErrorMsg.MOBILENUMBERLENGTH.getValue());

			} else {
				if (!mobileNo.matches(Constant.mobileNumberPattern)) {
					errorList.add(UserRegistrationErrorMsg.INVALIDMOBILENUMBER.getValue());
				}

			}

		} else {
			errorList.add(UserRegistrationErrorMsg.MOBILENUMBERREQUIRED.getValue());
		}

	}

	private static void validateDateOfBirth(String dateOfBirth) {
		if (StringUtils.isNotBlank(dateOfBirth)) {
			if (!dateOfBirth.matches(Constant.datePattern)) {
				errorList.add(UserRegistrationErrorMsg.INVALIDDATEOFBIRTH.getValue());
			}

		} else {
			errorList.add(UserRegistrationErrorMsg.DOBREQUIRED.getValue());
		}

	}
	
	private static void validateEmailId(String emailId) {
		if (StringUtils.isNotBlank(emailId)) {
			if (emailId.length() < 150) {
				errorList.add(UserRegistrationErrorMsg.EMAILLENGTH.getValue());
			} else {
				if (!emailId.matches(Constant.emailIdPattern)) {
					errorList.add(UserRegistrationErrorMsg.INVALIEMAIL.getValue());
				}
			}

		} else {
			errorList.add(UserRegistrationErrorMsg.EMAILREQUIRED.getValue());
		}

	}


}
