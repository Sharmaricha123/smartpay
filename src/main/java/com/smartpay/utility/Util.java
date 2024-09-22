package com.smartpay.utility;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import org.springframework.web.client.RestTemplate;

import com.smartpay.constant.Constant;
import com.smartpay.exception.RestClientException;
import com.smartpay.exception.TwoFactorClientException;
import com.smartpay.response.TwoFactorResponse;

public class Util {

	public static TwoFactorResponse sendLoginOtp(String mobileNo) {
		TwoFactorResponse twoFactorResponse = null;
		final String LOGINOTPSENDAPI = "https://2factor.in/API/V1/" + Constant.twofactorapikey + "/SMS/" + mobileNo
				+ "/AUTOGEN/SmartPay";
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<TwoFactorResponse> response = restTemplate.exchange(LOGINOTPSENDAPI, HttpMethod.GET, null,
					TwoFactorResponse.class);
			if(response!=null)
			{
			twoFactorResponse = response.getBody();
			}

			return twoFactorResponse;
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			throw new TwoFactorClientException(ex);
//			throw new RestClientException(ex);

		}
	}
	
	public static TwoFactorResponse verifyOtp(String sessionId,String otp)
	{
		TwoFactorResponse twoFactorResponse=null;
		final String VERIFYOTP="https://2factor.in/API/V1/"+Constant.twofactorapikey+"/SMS/VERIFY/"+sessionId+"/"+otp;
		try {
			RestTemplate restTemplate=new RestTemplate();
			ResponseEntity<TwoFactorResponse> response=restTemplate.exchange(VERIFYOTP, HttpMethod.GET, null, TwoFactorResponse.class);
			twoFactorResponse=response.getBody();
			return twoFactorResponse;
		}
		catch (HttpClientErrorException| HttpServerErrorException ex) {
			throw new RestClientException(ex);
		}
	}

}
