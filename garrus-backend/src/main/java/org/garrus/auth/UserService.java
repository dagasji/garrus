package org.garrus.auth;

import java.util.Optional;

public interface UserService {

	Optional<UserDTO> findByUsername(String username);
}
