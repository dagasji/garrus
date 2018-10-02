package org.garrus.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/user")
@CrossOrigin(origins = "*")
public class UserControllerPublic {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping
	public void register(@RequestBody UserDTO user) {
		service.createUser(user);
	}
	
	@GetMapping("/{username}/resetPassword")
	public void resetPassword(@PathVariable("username") String username) {
		service.resetPassword(username);
	}
	
	
}
