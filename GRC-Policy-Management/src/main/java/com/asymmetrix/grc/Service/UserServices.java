package com.asymmetrix.grc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Entity.User;
import com.asymmetrix.grc.Repository.UserRepo;

@Service
public class UserServices {

	@Autowired
	private UserRepo userRepo;
	
	
	public List<User> getAllUser() {
		return this.userRepo.findAll();	
	}
	
	public User createUser(User user) {
		return this.userRepo.save(user);
	}
	
	
	
	
	
	
}
