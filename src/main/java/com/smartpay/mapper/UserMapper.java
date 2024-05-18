//package com.smartpay.mapper;
//
//import com.smartpay.dto.UserDto;
//import com.smartpay.model.User;
//
//public class UserMapper {
//	
//	public static UserDto mapToUserDto(User user)
//	{
//		return new UserDto(
//				user.getFirstName(),
//				user.getMiddleName(),
//				user.getLastName(),
//				user.getMobileNo(),
//				user.getDateOfBirth(),
//				user.getEmailId()
//				);
//	}
//	
//	public static User mapToUser(UserDto userDto)
//	{
//		User user=new User();
//				user.setFirstName(userDto.getFirstName());
//				user.setMiddleName(userDto.getMiddleName());
//				user.setLastName(userDto.getLastName());
//				user.setMobileNo(userDto.getMobileNo());
//				user.setDateOfBirth(userDto.getDateOfBirth());
//				user.setEmailId(userDto.getEmailId());
//				
//				
//		return user;
//				
//	}
//
//}
