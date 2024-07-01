package com.smartpay.enums.userRequest;

import com.smartpay.enums.ErrorMsg;

public enum UserRegistrationSuccessMsg {
	

	Success001("User registered successfully"),
	Success002("Otp sent successfully!!!"),
	Success003(" Otp Verified!!!");
	
	private String value;
	
	UserRegistrationSuccessMsg(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static String getName(String value) {
		UserRegistrationSuccessMsg[] successNames = UserRegistrationSuccessMsg.values();
		for (UserRegistrationSuccessMsg successName : successNames) {
			if (successName.getValue().equals(value)) {
				return successName.name();
			}
		}
		return "";
	}

	public static String getValue(String name) {
		UserRegistrationSuccessMsg[] successNames = UserRegistrationSuccessMsg.values();
		for (UserRegistrationSuccessMsg successName : successNames) {
			if (successName.name().equals(name)) {
				return successName.getValue();
			}
		}
		return "";
	}


}

	


