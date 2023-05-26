package com.asymmetrix.grc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Entity.UserGroup;
import com.asymmetrix.grc.Repository.UserGroupRepo;

@Service
public class UserGroupServices {
	
	@Autowired
	private UserGroupRepo userGroupRepo;

	
	
	public List<UserGroup> getAllUserGroup() {
		return this.userGroupRepo.findAll();	
	}
	
	public UserGroup createUserGroup(UserGroup userGroup) {
		return this.userGroupRepo.save(userGroup);
	}
	
	
	

}
