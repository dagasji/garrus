package org.wrex.rides;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.mappers.DateMapper;
import org.wrex.mappers.DateTimeMapper;
import org.wrex.vehicles.VehicleMapper;

@Mapper(uses= {VehicleMapper.class,DateTimeMapper.class})
public interface RideMapper {
	RideMapper INSTANCE = Mappers.getMapper( RideMapper.class );
    
	RideDTO entityToDTO(Ride source); 
	Ride dtoToEntity(RideDTO source); 
    List<RideDTO> listToDTOList(List<Ride> source);
}
