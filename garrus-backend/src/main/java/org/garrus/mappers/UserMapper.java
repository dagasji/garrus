package org.garrus.mappers;

import java.util.List;

import org.garrus.api.domain.UserDTO;
import org.garrus.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    
    UserDTO userToUserDTO(User user); 
    User userDtoToUser(UserDTO user); 
    List<UserDTO> listToDTOList(List<User> source);
}
