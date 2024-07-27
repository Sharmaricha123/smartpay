package com.smartpay.constant.dbquery;

public class MerchantQuery {
	
	public static final String MERCHANT_BY_USER_IDENTIFICATION_NUMBER = "SELECT m FROM Merchant m WHERE m.userIdentificationNumber = :userIdentificationNumber";

}
