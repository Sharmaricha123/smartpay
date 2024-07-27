//package com.smartpay.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.smartpay.enums.EnumValue;
//import com.smartpay.enums.ErrorMsg;
//import com.smartpay.model.User;
//import com.smartpay.repository.UserRepository;
//
//@Service
//public class LoadUserDetails implements UserDetailsService {
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user=userRepository.findUserByUsername(username,EnumValue.IsActive.ACTIVE.toString());
//		if(user==null)
//		{
//			throw new UsernameNotFoundException(ErrorMsg.Error008.getValue()+username);
//			
//		}
//		return new UserSecurity(user);
//	}
//
//}
