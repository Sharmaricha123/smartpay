//package com.smartpay.config;
//
//import java.util.Arrays;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import com.smartpay.model.roleandprivilege.Privilege;
//import com.smartpay.service.RoleAndPrivilegeService;
//
//import io.vavr.collection.Array;
//
//@Component
//public class RoleAndPrivilegeConfig implements ApplicationListener<ContextRefreshedEvent>{
//
//	boolean flag=false;
//	
//	@Autowired
//	private RoleAndPrivilegeService roleAndPrivilegeService;
//	
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		if(flag) {
//			return;
//		}
//		
//	Privilege readPrivilege=roleAndPrivilegeService.createReadPrivilege();
//	Privilege writePrivilege=roleAndPrivilegeService.createWritePrivilege();
//	Privilege updatePrivilege=roleAndPrivilegeService.createUpdatePrivilege();
//	Privilege deletePrivilege=roleAndPrivilegeService.createDeletePrivilege();
//		
//	Set<Privilege> adminPrivilege=Arrays.asList(writePrivilege,readPrivilege,updatePrivilege,deletePrivilege).stream().collect(Collectors.toSet());
//	Set<Privilege> distributorPrivilege=Arrays.asList(writePrivilege,readPrivilege).stream().collect(Collectors.toSet());
//	Set<Privilege> merchantPrivilege=Arrays.asList(writePrivilege,readPrivilege,updatePrivilege).stream().collect(Collectors.toSet());	
//	
//	roleAndPrivilegeService.createAdminRole(adminPrivilege);
//	roleAndPrivilegeService.createDistributorRole(distributorPrivilege);
//	roleAndPrivilegeService.createMerchantRole(merchantPrivilege);
//	
//	flag=true;
//	}
//
//}
