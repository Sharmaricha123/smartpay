package com.smartpay.enums;



public enum ErrorMsg {
	Error001("Invalid input!! Please check"),
	Error002("User already registered!!"),
	Error003("Invalid Password!!"),
	Error004("Invalid Credentials"),
	Error005("Error in sending Otp!!!"),
	Error006("User not found!!"),
	Error007("Invalid OTP!!!"),
	Error008("Invalid user!!"),
	Error009("User Profile already updated to merchant");
	
	private String value;
	
	ErrorMsg(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static String getName(String value) {
		ErrorMsg[] errorNames = ErrorMsg.values();
		for (ErrorMsg errorName : errorNames) {
			if (errorName.getValue().equals(value)) {
				return errorName.name();
			}
		}
		return "";
	}

	public static String getValue(String name) {
		ErrorMsg[] errorNames = ErrorMsg.values();
		for (ErrorMsg errorName : errorNames) {
			if (errorName.name().equals(name)) {
				return errorName.getValue();
			}
		}
		return "";
	}


}
