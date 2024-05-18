package com.smartpay.constant.dbquery;

public class UserQuery {

	public static final String USER_BY_EMAIL_OR_MOBNO = "SELECT user.username,user.userIdentifactionNo,user.customerId,user.role FROM User user where user.emailId=:emailId OR user.mobileNo=:mobNo";
	
	public static final String ADMIN_INFO_BY_ACTIVE_STATUS="SELECT user.username,user.userIdentifactionNo,user.customerId,user.role FROM User user where user.username like 'AD%' AND  user.isActive=:isActive";
			
	

}
