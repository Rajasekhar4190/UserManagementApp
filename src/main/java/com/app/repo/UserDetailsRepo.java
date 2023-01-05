package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.CountryMaster;
import com.app.entity.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer>{
	//@Query("select distnict(useEmail) from UserDetails ")
	
	public UserDetails findByUserEmail(String userEmail);
	
	public UserDetails findByUserEmailAndUserPWD(String userEmail,String userPwd);
	
	
	
	
	 
	
	
	
}
