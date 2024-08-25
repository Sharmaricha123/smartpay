package com.smartpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartpay.constant.dbquery.MerchantQuery;
import com.smartpay.model.MerchantDocument;


@Repository
public interface MerchantDocumentRepository extends JpaRepository<MerchantDocument, String>{
	
	@Query(value=MerchantQuery.MERCHANT_DOCUMENT_BY_MERCHANT_IDENTIFICATION_NUMBER)
    MerchantDocument findMerchantDocumentByMerchantId(@Param("identificationNumber") String identificationNumber);

	
	
	
	

}
