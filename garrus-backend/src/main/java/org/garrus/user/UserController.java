package org.garrus.user;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public UserDTO getUserByName(@PathVariable("username") String name) {
		return repo.findById(name).map(res->UserMapper.INSTANCE.entityToDTO(res)).get();
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<UserDTO> getAll() {
			return UserMapper.INSTANCE.listToDTOList(IterableUtils.toList(repo.findAll()));
	}
	
	@RequestMapping(value="/user}",method=RequestMethod.POST)
	public void saveUser(@RequestBody UserDTO user) {
		Optional<User> present = repo.findById(user.getName());
		if (!present.isPresent()) 
			repo.save(UserMapper.INSTANCE.dtoToEntity(user));
	}
	
	@RequestMapping(value="/user/{username}}",method=RequestMethod.PUT)
	public void saveUser(@PathVariable String username, @RequestBody UserDTO user) {
		Optional<User> present = repo.findById(username);
		if (present.isPresent()) 
			repo.save(UserMapper.INSTANCE.dtoToEntity(user));
	}
	
	
}
