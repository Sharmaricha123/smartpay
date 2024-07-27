package com.smartpay.dto;

import java.util.List;
import java.util.Set;

import com.smartpay.model.Address;
import com.smartpay.model.AepsWallet;
import com.smartpay.model.MerchantBankDetails;
import com.smartpay.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDto {

	private String guardian;

	private String gender;

	private String maritalStatus;

	private List<AddressDto> address;

	private Set<MerchantBankDetailsDto> bankDetails;

	private String adharcardNumber;

	private String businessPanNumber;


	private String gstNumber;

	private String pancardNumber;


	private String tanNumber;

	private String legalName;

	private String marketingName;

	private String businessType;

}
