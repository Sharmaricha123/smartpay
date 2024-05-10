package com.smartpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smartpay.model.User;

import feign.Param;

public interface UserRepository extends JpaRepository<User, String>{
	
	 Optional<User> findByEmailId(String email);

}
