package org.wrex.driver.leave;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.mappers.DateMapper;

@Mapper(uses=DateMapper.class)
public interface LeaveMapper {
	LeaveMapper INSTANCE = Mappers.getMapper( LeaveMapper.class );
    
	LeaveDTO entityToDTO(Leave driver); 
	Leave dtoToEntity(LeaveDTO driver); 
    List<LeaveDTO> listToDTOList(List<Leave> source);
}
