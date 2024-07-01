package com.smartpay.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartpay.enums.EnumValue.BankingServiceStatus;
import com.smartpay.enums.EnumValue.IsActive;
import com.smartpay.model.roleandprivilege.Role;

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
@Table(name="user")
public class User extends BaseEntity {
	@Id
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@Size(min = 1, max = 200, message = "min 1 and max 20 characters are allowed")
	@Column(name = "User_Identification_No", length = 200)
	private String userIdentifactionNo;

	@Column(name = "Customer_Id", length = 10)
	private long customerId;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "en-in", timezone = "IST")
	@Column(name = "DOB")
	private Date dateOfBirth;

//	@Enumerated(EnumType.STRING)
	@Column(name = "Is_Active", length = 10)
	private String isActive;

//	@Enumerated(EnumType.STRING)
	@Column(name = "Banking_Service_Status", length = 5)
	private String bankingServiceStatus;

	@Column(name = "Email_Id")
	private String emailId;

	@Column(name = "First_Name", length = 10)
	private String firstName;

	@Column(name = "Middle_Name", length = 10)
	private String middleName;

	@Column(name = "Last_Name", length = 10)
	private String lastName;

	@Column(name = "Mobile_No", length = 10)
	private String mobileNo;

	@Column(name = "Parent_User_Name", length = 20)
	private String parentUserName;

	@JsonIgnore
	@Column(name = "Password", length = 255)
	private String password;
	
	@Column(name="User_Role",length=20)
	private String role;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

	@Column(name = "Username", length = 20)
	private String username;

	@JsonIgnore
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private MainWallet mainWallet;

}
