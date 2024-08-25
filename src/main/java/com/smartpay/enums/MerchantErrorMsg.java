package com.smartpay.enums;

public enum MerchantErrorMsg {

	ME001("Guardian name should be more than 1 and less than 10!!!!!"),
	ME002("Invalid Guardian name!!!!!"),
	ME003("Guardian name is required!!!!!"),
	ME004("Pancard Number should be of 10 digits!!!!!"),
	ME005("Invalid PanNumber!!!!!"),
	ME006("Pan Number is required!!!!!"),
	ME007("Invalid aadharcard Number!!!!!"),
	ME008("Aadhar Card Number should be of length 12!!!!!"),
	ME009("AadharCard Number is required !!!!!"),
	ME0010("Invalid Business PanNumber !!!!!"),
	ME0011("Business Pan Number should be of length 15 !!!!!"),
	ME0012(" Buisness Pan Number is required !!!!!"),
	ME0013("Invalid Gst Number !!!!!"),
	ME0014("GST number should be of length 15 !!!!!"),
	ME0015("GST Number is required !!!!!"),
	ME0016("Invalid Tan Number !!!!!"),
	ME0017("Tan Number should be of length 10 !!!!!"),
	ME0018("Tan Number is required !!!!!"),
	ME0019("Company Legal Name should be more than 10 and less than 50 !!!!!"),
	ME0020("Invalid company Legal Name !!!!!"),
	ME0021(	"Company Legal Name is required !!!!!"),
	ME0022("Company marketing name should be more than 10 and less than 50 !!!!!"),
	ME0023("Invalid company marketing name !!!!!"),
	ME0024("Company marketing name is required !!!!!"),
	ME0025("Address should be more than 1 and less than 200 !!!!!"),
	ME0026("Invalid address !!!!!"),
	ME0027("Address is required !!!!!"),
	ME0028("Country should be more than 1 and less thanh 200 !!!!!"),
	ME0029("Invalid Country name !!!!!"),
	ME0030("Country name is required !!!!!"),
	ME0031("State should be more than 1 and less than 200 !!!!! "),
	ME0032("Invalid state !!!!!"),
	ME0033("State is required !!!!!!"),
	ME0034("District should be more than 1 and less than 200 !!!!!"),
	ME0035("Invalid ditrict !!!!!"),
	ME0036("District is rfequired !!!!!"),
	ME0037("City should be more than 1 and less than 20 !!!!!"),
	ME0038("Invalid city !!!!!"),
	ME0039("City is required !!!!!"),
	ME0040("Invalid pincode !!!!!"),
	ME0041("Pincode should of 6 digits !!!!!"),
	ME0042("Pincode ie required !!!!!"),
	ME0043("Account Holder name should be greater than 1 and less than 200 !!!!!"),
	ME0044("Invalid AccountHolderName !!!!!"),
	ME0045("Account Holder Name is required !!!!!"),
	ME0046("Bank Name should be greater than 1 and less than 200 !!!!!"),
	ME0047("Invalid Bank Name !!!!!"),
	ME0048("Bank Name is required !!!!!"),
	ME0049("Branch Name should be greater than 1 and leass than 200 !!!!!"),
	ME0050("Invalid Branch Name"),
	ME0051("Invalid Branch Name !!!!!"),
	ME0052("Account Number should be of 12 digits !!!!!"),
	ME0053("Invalid Account Number !!!!!"),
	ME0054("Account Number is required !!!!!"),
	ME0055("Ifsc Number should be of 11 digits !!!!!"),
	ME0056("Invalid ifsc number !!!!!"),
	ME0057("Ifsc Number is required !!!!!"),
	ME0058("Gender is required !!!!!"),
	ME0059("Martial Status is required !!!!!"),
	ME0060("Business Type is required !!!!!"),
	ME0061("Account Type is required !!!!!"),
	ME0062("Address Type is required !!!!!"),
	ME0063("Error in updating profile !!!!!"),
	ME0064("Documents upload Failed !!!!!");
	
	private String value;

	MerchantErrorMsg(String value) {
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
