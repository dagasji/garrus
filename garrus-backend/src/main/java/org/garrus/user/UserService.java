package org.garrus.user;

import java.util.Optional;

public interface UserService {

	Optional<UserDTO> findByUsername(String username);

	UserDTO getUserByName(String name);

	void updateUser(String username, UserDTO user);

	void createUser(UserDTO user);

	/**
	 * Creates a random password for user and sends an email.
	 * @param username Username to reset password.
	 */
	void resetPassword(String username);
}
