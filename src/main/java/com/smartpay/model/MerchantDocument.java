package com.smartpay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Merchant_Document")
public class MerchantDocument extends BaseEntity{
	
	@Id
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@Column(name = "Document_No", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String MerchantDocumentId;
	
	@Column(name="Pancard_Image_Path",length=250)
	private String panCardImagePath;
	
	@Column(name="AadharCard_Image_Path",length=250)
	private String aadharCardImagePath;
	
	@Column(name="Cancelled_Check_Path",length=250)
	private String cancelledCheckPath;
	
	@Column(name="Sign_Upload_Path",length=250)
	private String signUploadPath;
	
	@Column(name="Is_Approved",length=15)
	private String isApproved;
	
	@Column(name="Merchant_Identification_No",length=200)
	private String merchantIdentificationNo;

}
