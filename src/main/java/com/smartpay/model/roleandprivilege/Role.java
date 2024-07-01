package com.smartpay.model.roleandprivilege;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.smartpay.model.BaseEntity;
import com.smartpay.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Role")
@Entity
public class Role extends BaseEntity {
	
	@Id
	@Column(name="Role_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name="Role_Name",length=20)
	private String roleName;
	
	@ManyToMany
	@JoinTable(name="role_privileges",
	           joinColumns = {@JoinColumn(name="role_id")},
	           inverseJoinColumns= {@JoinColumn(name="privilege_id")}
	)
	private Set<Privilege> privileges=new HashSet<>();
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> user=new HashSet<>();

}
