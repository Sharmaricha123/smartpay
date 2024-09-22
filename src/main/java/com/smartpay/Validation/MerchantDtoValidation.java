package com.smartpay.Validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.smartpay.constant.Constant;
import com.smartpay.dto.AddressDto;
import com.smartpay.dto.MerchantBankDetailsDto;
import com.smartpay.dto.MerchantDto;
import com.smartpay.enums.MerchantErrorMsg;
import com.smartpay.model.Address;

public class MerchantDtoValidation {

	public static List<String> errorList = new ArrayList<>();

	public static List<String> validateMerchantUser(MerchantDto merchantDto) {
		validateGuardian(merchantDto.getGuardian());
		validatePanCard(merchantDto.getPancardNumber());
		validateAadharCard(merchantDto.getAdharcardNumber());
		validateBusinessPanNumber(merchantDto.getBusinessPanNumber());
		validateGST(merchantDto.getGstNumber());
		validateTanNumber(merchantDto.getTanNumber());
		validateCompanyLegalName(merchantDto.getLegalName());
		validateCompanyMarketingName(merchantDto.getMarketingName());
		validateGender(merchantDto.getGender());
		if (!merchantDto.getAddress().isEmpty()) {
			merchantDto.getAddress().forEach(address -> {
				validateMerchantAddress(address);
			});

		} else {
			errorList.add("");
		}

		if (!merchantDto.getBankDetails().isEmpty()) {
			merchantDto.getBankDetails().forEach(bankdetails -> {
				validateMerchantBankDetails(bankdetails);
			});

		} else {
			errorList.add("");
		}

		return errorList;
	}

	public static void validateGuardian(String guardian) {
		if (StringUtils.isNotBlank(guardian)) {
			if (guardian.length() < 1 || guardian.length() > 200) {
				errorList.add(MerchantErrorMsg.ME001.getValue());

			} else {
				if (!guardian.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME002.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME003.getValue());
		}

	}

	public static void validatePanCard(String pancardNumber) {
		if (StringUtils.isNotBlank(pancardNumber)) {
			if (pancardNumber.length() == 10) {

				if (!pancardNumber.matches(Constant.panCardPattern)) {
					errorList.add(MerchantErrorMsg.ME005.getValue());
				}

			} else {
				errorList.add(MerchantErrorMsg.ME004.getValue());

			}
		}

	}

	public static void validateAadharCard(String aadharcardNumber) {
		if (StringUtils.isNotBlank(aadharcardNumber)) {
			if (aadharcardNumber.length() == 12) {
				if (!aadharcardNumber.matches(Constant.adharCardPattern)) {
					errorList.add(MerchantErrorMsg.ME007.getValue());
				}

			} else {
				errorList.add(MerchantErrorMsg.ME008.getValue());
			}

		} else {
			errorList.add(MerchantErrorMsg.ME009.getValue());
		}
	}

	public static void validateBusinessPanNumber(String businessPanNumber) {
		if (StringUtils.isNotBlank(businessPanNumber)) {
			if (businessPanNumber.length() == 15) {
				if (!businessPanNumber.matches(Constant.businessPannoPattern)) {
					errorList.add(MerchantErrorMsg.ME0010.getValue());
				}

			} else

			{
				errorList.add(MerchantErrorMsg.ME0011.getValue());
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0012.getValue());

		}
	}

	public static void validateGST(String gstNumber) {
		if (StringUtils.isNotBlank(gstNumber)) {
			if (gstNumber.length() == 15) {
				if (!gstNumber.matches(Constant.gstNoPattern)) {
					errorList.add(MerchantErrorMsg.ME0013.getValue());
				}

			} else {
				errorList.add(MerchantErrorMsg.ME0014.getValue());
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0015.getValue());
		}
	}

	public static void validateTanNumber(String tanNumber) {
		if (StringUtils.isNotBlank(tanNumber)) {
			if (tanNumber.length() == 10) {
				if (!tanNumber.matches(Constant.tanNoPattern)) {
					errorList.add(MerchantErrorMsg.ME0016.getValue());
				}

			} else {
				errorList.add(MerchantErrorMsg.ME0017.getValue());
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0018.getValue());
		}
	}

	public static void validateCompanyLegalName(String legalName) {
		if (StringUtils.isNotBlank(legalName)) {

			if (legalName.length() < 10 || legalName.length() > 50) {
				errorList.add(MerchantErrorMsg.ME0019.getValue());

			} else {
				if (!legalName.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0020.getValue());
				}
			}
		} else {
			errorList.add(MerchantErrorMsg.ME0021.getValue());

		}
	}

	public static void validateCompanyMarketingName(String marketingName) {
		if (StringUtils.isNotBlank(marketingName)) {
			if (marketingName.length() < 10 || marketingName.length() > 50) {
				errorList.add(MerchantErrorMsg.ME0022.getValue());

			} else {
				if (!marketingName.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0023.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0024.getValue());
		}
	}

	public static void validateGender(String gender) {
		if (StringUtils.isBlank(gender)) {
			errorList.add(MerchantErrorMsg.ME0058.getValue());
		}
	}

	public static void validateMaritalStatus(String maritalStatus) {
		if (StringUtils.isBlank(maritalStatus)) {
			errorList.add(MerchantErrorMsg.ME0059.getValue());
		}

	}

	public static void validateBusinessType(String businessType) {

		if (StringUtils.isBlank(businessType)) {
			errorList.add(MerchantErrorMsg.ME0060.getValue());
		}

	}

	public static List<String> validateMerchantAddress(AddressDto addressDto) {

		validateAddress(addressDto.getAddress());
		validateCountry(addressDto.getCountry());
		validateState(addressDto.getState());
		validateDistrict(addressDto.getDistrict());
		validateVillageCity(addressDto.getVillageCity());
		validatePinCode(addressDto.getPincode());
		validateAddressType(addressDto.getAddressType());
		return errorList;
	}

	public static void validateAddress(String address) {
		if (StringUtils.isNotBlank(address)) {
			if (address.length() < 1 || address.length() > 200) {
				errorList.add(MerchantErrorMsg.ME0025.getValue());

			}

		} else {
			errorList.add(MerchantErrorMsg.ME0027.getValue());
		}
	}

	public static void validateCountry(String country) {
		if (StringUtils.isNotBlank(country)) {
			if (country.length() < 1 || country.length() > 200) {
				errorList.add(MerchantErrorMsg.ME0028.getValue());

			} else {
				if (!country.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0029.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0030.getValue());
		}
	}

	public static void validateState(String state) {
		if (StringUtils.isNotBlank(state)) {
			if (state.length() < 1 || state.length() > 200) {
				errorList.add(MerchantErrorMsg.ME0031.getValue());

			} else {
				if (!state.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0032.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0033.getValue());
		}

	}

	public static void validateDistrict(String district) {
		if (StringUtils.isNotBlank(district)) {
			if (district.length() < 1 || district.length() > 200) {
				errorList.add(MerchantErrorMsg.ME0034.getValue());

			} else {
				if (!district.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0035.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0036.getValue());
		}

	}

	public static void validateVillageCity(String city) {

		if (StringUtils.isNotBlank(city)) {
			if (city.length() < 1 || city.length() > 200) {
				errorList.add(MerchantErrorMsg.ME0037.getValue());

			} else {
				if (!city.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0038.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0039.getValue());
		}

	}

	public static void validatePinCode(String pincode) {
		if (StringUtils.isNotBlank(pincode)) {
			if (pincode.length() == 6) {
				if (!pincode.matches(Constant.pincodePattern)) {
					errorList.add(MerchantErrorMsg.ME0040.getValue());
				}

			} else {
				errorList.add(MerchantErrorMsg.ME0041.getValue());
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0042.getValue());
		}
	}

	public static void validateAddressType(String addressType) {
		if (StringUtils.isBlank(addressType)) {
			errorList.add(MerchantErrorMsg.ME0062.getValue());
		}
	}

	public static List<String> validateMerchantBankDetails(MerchantBankDetailsDto merchantBankDetailsDto) {
		validateAccountHolderName(merchantBankDetailsDto.getAccountHolderName());
		validateBankName(merchantBankDetailsDto.getBankName());
		validateBranchName(merchantBankDetailsDto.getBranchName());
		validateAccountNumber(merchantBankDetailsDto.getAccountNumber());
		validateIfscNumber(merchantBankDetailsDto.getIfscCode());
		validateAccountType(merchantBankDetailsDto.getAccountType());

		return errorList;
	}

	public static void validateAccountHolderName(String accounHolderName) {
		if (StringUtils.isNotBlank(accounHolderName)) {
			if (accounHolderName.length() < 1 || accounHolderName.length() > 200) {
				errorList.add(MerchantErrorMsg.ME0043.getValue());

			} else {
				if (!accounHolderName.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0044.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0045.getValue());
		}

	}

	public static void validateBankName(String bankName) {
		if (StringUtils.isNotBlank(bankName)) {
			if (bankName.length() < 1 || bankName.length() > 200) {
				errorList.add(MerchantErrorMsg.ME0046.getValue());

			} else {
				if (!bankName.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0047.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0048.getValue());
		}

	}

	public static void validateBranchName(String branchName) {
		if (StringUtils.isNotBlank(branchName)) {
			if (branchName.length() < 1 || branchName.length() > 200) {
				errorList.add(MerchantErrorMsg.ME0049.getValue());

			} else {
				if (!branchName.matches(Constant.namePattern)) {
					errorList.add(MerchantErrorMsg.ME0050.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0051.getValue());
		}

	}

	public static void validateAccountNumber(String accountNumber) {

		if (StringUtils.isNotBlank(accountNumber)) {
			if (accountNumber.length() == 12) {
				if (!accountNumber.matches(Constant.bankAccNo)) {
					errorList.add(MerchantErrorMsg.ME0053.getValue());
				}

			} else {
				errorList.add(MerchantErrorMsg.ME0052.getValue());

			}

		} else {
			errorList.add(MerchantErrorMsg.ME0054.getValue());
		}

	}

	public static void validateIfscNumber(String ifscNumber) {

		if (StringUtils.isNotBlank(ifscNumber)) {
			if (ifscNumber.length() < 1 || ifscNumber.length() > 12) {
				errorList.add(MerchantErrorMsg.ME0055.getValue());

			} else {
				if (!ifscNumber.matches(Constant.ifscCode)) {
					errorList.add(MerchantErrorMsg.ME0056.getValue());
				}
			}

		} else {
			errorList.add(MerchantErrorMsg.ME0057.getValue());
		}

	}

	public static void validateAccountType(String accountType) {
		if (StringUtils.isBlank(accountType)) {
			errorList.add(MerchantErrorMsg.ME0061.getValue());
		}
	}

}
