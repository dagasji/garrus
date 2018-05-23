package org.garrus.mappers;

import java.util.List;

import org.garrus.api.domain.PostDTO;
import org.garrus.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

	PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );

	PostDTO postToDTO(Post post);
	Post dtoToPost(PostDTO post);

	List<PostDTO> listToPostDTO(List<Post> post);
}
