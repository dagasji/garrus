package org.wrex.vehicles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wrex.mappers.DateTimeMapper;
import org.wrex.rides.Ride;
import org.wrex.rides.RideRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {
	
	@Autowired
	private VehicleService service;
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private RideRepository rideRepo;

	@RequestMapping(value="/vehicle/{plate}",method=RequestMethod.GET)
	public VehicleDTO getByPlate(@PathVariable("plate") String plate) {
		return service.load(plate);
	}
	
	@RequestMapping(value="/vehicle/{plate}", method=RequestMethod.DELETE)
	public void deleteByPlate(@PathVariable("plate") String plate) {
		service.delete(plate);
	}
   
   
  	@RequestMapping("/vehicle/listAll")
  	public List<VehicleDTO> getAll() {
  		return service.getAll();
  	}
  	
	@RequestMapping("/vehicle/listAvaliable")
  	public List<VehicleDTO> getAvaliable(@RequestParam(value="start",required=true) String start, @RequestParam(value="end",required=true) String end) {
  		List<Vehicle> avaliables = vehicleRepo.findByOnRepair(false);
  		DateTimeMapper mapper = new DateTimeMapper();
  		List<Ride> rides = rideRepo.findByOptionalParameter(null, null, mapper.asDate(start), mapper.asDate(end));
  		rides.stream().forEach(p->avaliables.remove(p.getVehicle()));
		return VehicleMapper.INSTANCE.listToDTOList(avaliables);
  	}
   
   
  	
  	@RequestMapping(value="/vehicle",method=RequestMethod.POST)
	public void save(@RequestBody VehicleDTO vehicle) {
		service.save(vehicle);
	}
  	
  	@RequestMapping(value="/vehicle/entry",method=RequestMethod.POST)
	public void addEntry(@RequestBody EntryDTO entry) {
		service.addEntry(entry);
	}
  	
  	@RequestMapping(value="/vehicle/entry/{id}",method=RequestMethod.DELETE)
	public void deleteEntry(@PathVariable("id") int entryId) {
		service.deleteEntry(entryId);
	}
  	
  	@RequestMapping(value="/vehicle/entry/{plate}",method=RequestMethod.GET)
	public List<EntryDTO> getEntries(@PathVariable("plate") String plate) {
  		return service.getEntries(plate);
  	}
}
