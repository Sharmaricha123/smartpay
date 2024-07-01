package com.smartpay.model.roleandprivilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.smartpay.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Privilege")
@Entity
public class Privilege extends BaseEntity{
	
	@Id
	@Column(name="Privilege_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int privilegeId;
	
	@Column(name="Privilege_Name",length=20)
	private String privilegeName;
	
	@ManyToMany(mappedBy = "privileges")
	private Set<Role>  roles=new HashSet<>();
	


}
