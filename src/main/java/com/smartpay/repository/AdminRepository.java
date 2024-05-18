package com.smartpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartpay.constant.dbquery.UserQuery;
import com.smartpay.model.User;

public interface AdminRepository extends JpaRepository<User, String>{
	
	 @Query(value=UserQuery.USER_BY_EMAIL_OR_MOBNO)
		User findByEmailIdOrMobileNo(@Param("emailId")String emailId, @Param("mobNo")String mobNo);
	    

}
