package com.smartpay.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smartpay.enums.EnumValue;
import com.smartpay.model.User;
import com.smartpay.model.roleandprivilege.Role;



public class UserSecurity implements UserDetails {
	
	private final User user;
	
	public UserSecurity(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles=user.getRoles();
		List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
		roles.stream().forEach(role->{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});
		
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		if(user.getIsActive().equalsIgnoreCase(EnumValue.IsActive.ACTIVE.toString()))
		{
			return true;
		}
		return false;
	}

	

}
