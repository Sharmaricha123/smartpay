package com.smartpay.bankingService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantModel {
	
	private String merchantLoginId;
	private String merchantLoginPin;
	private String merchantName;
	private MerchantAddress merchantAddress;
	private String merchantPhoneNumber;
	private String companyLegalName;
	private String companyMarketingName;
	private Kyc kyc;
	private Settlement settlement;
	private String emailId;
	private String shopAndPanImage;
	private String cancellationCheckImages;
	private String ekycDocuments;
	private String merchantPinCode;
	private String tan;
	private String merchantCityName;
	private String merchantDistrictName;

}
