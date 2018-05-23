package org.garrus.dao;


import org.garrus.entities.User;
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
public interface UserRepository extends CrudRepository<User,Integer>{

	User findOneByEmail(String email);

	User findOneByIdUserFB(String idFb);
}
