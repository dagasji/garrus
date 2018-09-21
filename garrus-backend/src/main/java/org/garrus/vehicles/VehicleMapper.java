package org.garrus.vehicles;

import java.util.List;

import org.garrus.mappers.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=DateMapper.class)
public interface VehicleMapper {
	VehicleMapper INSTANCE = Mappers.getMapper( VehicleMapper.class );
    
	VehicleDTO entityToDTO(Vehicle user); 
	Vehicle dtoToEntity(VehicleDTO user); 
    List<VehicleDTO> listToDTOList(List<Vehicle> source);
}
