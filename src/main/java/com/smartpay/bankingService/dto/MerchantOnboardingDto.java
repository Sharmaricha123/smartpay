package com.smartpay.bankingService.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MerchantOnboardingDto {

	private String username;
	private String password;
	private Date timestamp;
	private double latitude;
	private double longitude;
	private int supermerchantId;
	private String ipAddress;
	private MerchantModel merchants;

}
