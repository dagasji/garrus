package org.garrus.user;

import java.util.Optional;

import org.garrus.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/user")
@CrossOrigin(origins = "*")
public class UserControllerPublic {
	
	@Autowired
	private UserRepository repo;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public void register(@RequestBody UserDTO user) {
		Optional<User> present = repo.findById(user.getName());
		if (!present.isPresent()) 
			repo.save(UserMapper.INSTANCE.dtoToEntity(user));
	}
	
}
