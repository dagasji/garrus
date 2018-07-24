package org.wrex.auth;

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
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UsersRepository repo;
	
	@RequestMapping(value="/user/{username}",method=RequestMethod.GET)
	public UsersDTO getUserByName(@PathVariable("username") String name) {
		Optional<User> user = repo.findById(name);
		if (user.isPresent()) {
			return UserMapper.INSTANCE.entityToDTO(user.get());
		}else
			return null;
	}
	
	@RequestMapping(value="/user/getAll",method=RequestMethod.GET)
	public List<UsersDTO> getAll() {
			return UserMapper.INSTANCE.listToDTOList(IterableUtils.toList(repo.findAll()));
	}
	
	@RequestMapping(value="/user}",method=RequestMethod.POST)
	public void saveUser(@RequestBody UsersDTO user) {
		Optional<User> present = repo.findById(user.getName());
		if (!present.isPresent()) 
			repo.save(UserMapper.INSTANCE.dtoToEntity(user));
	}
	
	@RequestMapping(value="/user/{username}}",method=RequestMethod.PUT)
	public void saveUser(@PathVariable String username, @RequestBody UsersDTO user) {
		Optional<User> present = repo.findById(username);
		if (present.isPresent()) 
			repo.save(UserMapper.INSTANCE.dtoToEntity(user));
	}
	
	
}
