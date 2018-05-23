package org.garrus.service.impl;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.garrus.api.domain.PostDTO;
import org.garrus.dao.PostRepository;
import org.garrus.mappers.PostMapper;
import org.garrus.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postDao;
	

	/**
	 * Creates a new Warning
	 * @param post
	 */
	public void save(PostDTO post) {
		postDao.save(PostMapper.INSTANCE.dtoToPost(post));
	}
	@Override
	public List<PostDTO> getAllPost() {
		return PostMapper.INSTANCE.listToPostDTO(IterableUtils.toList(postDao.findAll()));
	}
}
