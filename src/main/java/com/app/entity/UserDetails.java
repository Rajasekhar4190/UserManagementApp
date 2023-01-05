package com.app.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class UserDetails {
	@Id
	private Integer userId;
	private String UserFName;
	private String userLName;
	private String userEmail;
	private Long userPhNo;
	private LocalDate userDOB;
	private String userGender;
	private String userPWD;
	private String userStatus;
	private Integer coutryId;
	private Integer stateId;
	private Integer cityId;
	

}
