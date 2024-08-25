package com.smartpay.bankingService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Kyc {
	
	private String userPan;
	private String aadharNumber;
	private String gstInNumber;
	private String companyOrShopPan;

}
