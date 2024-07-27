package com.smartpay.service;

import com.smartpay.dto.MerchantDto;
import com.smartpay.model.Merchant;

public interface MerchantService {
	public Merchant updateUserProfile(String username,MerchantDto merchantDto);

}
