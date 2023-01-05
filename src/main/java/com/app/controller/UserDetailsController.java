package com.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.binding.LogInFormAcc;
import com.app.binding.UnlockAccForm;
import com.app.binding.UserForm;
import com.app.entity.UserDetails;
import com.app.service.UserDetailsService;

@RestController
public class UserDetailsController {
	@Autowired
	private UserDetailsService service;
     @GetMapping("/email/{email}")
	 public String emailCheck(@PathVariable String email) {
		 return service.checkEmail(email);
		 
	 }
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LogInFormAcc acc) {
		String status = service.login(acc);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	@GetMapping("/countries")
	public Map<Integer, String> loadCountries() {
		return service.getCounties();

	}
	@GetMapping("/states/{countryId}")
	public Map<Integer,String> loadStates(@PathVariable Integer countryId){
		return service.getStates(countryId);
		
	}
	@GetMapping("/cities")
	public Map<Integer,String> loadCities(@PathVariable Integer stateId){
		return service.getCities(stateId);
	}
	@PostMapping("/register")
	public ResponseEntity<String> userRegier(@RequestBody UserForm form ){
		String status=service.userRegister(form);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	@PostMapping("/unlock")
	public ResponseEntity<String> unlockAccount(@RequestBody UnlockAccForm form){
		String status=service.unlockAccount(form);
		return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}
	@PostMapping("/forgor/{email}")
	public ResponseEntity<String> forgotPWD(@RequestBody String email){
		String status=service.forgotPwd(email);
		return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}
	
}
