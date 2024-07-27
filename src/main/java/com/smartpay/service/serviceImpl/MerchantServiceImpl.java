package com.smartpay.service.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartpay.dto.AddressDto;
import com.smartpay.dto.MerchantBankDetailsDto;
import com.smartpay.dto.MerchantDto;
import com.smartpay.enums.EnumValue;
import com.smartpay.exception.ResourceNotFoundException;
import com.smartpay.exception.SmartPayGlobalException;
import com.smartpay.enums.ErrorMsg;
import com.smartpay.model.Address;
import com.smartpay.model.AepsWallet;
import com.smartpay.model.Merchant;
import com.smartpay.model.MerchantBankDetails;
import com.smartpay.model.User;
import com.smartpay.repository.MerchantRepository;
import com.smartpay.repository.UserRepository;
import com.smartpay.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public Merchant updateUserProfile(String username, MerchantDto merchantDto) {
		User user = userRepository.findUserByUsername(username, EnumValue.IsActive.ACTIVE.toString());
		if (user != null) {
			Merchant merchant = merchantRepository
					.findMerchantByUserIdentificationNumber(user.getUserIdentifactionNo());
			if (merchant == null) {

				Merchant merchantProfile = new Merchant();
				merchantProfile.setGuardian(merchantDto.getGuardian());
				merchantProfile.setMaritalStatus(EnumValue.MartialStatus.MARRIED.toString());
				merchantProfile.setBusinessType(EnumValue.BusinessType.INDIVIDUAL.toString());
				merchantProfile.setGender(EnumValue.Gender.MALE.toString());
				merchantProfile.setPancardNumber(merchantDto.getPancardNumber());
				merchantProfile.setAdharcardNumber(merchantDto.getAdharcardNumber());
				merchantProfile.setBusinessPanNumber(merchantDto.getBusinessPanNumber());
				merchantProfile.setGstNumber(merchantDto.getGstNumber());
				merchantProfile.setTanNumber(merchantDto.getTanNumber());
				merchantProfile.setLegalName(merchantDto.getLegalName());
				merchantProfile.setMarketingName(merchantDto.getMarketingName());
				merchantProfile.setIsActive(EnumValue.IsActive.ACTIVE.toString());
				merchantProfile.setAepsStatus(EnumValue.IsActive.INACTIVE.toString());
				merchantProfile.setEkycStatus(EnumValue.IsActive.INACTIVE.toString());
				merchantProfile.setUploadStatus(EnumValue.IsActive.INACTIVE.toString());
				merchantProfile.setBankOnboardStatus(EnumValue.IsActive.INACTIVE.toString());
				merchantProfile.setFirstName(user.getFirstName());
				merchantProfile.setMiddleName(user.getMiddleName());
				merchantProfile.setLastName(user.getLastName());
				merchantProfile.setEmailId(user.getEmailId());
				merchantProfile.setMobileNumber(user.getMobileNo());
				merchantProfile.setUserName(user.getUsername());

				AepsWallet aepsWallet = new AepsWallet();
				aepsWallet.setCharges(BigDecimal.ZERO);
				aepsWallet.setCommissionCredit(BigDecimal.ZERO);
				aepsWallet.setCreditAmount(BigDecimal.ZERO);
				aepsWallet.setCurrentBalance(BigDecimal.ZERO);
				aepsWallet.setDebitAmount(BigDecimal.ZERO);
				aepsWallet.setTds(BigDecimal.ZERO);
				aepsWallet.setCreditType("NA");
				aepsWallet.setDebitType("NA");
				aepsWallet.setIsActive(EnumValue.IsActive.INACTIVE.toString());
				aepsWallet.setMerchant(merchantProfile);

				merchantProfile.setAepsWallet(aepsWallet);

				merchantProfile.setAddress(addAddressDetails(merchantDto.getAddress(), merchantProfile));
				merchantProfile.setBankDetails(addBankDetails(merchantDto.getBankDetails(), merchantProfile));

				Merchant savedMerchant = merchantRepository.save(merchantProfile);
				return savedMerchant;

			} else {
				throw new SmartPayGlobalException(ErrorMsg.Error009.getValue(), HttpStatus.EXPECTATION_FAILED);

			}

		} else {
			throw new ResourceNotFoundException(ErrorMsg.Error006.getValue() + username);

		}

	}

	private Set<MerchantBankDetails> addBankDetails(Set<MerchantBankDetailsDto> merchantBankDetailsDtos,
			Merchant merchant) {
		Set<MerchantBankDetails> bankDetails = new HashSet<>();
		merchantBankDetailsDtos.forEach(merchantBankDetailsDto -> {
			MerchantBankDetails merchantBankDetails = new MerchantBankDetails();
			merchantBankDetails.setAccountHolderName(merchantBankDetailsDto.getAccountHolderName());
			merchantBankDetails.setAccountNumber(merchantBankDetailsDto.getAccountNumber());
			merchantBankDetails.setIfscCode(merchantBankDetailsDto.getIfscCode());
			merchantBankDetails.setAccountType(merchantBankDetailsDto.getAccountType());
			merchantBankDetails.setBankName(merchantBankDetailsDto.getAccountType());
			merchantBankDetails.setBranchName(merchantBankDetailsDto.getBranchName());
			merchantBankDetails.setMerchant(merchant);
			bankDetails.add(merchantBankDetails);
		});
		return bankDetails;

	}

	private List<Address> addAddressDetails(List<AddressDto> addressDtos, Merchant merchant) {
		List<Address> addressDetails = new ArrayList<>();
		addressDtos.forEach(addressDto -> {
			Address details = new Address();
			details.setAddress(addressDto.getAddress());
			details.setCountry(addressDto.getCountry());
			details.setDistrict(addressDto.getDistrict());
			details.setState(addressDto.getState());
			details.setPincode(addressDto.getPincode());
			details.setVillageCity(addressDto.getVillageCity());
			details.setAddressType(addressDto.getAddressType());
			details.setMerchant(merchant);
			addressDetails.add(details);

		});
		return addressDetails;

	}

}
