package org.wrex.driver;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wrex.driver.leave.Leave;
import org.wrex.driver.leave.LeaveRepository;
import org.wrex.mappers.DateTimeMapper;
import org.wrex.rides.Ride;
import org.wrex.rides.RideRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {
	
	@Autowired
	private DriverService service;
	
	@Autowired
	private LeaveRepository leaveRepo;

	@Autowired
	private RideRepository rideRepo;
	
	@Autowired
	private DriverRepository driverRepo;
	

	@RequestMapping("/driver/detail/{rut}")
	public DriverDTO getByPlate(@PathVariable("rut") String plate) {
		return service.getDriverByRut(plate);
	}
   
   
  	@RequestMapping("/driver/listAll")
  	public List<DriverDTO> getAll() {
  		return service.getAllDrivers();
  	}

  	@RequestMapping("/driver/listAvaliable")
  	public List<DriverDTO> getAvaliable(@RequestParam(value="start",required=true) String start, @RequestParam(value="end",required=true) String end) {
  		List<Driver> avaliables = IterableUtils.toList(driverRepo.findAll());
  		DateTimeMapper mapper = new DateTimeMapper();
  		List<Leave> leaves = IterableUtils.toList(leaveRepo.findLeavesBetweenDates(mapper.asDate(start), mapper.asDate(end)));
  		List<Ride> rides = rideRepo.findByOptionalParameter(null, null, mapper.asDate(start), mapper.asDate(end));
  		rides.stream().forEach(p->avaliables.remove(p.getChofer()));
  		leaves.stream().forEach(p->avaliables.remove(p.getChofer()));
		return DriverMapper.INSTANCE.listToDTOList(avaliables);
  	}
  	
	@RequestMapping("/driver/save")
	public void save(@RequestBody DriverDTO driver) {
		service.saveDriver(driver);
	}
}
