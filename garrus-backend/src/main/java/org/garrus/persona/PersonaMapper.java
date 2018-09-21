package org.garrus.persona;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {

	PersonaMapper INSTANCE = Mappers.getMapper( PersonaMapper.class );
    
	PersonaDTO entityToDTO(Persona source); 
	Persona dtoToEntity(PersonaDTO source); 
    List<PersonaDTO> listToDTOList(List<Persona	> source);
}
