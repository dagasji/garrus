package org.garrus.rides;

import java.util.List;

import org.garrus.mappers.DateMapper;
import org.garrus.mappers.DateTimeMapper;
import org.garrus.vehicles.VehicleMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses= {VehicleMapper.class,DateTimeMapper.class})
public interface RideMapper {
	RideMapper INSTANCE = Mappers.getMapper( RideMapper.class );
    
	RideDTO entityToDTO(Ride source); 
	Ride dtoToEntity(RideDTO source); 
    List<RideDTO> listToDTOList(List<Ride> source);
}
