package com.app.service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.binding.LogInFormAcc;
import com.app.binding.UnlockAccForm;
import com.app.binding.UserForm;
import com.app.entity.CitiesMaster;
import com.app.entity.CountryMaster;
import com.app.entity.StateMaster;
import com.app.entity.UserDetails;
import com.app.repo.CitiyRepo;
import com.app.repo.StateRepo;
import com.app.repo.UserDetailsRepo;
import com.app.repo.countryRepo;
import com.app.service.UserDetailsService;
import com.app.util.EmailUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsRepo repo;
	@Autowired
	private StateRepo stateRepo;
	@Autowired
	private countryRepo countryRepo;
	@Autowired
	private CitiyRepo citiyRepo;
	@Autowired
	private EmailUtils utils;

	@Override
	public String checkEmail(String email) {
		// TODO Auto-generated method stub
		UserDetails user = repo.findByUserEmail(email);
		if (user == null) {
			return "Not Existed";
		} else
			return "email is existed";
	}

	@Override
	public Map<Integer, String> getCounties() {
		// TODO Auto-generated method stub
		List<CountryMaster> countries = countryRepo.findAll();
		Map<Integer, String> map = new HashMap<>();
		countries.forEach(country -> {
			map.put(country.getCountryID(), country.getCountryName());
		});

		return map;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		// TODO Auto-generated method stub
		List<StateMaster> states = stateRepo.findByCountryId(countryId);
		Map<Integer, String> map = new HashMap<>();
		states.forEach(state -> {
			map.put(state.getStateId(), state.getStateName());
		});

		return map;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		// TODO Auto-generated method stub
		List<CitiesMaster> cities = citiyRepo.findByStateId(stateId);
		
		Map<Integer, String> map = new HashMap<>();
		
		cities.forEach(city -> {
			
			map.put(city.getCityID(), city.getCityName());
		});
		return map;
	}

	@Override
	public String userRegister(UserForm user) {
		// TODO Auto-generated method stub
		// data is copied from binding object to entity object

		UserDetails details = new UserDetails();

		BeanUtils.copyProperties(user, details);

		// Generate Random Pwd
		details.setUserPWD(genratePwd());

		// set as account status is locked

		details.setUserStatus("LOCKED");

		repo.save(details);
		//send email 
	    String to=user.getUserEmail();
		String subject="Registration Email";
		String body=readBody("REG_EMAIL_BODY.txt", details);
		utils.sendEmail(to, subject, body);
		
		return "user Registered";
	}

	@Override
	public String unlockAccount(UnlockAccForm accForm) {
		// TODO Auto-generated method stub
		String email = accForm.getUserEmail();
		UserDetails details = repo.findByUserEmail(email);
		if (details.getUserPWD().equals(accForm.getTempPWD())) {
			details.setUserPWD(accForm.getNewPWD());
			details.setUserStatus("UNLOCKED");
			repo.save(details);
		}

		return "Account Unlocked";

	}

	@Override
	public String login(LogInFormAcc acc) {
		// TODO Auto-generated method stub
		UserDetails details = repo.findByUserEmailAndUserPWD(acc.getUserEmail(), acc.getUserPWD());
		if (details == null) {
			return "Invalid Credentials";
		}
		if (details.getUserPWD().equals("LOCKED")) {
			return "Account is Locked";
		}
		return "Succes:Account UNLOCKED";
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		UserDetails details = repo.findByUserEmail(email);
		if (details == null) {
			return "No accounts  found";
		}
		String to=details.getUserEmail();
		String subject="Registration Email";
		String body=readBody("REG_EMAIL_BODY.txt", details);
		utils.sendEmail(to, subject, body);
		
		return null;
	}

	private String genratePwd() {
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			int index = random.nextInt(text.length());
			sb.append(text.charAt(index));
		}
		return sb.toString();
	}
	
	private String readBody(String fileName,UserDetails user) {
		StringBuffer sb=new StringBuffer();
		try(java.util.stream.Stream<String> lines=Files.lines(Paths.get(fileName))){
			lines.forEach(line->{
				line.replace("${FNAME}", user.getUserFName());
				line.replace("${LNAME}", user.getUserLName());
				line.replace("${TEMP_PWD}", user.getUserPWD());
				line.replace("${EMAIL}",user.getUserEmail());
				line.replace("${PWD}", user.getUserPWD());
			});
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return sb.toString();
	}

}
