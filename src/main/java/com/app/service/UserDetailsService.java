package com.app.service;

import java.util.Map;

import com.app.binding.LogInFormAcc;
import com.app.binding.UnlockAccForm;
import com.app.binding.UserForm;

public interface UserDetailsService {
	public String checkEmail(String email);
	public Map<Integer,String> getCounties();
	public Map<Integer,String> getStates(Integer countryId);
	public Map<Integer,String>  getCities(Integer stateId);
	public String userRegister(UserForm user);
	public String unlockAccount(UnlockAccForm accForm);
	public String login(LogInFormAcc acc);
	public String forgotPwd(String email);

}
