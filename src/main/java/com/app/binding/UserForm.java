package com.app.binding;

import java.time.LocalDate;

import lombok.Data;
@Data
public class UserForm {
	private String UserFName;
	private String userLName;
	private String userEmail;
	private String userPWD;
	private Long userPhNo;
	private LocalDate userDOB;
	private String userGender;
	private Integer coutryId;
	private Integer stateId;
	private Integer cityId;

}
