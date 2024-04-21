package com.smartpay.service;

import java.util.Set;

import com.smartpay.model.roleandprivilege.Privilege;
import com.smartpay.model.roleandprivilege.Role;

public interface RoleAndPrivilegeService {
	
	
	public Privilege createWritePrivilege();

	public Privilege createReadPrivilege();

	public Privilege createUpdatePrivilege();

	public Privilege createDeletePrivilege();
	
	public Role createAdminRole(Set<Privilege> adminPrivilege);
	public Role createMerchantRole(Set<Privilege> merchantPrivilege);
	public Role createDistributorRole(Set<Privilege> distributorPrivilege);
	
	

}
