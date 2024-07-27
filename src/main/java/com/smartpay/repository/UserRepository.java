package com.smartpay.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartpay.constant.dbquery.UserQuery;
import com.smartpay.enums.EnumValue.IsActive;
import com.smartpay.model.User;
import com.smartpay.to.UserDetailsTo;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	 
    @Query(value=UserQuery.USER_BY_EMAIL_OR_MOBNO)
	UserDetailsTo findByEmailIdOrMobileNo(@Param("emailId")String emailId, @Param("mobNo")String mobNo);
    
    @Query(value=UserQuery.ADMIN_INFO_BY_ACTIVE_STATUS)
    UserDetailsTo findAdminUser(@Param("isActive") String isActive);
    
    @Query(value=UserQuery.USER_BY_USERNAME)
    User findUserByUsername(@Param("username") String username,@Param("isActive") String isActive);

}
