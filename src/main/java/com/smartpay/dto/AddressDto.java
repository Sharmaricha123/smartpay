package com.smartpay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	private String address;

	private String addressType;

	private String country;

	private String district;

	private String pincode;

	private String state;

	private String villageCity;

}
