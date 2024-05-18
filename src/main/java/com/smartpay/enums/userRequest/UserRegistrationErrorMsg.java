package com.smartpay.enums.userRequest;

public enum UserRegistrationErrorMsg {

	FIRSTNAMEREQUIRED("first name is required"),
	FIRSTNAMELENGTH(" first name length should be more than 1 and less than 5"),
	INVALIDFIRSTNAME("invalid first name"),
	MIDDLENAMELENGTH(" middle name length should be more than 1 and less than 10"),
	INVALIDMIDDLENAME("invalid middle name"),
	LASTNAMEREQUIRED("last name is required"),
	LASTNAMELENGTH(" last name length should be more than 1 and less than 10"), 
	INVALIDLASTNAME("invalid last name"),
	MOBILENUMBERREQUIRED("mobile number is required"),
	MOBILENUMBERLENGTH(" mobile number should be of 10 digits"),
	INVALIDMOBILENUMBER("invalid mobile number"), 
	DOBREQUIRED("date of birth required"),
	INVALIDDATEOFBIRTH("invalid date of birth"), 
	EMAILREQUIRED("email is required"),
	EMAILLENGTH("length of email id should not exceed 20"),
	INVALIEMAIL("invalid email id");

	private String value;

	UserRegistrationErrorMsg(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static String getName(String value) {
		UserRegistrationErrorMsg[] errorNames = UserRegistrationErrorMsg.values();
		for (UserRegistrationErrorMsg errorName : errorNames) {
			if (errorName.getValue().equals(value)) {
				return errorName.name();
			}
		}
		return "";
	}

	public static String getValue(String name) {
		UserRegistrationErrorMsg[] errorNames = UserRegistrationErrorMsg.values();
		for (UserRegistrationErrorMsg errorName : errorNames) {
			if (errorName.name().equals(name)) {
				return errorName.getValue();
			}
		}
		return "";
	}

}
