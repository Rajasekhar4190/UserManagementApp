package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.app.entity.UserDetails;
import com.app.repo.UserDetailsRepo;

public class AppRunner implements ApplicationRunner {
	
	@Autowired
	private UserDetailsRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		UserDetails details=new UserDetails();
		//details.setUserDOB();
		details.setUserEmail("rajasekhar.ky@gmail.com");
		details.setUserFName("Rajasekhar Reddy");
		details.setUserLName("Kondreddy");
        details.setUserGender("Male");
        details.setUserPhNo((long)7097502);
        repo.save(details);
        
        UserDetails details1=new UserDetails();
		details1.setUserEmail("rajasekhark419@gmail.com");
		details1.setUserFName("Rajasekhar");
		details1.setUserLName("Reddy");
        details1.setUserGender("Male");
        details1.setUserPhNo((long)7097501);
        repo.save(details1);
        
        UserDetails details2=new UserDetails();
		details2.setUserEmail("rajasekharreddy.ky@gmail.com");
		details2.setUserFName("Sekhar");
		details2.setUserLName("Reddy");
        details2.setUserGender("Male");
        details2.setUserPhNo((long)7097500);
        repo.save(details2);
        
        UserDetails details3=new UserDetails();
		details3.setUserEmail("Sam@gmail.com");
		details3.setUserFName("Sam");
		details3.setUserLName("Akkenini");
        details3.setUserGender("FeMale");
        details3.setUserPhNo((long)7097510);
        repo.save(details3);
        
        
        
        
	}

}
