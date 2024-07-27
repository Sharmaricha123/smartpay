package com.smartpay.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartpay.enums.EnumValue.YESNO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Merchant")
public class Merchant extends BaseEntity {

	@Id
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@Column(name = "Merchant_Identification_No", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String merchantIdentificationNo;

	@Column(name = "User_Name", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String userName;

	@Column(name = "First_Name", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String firstName;

	@Column(name = "Midddle_Name", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String middleName;

	@Column(name = "Last_Name", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String lastName;

	@Column(name = "Email_Id", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String emailId;

	@Column(name = "Mobile_Number", length = 10)
	@Size(max = 10, message = "mobile number should be of 10 digits")
	private String mobileNumber;

	@Column(name = "Guardian", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String guardian;

	@Column(name = "Gender", length = 10)
	@Size(min = 1, max = 10, message = "min 1 and max 10 character are allowed")
	private String gender;

	@Column(name = "Marital_Status", length = 20)
	@Size(min = 1, max = 20, message = "min 1 and max 20 character are allowed")
	private String maritalStatus;
	
	@Column(name = "Business_Type", length = 20)
	@Size(min = 1, max = 20, message = "min 1 and max 20 character are allowed")
	private String businessType;
	

	@OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Address> address;

	@JsonIgnore
	@OneToOne(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AepsWallet aepsWallet;
	
	@JsonIgnore
    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MerchantBankDetails> bankDetails;
	

	@Column(name = "	Aadhar_Card", length = 12)
	@Size(max = 12, message = "aadhar card number should of length 12")
	private String adharcardNumber;

	@Column(name = "Business_PanNumber", length = 15)
	@Size(max = 15, message = "aadhar card number should of length 15")
	private String businessPanNumber;

	@Column(name = "Gst_Number", length = 15)
	@Size(max = 15, message = "aadhar card number should of length 15")
	private String gstNumber;

	@Column(name = "Pancard_Number", length = 12)
	@Size(max = 12, message = "aadhar card number should of length 12")
	private String pancardNumber;

	@Column(name = "Tan_Number", length = 12)
	@Size(max = 12, message = "aadhar card number should of length 12")
	private String tanNumber;

	@Column(name = "Legal_Name", length = 50)
	@Size(min = 10, max = 50, message = "min 10 and max 50 character are allowed")
	private String legalName;

	@Column(name = "Marketing_Name", length = 50)
	@Size(min = 10, max = 50, message = "min 10 and max 50 character are allowed")
	private String marketingName;

	@Column(name = "Is_Active", length = 10)
	private String isActive;

	@Column(name = "Ekyc_Status", length = 10)
	private String ekycStatus;

	@Column(name = "Aeps_Status", length = 10)
	private String aepsStatus;

	@Column(name = "BankOnboard_Status", length = 10)
	private String bankOnboardStatus;

	@Column(name = "Upload_Status", length = 10)
	private String uploadStatus;

	@Column(name="User_Identification_Number")
	private String userIdentificationNumber;

}
