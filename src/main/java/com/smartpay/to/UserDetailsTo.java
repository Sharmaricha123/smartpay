package com.smartpay.to;

import java.util.Date;


public interface UserDetailsTo {
	
	String getUserIdentifactionNo();
	
	long getCustomerId();
	
	Date getDateOfBirth();
	
	String getIsActive();
	
	String getBankingServiceStatus();
	
	String getEmailId();
	
	String getFirstName();
	
	String getMiddleName();
	
	String getLastName();
	
	String getMobileNo();
	
	String getParentUserName();
	
	String getPassword();
	
	String getRole();
	
	String getUsername();
	
//	MainWallet getMainWallet();

}

