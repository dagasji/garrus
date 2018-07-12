package org.wrex.auth;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.driver.Driver;
import org.wrex.driver.DriverDTO;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    
	UsersDTO entityToDTO(Users driver); 
	Users dtoToEntity(UsersDTO driver); 
    List<UsersDTO> listToDTOList(List<Users> source);
}
