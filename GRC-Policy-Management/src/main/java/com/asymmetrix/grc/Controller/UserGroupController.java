package com.asymmetrix.grc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asymmetrix.grc.Service.UserGroupServices;
import com.asymmetrix.grc.Entity.UserGroup;


@RestController
@RequestMapping("/UserGroup")
public class UserGroupController {
	
	@Autowired
	private UserGroupServices UserGroupServices;
	
//	@GetMapping("/getallusergroups")
//	public ResponseEntity<GRCResponse<?>> getAllUserGroups() {
//		UserGroupDTO usergroups = new UserGroupDTO();
//		List<UserGroup> ug = getAllUserGroups();
//		usergroups.setUserGroup(ug);
//		return GRCResponseEntity.success(usergroups);
//	}
	
	@GetMapping("/getApplicableDepartmentDD")
	public List<UserGroup> getAllUserGroup() {
		return this.UserGroupServices.getAllUserGroup();
	}

	@PostMapping("/createApplicableDepartmentDD")
	public UserGroup createUserGroup(@RequestBody UserGroup ug) {
		return this.UserGroupServices.createUserGroup(ug);
	}
	

}
