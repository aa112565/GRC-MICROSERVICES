package com.asymmetrix.grc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.Entity.User;
import com.asymmetrix.grc.Service.UserServices;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/getuser")
	public List<User> getAllUser() {
		return this.userServices.getAllUser();
	}

	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		return this.userServices.createUser(user);
	}

}
