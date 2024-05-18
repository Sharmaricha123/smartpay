package com.smartpay.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartpay.constant.dbquery.UserQuery;
import com.smartpay.enums.EnumValue.IsActive;
import com.smartpay.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	 
    @Query(value=UserQuery.USER_BY_EMAIL_OR_MOBNO)
	User findByEmailIdOrMobileNo(@Param("emailId")String emailId, @Param("mobNo")String mobNo);
    
    @Query(value=UserQuery.ADMIN_INFO_BY_ACTIVE_STATUS)
    User findAdminUser(@Param("isActive") String isActive);

}
