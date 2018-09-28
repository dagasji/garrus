package org.garrus.user;

import java.util.Optional;

import org.garrus.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Optional<UserDTO> findByUsername(String username) {
		Optional<User> user = repo.findById(username);
		return user.map(res->UserMapper.INSTANCE.entityToDTO(res));
	}
	
	@Override
	public UserDTO getUserByName(String name) {
		UserDTO ret = repo.findById(name).map(res->UserMapper.INSTANCE.entityToDTO(res)).get();
		ret.setPassword("");
 		return ret;
	}
	
	@Override
	public void updateUser(String username, UserDTO user) {
		Optional<User> present = repo.findById(username);
		if (present.isPresent() && present.get().getUsername().equals(username)) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			repo.save(UserMapper.INSTANCE.dtoToEntity(user));
		}	
	}
	
	@Override
	public void createUser(UserDTO user) {
		Optional<User> present = repo.findByUsernameOrEmail(user.getUsername(), user.getEmail());
		if (!present.isPresent()) {
			user.setRole("ROLE_USER");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			repo.save(UserMapper.INSTANCE.dtoToEntity(user));
		}else {
			throw new RuntimeException("Ya existe usuario con mismo username o email");
		}
	}
}
