package org.garrus.division;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DivisionMapper {
	DivisionMapper INSTANCE = Mappers.getMapper( DivisionMapper.class );
    
	DivisionDTO entityToDTO(Division division); 
	Division dtoToEntity(DivisionDTO division); 
    List<DivisionDTO> listToDTOList(List<Division> source);
}
