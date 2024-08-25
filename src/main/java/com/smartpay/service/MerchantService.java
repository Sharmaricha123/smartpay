package com.smartpay.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartpay.dto.MerchantDto;
import com.smartpay.model.Merchant;
import com.smartpay.model.MerchantDocument;

@Service
public interface MerchantService {
	public Merchant updateUserProfile(String username,MerchantDto merchantDto);
	
	public MerchantDocument uploadMerchnatDocuments(String identificationNumber,MultipartFile[] files);

}
