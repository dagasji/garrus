package org.garrus.driver;


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
public interface DriverRepository extends CrudRepository<Driver,String>{

}
