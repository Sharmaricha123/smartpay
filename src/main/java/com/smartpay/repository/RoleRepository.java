package com.smartpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartpay.model.roleandprivilege.Role;

import feign.Param;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Query(value="SELECT r FROM Role r WHERE r.roleName=:roleName")
	Role findByRoleName(@Param(value="roleName")String roleName);
 
}
