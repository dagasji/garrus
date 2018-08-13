package org.garrus.vehicles.entry;

import java.util.List;

import org.garrus.mappers.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=DateMapper.class)
public interface EntryMapper {
	EntryMapper INSTANCE = Mappers.getMapper( EntryMapper.class );
    
	EntryDTO entityToDTO(Entry source); 
	Entry dtoToEntity(EntryDTO source); 
    List<EntryDTO> listToDTOList(List<Entry> source);
}
