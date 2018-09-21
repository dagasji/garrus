package org.garrus.driver.leave;

import java.util.List;

import org.garrus.mappers.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=DateMapper.class)
public interface LeaveMapper {
	LeaveMapper INSTANCE = Mappers.getMapper( LeaveMapper.class );
    
	LeaveDTO entityToDTO(Leave driver); 
	Leave dtoToEntity(LeaveDTO driver); 
    List<LeaveDTO> listToDTOList(List<Leave> source);
}
