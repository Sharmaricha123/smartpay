package com.smartpay.enums;

public enum MerchantSuccessMsg {

	MS001("User Profile updated to merchant !!!!!");

	private String value;

	MerchantSuccessMsg(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static String getName(String value) {
		MerchantSuccessMsg[] merchantSuccessMsg = MerchantSuccessMsg.values();
		for (MerchantSuccessMsg successMsg : merchantSuccessMsg) {
			if (successMsg.getValue().equals(value)) {
				return successMsg.name();
			}
		}
		return "";
	}

	public static String getValue(String name) {
		MerchantSuccessMsg[] merchantSuccessMsg = MerchantSuccessMsg.values();
		for (MerchantSuccessMsg successMsg : merchantSuccessMsg) {
			if (successMsg.name().equals(name)) {
				return successMsg.getValue();
			}
		}
		return "";
	}

}
