package com.smartpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartpay.model.roleandprivilege.Privilege;

import feign.Param;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>{

	@Query(value="SELECT p from Privilege p WHERE p.privilegeName=:privilegeName")
	Privilege findByPrivilegeName(@Param(value="privilegName")String privilegeName);
	
}
