package com.smartpay.constant.dbquery;

public class MerchantQuery {
	
	public static final String MERCHANT_BY_USER_IDENTIFICATION_NUMBER = "SELECT m FROM Merchant m WHERE m.merchantIdentificationNo = :identificationNumber AND m.isActive =:activeStatus";
	
	public static final String MERCHANT_DOCUMENT_BY_MERCHANT_IDENTIFICATION_NUMBER="SELECT m FROM MerchantDocument m WHERE m.merchantIdentificationNo=:identificationNumber";
	

	public static final String UPDATE_MERCHANT_UPLOAD_STATUS="UPDATE Merchant m SET m.uploadStatus=:uploadStatus WHERE m.merchantIdentificationNo=:merchantId AND m.isActive=:activeStatus";
	
	public static final String FIND_MERCHANT_BY_USERNAME_AND_ONBOARD_STATUS="SELECT m FROM Merchant m WHERE m.username=:username AND m.bankOnboardStatus=:onboardingStatus";
}
