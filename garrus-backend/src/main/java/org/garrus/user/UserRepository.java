package org.garrus.user;


import java.util.Optional;

import org.garrus.auth.User;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * <p>Title: UserDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with UserDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching user objects</p>
 *
 */
public interface UserRepository extends CrudRepository<User,String>{

	Optional<User> findByUsernameOrEmail(String username, String email);
}
