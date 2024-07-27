package com.smartpay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantBankDetailsDto {

	private String accountHolderName;

	private String accountNumber;

	private String accountType;

	private String bankName;

	private String branchName;

	private String ifscCode;

}
