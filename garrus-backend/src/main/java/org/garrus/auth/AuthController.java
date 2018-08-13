package org.garrus.auth;

import org.garrus.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/user")
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	UserAuthenticationService authentication;
	
	@PostMapping(value="/login")
	public UserDTO checkLogin(@RequestBody UserDTO req) {
		  req.setToken(authentication
			      .login(req.getUsername(), req.getPassword())
			      .orElseThrow(() -> new RuntimeException("invalid login and/or password")));
		  return req;
	}
	
}
