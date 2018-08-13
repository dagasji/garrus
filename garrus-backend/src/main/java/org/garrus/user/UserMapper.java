package org.garrus.user;

import java.util.List;

import org.garrus.driver.Driver;
import org.garrus.driver.DriverDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    
	UserDTO entityToDTO(User source); 
	User dtoToEntity(UserDTO source); 
    List<UserDTO> listToDTOList(List<User> source);
}
