package com.smartpay.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import com.smartpay.enums.EnumValue.IsActive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Aeps_Wallet")
public class AepsWallet extends BaseEntity {

	@Id
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@Column(name = "Aeps_Wallet_Id", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String aepsWalletId;

	@Column(name = "Charges")
	private BigDecimal charges;

	@Column(name = "Commission_Credit")
	private BigDecimal commissionCredit;

	@Column(name = "Credit_Amount")
	private BigDecimal creditAmount;

	@Column(name = "Credit_Type", length = 200)
	private String creditType;

	@Column(name = "Current_Balance")
	private BigDecimal currentBalance;

	@Column(name = "Debit_Amount")
	private BigDecimal debitAmount;

	@Column(name = "Debit_Type", length = 200)
	private String debitType;

	@Column(name = "IsActive", length = 20)
	private String isActive;

	@Column(name = "TDS")
	private BigDecimal tds;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "merchantIdentificationNo")
	private Merchant merchant;

}
