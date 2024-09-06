package com.smartpay.bankingService.service;

import java.net.UnknownHostException;

import com.smartpay.response.Response;

public interface OnboardingService {
	
	Response onboardMerchant(String username) throws UnknownHostException;
	
	

}
