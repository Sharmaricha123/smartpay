package com.smartpay.bankingService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Settlement {

	private String companyBankAccountNumber;
	private String bankIfscCode;
	private String companyBankName;
	private String bankBranchName;
	private String bankAccountName;

}
