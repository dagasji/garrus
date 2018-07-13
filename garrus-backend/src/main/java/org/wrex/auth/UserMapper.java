package org.wrex.auth;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.driver.Driver;
import org.wrex.driver.DriverDTO;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    
	UsersDTO entityToDTO(User source); 
	User dtoToEntity(UsersDTO source); 
    List<UsersDTO> listToDTOList(List<User> source);
}
