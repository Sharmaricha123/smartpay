package com.smartpay.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.smartpay.constant.dbquery.MerchantQuery;
import com.smartpay.model.Merchant;


@Transactional
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String>{
	
	
	@Query(value=MerchantQuery.MERCHANT_BY_USER_IDENTIFICATION_NUMBER)
    Merchant findMerchantByUserIdentificationNumber(@Param("userIdentificationNumber") String userIdentificationNumber);


}
