package org.garrus.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;

	public Optional<UserDTO> findByUsername(String username) {
		Optional<User> user = repo.findById(username);
		return user.map(res->UserMapper.INSTANCE.entityToDTO(res));
	}
	
}
