package com.smartpay.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartpay.constant.dbquery.MerchantQuery;
import com.smartpay.model.Merchant;

@Transactional
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String> {

	@Query(value = MerchantQuery.MERCHANT_BY_USER_IDENTIFICATION_NUMBER)
	Merchant findMerchantByMerchantIdentificationNumber(@Param("identificationNumber") String identificationNumber,
			@Param("activeStatus") String activeStatus);

	@Modifying
	@Query(value = MerchantQuery.UPDATE_MERCHANT_UPLOAD_STATUS)
	void updateUploadStatus(@Param("merchantId") String merchantId, @Param("uploadStatus") String uploadStatus,
			@Param("activeStatus") String activeStatus);
	
	@Query(value=MerchantQuery.FIND_MERCHANT_BY_USERNAME_AND_ONBOARD_STATUS)
	Merchant findMerchantByUsernameAndOnboardingStatus(@Param("username") String username,@Param("onboardingStatus")String onboardingStatus);
}
