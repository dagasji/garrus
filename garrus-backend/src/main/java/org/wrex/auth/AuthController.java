package org.wrex.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	private UsersRepository repo;
	
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public UsersDTO checkLogin(@RequestBody UsersDTO req) {
		Optional<User> user = repo.findById(req.getUsername());
		if (user.isPresent() && user.get().getPassword().equals(req.getPassword())) {
			return UserMapper.INSTANCE.entityToDTO(user.get());
		}else
			return null;
	}
	
	@RequestMapping(value="/auth/permissions",method=RequestMethod.GET)
	public List<PermissionDTO> getPermissions() {
		return PermissionEnum.getAll();	
	}
	
}
