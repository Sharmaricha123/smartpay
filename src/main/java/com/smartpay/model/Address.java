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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Address")
public class Address extends BaseEntity {

	@Id
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@Column(name = "Address_ID", length = 200)
	@Size(min = 1, max = 200, message = "min 1 and max 200 character are allowed")
	private String addressID;

	@Size(min = 1, max = 200, message = "Maximum 200 character are allowed")
	@Column(name = "Address", length = 200)
	private String address;

	@Size(min = 1, max = 200, message = "Maximum 200 character are allowed")
	@Column(name = "Address_Type", length = 200)
	private String addressType;

	@Size(min = 1, max = 200, message = "Maximum 200 character are allowed")
	@Column(name = "Country", length = 200)
	private String country;

	@Size(min = 1, max = 200, message = "Maximum 200 character are allowed")
	@Column(name = "District", length = 200)
	private String district;

	@Size(min = 6, max = 6, message = "Pincode Should be 6 Character")
	@Column(name = "Pincode", length = 6)
	private String pincode;

	@Size(min = 1, max = 200, message = "Maximum 200 character are allowed")
	@Column(name = "State", length = 200)
	private String state;

	@Size(min = 1, max = 200, message = "Maximum 200 character are allowed")
	@Column(name = "Village_Or_City", length = 200)
	private String villageCity;


	
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "merchantIdentificationNo")
	private Merchant merchant;

}
