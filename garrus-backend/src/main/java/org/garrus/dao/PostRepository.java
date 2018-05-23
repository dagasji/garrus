package org.garrus.dao;


import org.garrus.entities.Post;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * <p>Title: PostDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with PostDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching post objects</p>
 *
 */
public interface PostRepository extends CrudRepository<Post,Integer>{


}
