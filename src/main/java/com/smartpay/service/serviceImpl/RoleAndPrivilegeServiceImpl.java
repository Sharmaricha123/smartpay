package com.smartpay.service.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartpay.enums.EnumValue;
import com.smartpay.model.roleandprivilege.Privilege;
import com.smartpay.model.roleandprivilege.Role;
import com.smartpay.repository.PrivilegeRepository;
import com.smartpay.repository.RoleRepository;
import com.smartpay.service.RoleAndPrivilegeService;

@Service
public class RoleAndPrivilegeServiceImpl implements RoleAndPrivilegeService{

	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public Privilege createWritePrivilege() {
		Privilege privilege=privilegeRepository.findByPrivilegeName(EnumValue.UserPrivilege.CREATE.getPrivilegeName());
		if(privilege==null)
		{
			privilege=new Privilege();
			privilege.setPrivilegeName(EnumValue.UserPrivilege.CREATE.getPrivilegeName());
			privilegeRepository.save(privilege);
		}
	
		return privilege;
	}

	@Override
	public Privilege createReadPrivilege() {
	Privilege privilege=privilegeRepository.findByPrivilegeName(EnumValue.UserPrivilege.READ.getPrivilegeName());
	if(privilege==null)
	{
		privilege=new Privilege();
		privilege.setPrivilegeName(EnumValue.UserPrivilege.READ.getPrivilegeName());
		privilegeRepository.save(privilege);
	}
	return privilege;
		
	}

	@Override
	public Privilege createUpdatePrivilege() {
		
		Privilege privilege=privilegeRepository.findByPrivilegeName(EnumValue.UserPrivilege.UPDATE.getPrivilegeName());
		if(privilege==null)
		{
			privilege=new Privilege();
			privilege.setPrivilegeName(EnumValue.UserPrivilege.UPDATE.getPrivilegeName());
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

	@Override
	public Privilege createDeletePrivilege() {
		
		Privilege privilege=privilegeRepository.findByPrivilegeName(EnumValue.UserPrivilege.DELETE.getPrivilegeName());
		if(privilege==null)
		{
			privilege=new Privilege();
			privilege.setPrivilegeName(EnumValue.UserPrivilege.DELETE.getPrivilegeName());
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

	@Override
	public Role createAdminRole(Set<Privilege> adminPrivilege) {
		Role role=roleRepository.findByRoleName(EnumValue.UserRole.ADMIN.getRoleName());
		if(role==null)
		{
			role=new Role();
			role.setRoleName(EnumValue.UserRole.ADMIN.getRoleName());
			role.setPrivileges(adminPrivilege);
			roleRepository.save(role);
		}
		return role;
	}

	@Override
	public Role createMerchantRole(Set<Privilege> merchantPrivilege) {
		Role role=roleRepository.findByRoleName(EnumValue.UserRole.MERCHANT.getRoleName());
		if(role==null)
		{
			role=new Role();
			role.setRoleName(EnumValue.UserRole.MERCHANT.getRoleName());
			role.setPrivileges(merchantPrivilege);
			roleRepository.save(role);
		}
		return role;
		
		
	}

	@Override
	public Role createDistributorRole(Set<Privilege> distributorPrivilege) {
		
		Role role=roleRepository.findByRoleName(EnumValue.UserRole.DISTRIBUTOR.getRoleName());
		if(role==null)
		{
			role=new Role();
			role.setRoleName(EnumValue.UserRole.DISTRIBUTOR.getRoleName());
			role.setPrivileges(distributorPrivilege);
			roleRepository.save(role);
		}
		return role;
	}

	

}
