package org.garrus.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/{username}")
	@PreAuthorize("@userStrategy.verifyUpdate(authentication, #username)")
	public UserDTO getUserByName(@PathVariable("username") String username) {
		return service.getUserByName(username);
	}

	@PutMapping(value = "/{username}")
	@PreAuthorize("@userStrategy.verifyUpdate(authentication, #username)")
	public void updateUser(@PathVariable String username, @RequestBody UserDTO user) {
		service.updateUser(username, user);
	}

}
