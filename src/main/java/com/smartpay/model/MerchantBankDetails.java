package com.smartpay.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Bank_Details")
public class MerchantBankDetails extends BaseEntity {

	@Id
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@Column(name = "Bank_Details_ID", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String bankDetailsID;

	@Column(name = "Account_Holder_Name", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String accountHolderName;

	@Size( message = "Account number should be 12 characters")
	@Column(name = "Account_Number", length = 20)
	private String accountNumber;

	@Column(name = "AccountType", length = 15)
	private String accountType;

	@Size(min = 1, max = 150, message = "min 1 and max 200 character are allowed")
	@Column(name = "Bank_Name", length = 200)
	private String bankName;

	@Size(min = 1, max = 150, message = "min 1 and max 200 character are allowed")
	@Column(name = "Branch_Name", length = 200)
	private String branchName;

	@Column(name = "IFSC_Code", length = 11)
	@Size(min = 11, max = 11, message = "IFSC Code should be 11 Character")
	private String ifscCode;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "merchantIdentificationNo")
	private Merchant merchant;

}
