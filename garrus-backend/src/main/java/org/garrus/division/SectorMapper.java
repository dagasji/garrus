package org.garrus.division;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectorMapper {
	SectorMapper INSTANCE = Mappers.getMapper( SectorMapper.class );
    
	SectorDTO entityToDTO(Sector sector); 
	Sector dtoToEntity(SectorDTO sector); 
    List<SectorDTO> listToDTOList(List<Sector> source);
}
