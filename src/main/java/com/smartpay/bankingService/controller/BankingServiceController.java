package com.smartpay.bankingService.controller;

import java.net.UnknownHostException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.smartpay.bankingService.service.OnboardingService;

import com.smartpay.response.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("v1/merchant")
public class BankingServiceController {
	
	@Autowired
	private OnboardingService onboardingService;
	
	@PostMapping("/merchant/onboarding/{username}")
	public ResponseEntity<Response> onboardMerchantToBankSystem(@PathVariable String username) throws UnknownHostException
	{
		log.info("username ----->",username);
		
		Response response=onboardingService.onboardMerchant(username);
		log.info("response ------>",response);
		if(response .isProcessStatus())
		{
			return new ResponseEntity<Response>(new Response(response.getTimestamp(), response.getStatusCode(), true,response.getMessage(), response.getDatasource()),response.getStatusCode());
		}
		else
		{
			return new ResponseEntity<Response>(new Response(response.getTimestamp(),response.getStatusCode(), false,response.getMessage(), response.getDatasource()),response.getStatusCode());
			
		}
		
		
	}
	
	

}
