package com.smartpay.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartpay.enums.EnumValue.IsActive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Main_Wallet")
public class MainWallet extends BaseEntity {
	
	@Id
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@Size(min = 1, max = 200, message = "min 1 and max 20 characters are allowed")
	@Column(name="Main_Waller_Id",length=200)
	private String mainWalletId;
	
	@Column(name="Charges")
	private BigDecimal charges;
	
	@Column(name="Commission_Credit")
	private BigDecimal commissionCredit;
	
	@Column(name="Credit_Amount")
	private BigDecimal creditAmount;
	
	@Column(name="Credit_Type")
	private String creditType;
	
	@Column(name="Current_Balance")
	private BigDecimal currentBalance;
	
	@Column(name="Debit_Amount")
	private BigDecimal debitAmount;
	
	@Column(name="Debit_Type")
	private String debitType;
	
	@Column(name="Is_Active")
	private IsActive isActive;
	
	@Column(name="TDS")
	private BigDecimal tds;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "en-in", timezone = "IST")
	@Column(name="Transaction_DateTime")
	private Timestamp transactionDateTime;
	
	@Column(name="User_Name",length=10)
	private String userName;
	
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userIdentifactionNo")
	private User user;
	

}
