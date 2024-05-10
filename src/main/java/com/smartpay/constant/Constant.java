package com.smartpay.constant;

public class Constant {
	
	  public static final String namePattern = "^[a-zA-Z][a-zA-Z ]+[a-zA-Z]$";
	    public static final String mobileNumberPattern = "^[6-9]{1}[0-9]{9}$";
	    public static final String emailIdPattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	    public static final String pincodePattern = "^[1-9]{1}[0-9]{2}[0-9]{3}$";
	    public static final String panCardPattern = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
	    public static final String businessPannoPattern = "^[0-9]{2}[A-Z]{3}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}X[0-9A-Z]{3}$";
	    public static final String adharCardPattern = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";
	    public static final String gstNoPattern = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$";
	    public static final String tanNoPattern = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
	    public static final String bankAccNo = "^[0-9]{9,18}$";
	    public static final String ifscCode = "^[A-Z]{4}0[A-Z0-9]{6}$";
	    public static final String datePattern="\\d{4}-\\d{2}-\\d{2}";

}
