package com.smartpay.enums;



public enum ErrorMsg {
	Error001("Invalid input!! Please check");
	
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
