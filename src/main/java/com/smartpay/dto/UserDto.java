package com.smartpay.dto;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNo;
	private String dateOfBirth;
	private String emailId;
//	private String parentUserName;

}
