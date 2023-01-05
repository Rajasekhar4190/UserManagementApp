package com.app.binding;

import lombok.Data;

@Data
public class UnlockAccForm {
	private String userEmail;
	private String tempPWD;
	private String newPWD;
	private String confPwd;
	


}
