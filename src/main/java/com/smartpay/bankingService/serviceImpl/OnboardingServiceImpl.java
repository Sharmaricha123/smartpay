package com.smartpay.bankingService.serviceImpl;

import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.smartpay.bankingService.dto.Kyc;
import com.smartpay.bankingService.dto.MerchantAddress;
import com.smartpay.bankingService.dto.MerchantModel;
import com.smartpay.bankingService.dto.MerchantOnboardingDto;
import com.smartpay.bankingService.dto.Settlement;
import com.smartpay.bankingService.service.OnboardingService;
import com.smartpay.constant.Constant;
import com.smartpay.enums.EnumValue;
import com.smartpay.exception.ResourceNotFoundException;
import com.smartpay.exception.RestClientException;
import com.smartpay.model.Merchant;
import com.smartpay.model.MerchantDocument;
import com.smartpay.repository.MerchantDocumentRepository;
import com.smartpay.repository.MerchantRepository;
import com.smartpay.response.Response;
import com.smartpay.utility.StringUtil;

@Service
public class OnboardingServiceImpl implements OnboardingService {

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private MerchantDocumentRepository merchantDocumentRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Response onboardMerchant(String username) throws UnknownHostException {

		Merchant merchantData = merchantRepository.findMerchantByUsernameAndOnboardingStatus(username,
				EnumValue.IsActive.INACTIVE.toString());
		if(merchantData!=null)
		{
		
		MerchantOnboardingDto merchantOnboardingDto = onboardingRequestData(merchantData);
		try {

			HttpEntity<MerchantOnboardingDto> httpEntity = new HttpEntity<MerchantOnboardingDto>(merchantOnboardingDto);
			Response response = restTemplate.postForObject(Constant.onboardingapi, httpEntity, Response.class);

			return response;
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			throw new RestClientException(ex);
		}
		}else
		{
			throw new ResourceNotFoundException("User not found or User already onboarded");
		}
		
	}

	private MerchantOnboardingDto onboardingRequestData(Merchant merchantData) throws UnknownHostException {
		MerchantOnboardingDto merchantOnboardingDto = new MerchantOnboardingDto();
		merchantOnboardingDto.setUsername("richa123");
		merchantOnboardingDto.setPassword("richa@123");
		merchantOnboardingDto.setTimestamp(new Date());
		merchantOnboardingDto.setSupermerchantId(123456);
		merchantOnboardingDto.setIpAddress(StringUtil.getSystemIpAddress());

		MerchantModel merchantModel = new MerchantModel();
		merchantModel.setMerchantLoginId(merchantData.getUserName());
		merchantModel.setMerchantLoginPin("123456");
		merchantModel.setMerchantName(
				merchantData.getFirstName() + " " + merchantData.getMiddleName() + " " + merchantData.getLastName());
		merchantModel.setMerchantPhoneNumber(merchantData.getMobileNumber());
		merchantModel.setCompanyLegalName(merchantData.getLegalName());
		merchantModel.setCompanyMarketingName(merchantData.getMarketingName());
		merchantModel.setEmailId(merchantData.getEmailId());

		Kyc kyc = new Kyc();
		kyc.setAadharNumber(merchantData.getAdharcardNumber());
		kyc.setCompanyOrShopPan(merchantData.getBusinessPanNumber());
		kyc.setGstInNumber(merchantData.getGstNumber());
		kyc.setUserPan(merchantData.getPancardNumber());

		merchantModel.setKyc(kyc);

		Settlement settlement = new Settlement();

		merchantData.getBankDetails().forEach(bank -> {
			boolean flag = true;
			if (flag) {
				settlement.setCompanyBankAccountNumber(bank.getAccountNumber());
				settlement.setBankAccountName(bank.getAccountHolderName());
				settlement.setCompanyBankName(bank.getBankName());
				settlement.setBankBranchName(bank.getBranchName());
				settlement.setBankIfscCode(bank.getIfscCode());
				flag = false;

			}
		});

		merchantModel.setSettlement(settlement);

//		MerchantAddress merchantAddress = new MerchantAddress();
//		merchantAddress.setMerchantAddress(merchantData.getAddress().stream()
//				.filter(address -> address.getAddressType().equals(EnumValue.AddressType.PERMANENTADDRESS))
//				.map(ad -> ad.getAddress()).findFirst().get());
//		merchantAddress.setMerchantState(merchantData.getAddress().stream()
//				.filter(ad -> ad.getAddressType().equals(EnumValue.AddressType.PERMANENTADDRESS.toString()))
//				.map(ad -> ad.getState()).findFirst().get());
//
//		merchantModel.setMerchantAddress(merchantAddress);

		MerchantDocument merchantDocument = merchantDocumentRepository
				.findMerchantDocumentByMerchantId(merchantData.getMerchantIdentificationNo());
		merchantModel.setShopAndPanImage(merchantDocument.getPanCardImagePath());
		merchantModel.setCancellationCheckImages(merchantDocument.getCancelledCheckPath());
		merchantModel.setEkycDocuments(merchantDocument.getAadharCardImagePath());

		merchantOnboardingDto.setMerchants(merchantModel);
		return merchantOnboardingDto;

	}

}
