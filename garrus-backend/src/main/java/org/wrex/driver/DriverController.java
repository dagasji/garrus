package org.wrex.driver;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wrex.driver.leave.Leave;
import org.wrex.driver.leave.LeaveDTO;
import org.wrex.driver.leave.LeaveMapper;
import org.wrex.driver.leave.LeaveRepository;
import org.wrex.mappers.DateTimeMapper;
import org.wrex.rides.Ride;
import org.wrex.rides.RideRepository;

@RestController
@CrossOrigin(origins = "*")
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
	public DriverDTO getByRut(@PathVariable("rut") String rut) {
		return service.getDriverByRut(rut);
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
  	
	@RequestMapping(value="/driver",method=RequestMethod.POST)
	public void save(@RequestBody DriverDTO driver) {
		service.saveDriver(driver);
	}
	
	
	@RequestMapping(value="/driver/leave",method=RequestMethod.POST)
	public void addLeave(@RequestBody LeaveDTO leave) {
		leaveRepo.save(LeaveMapper.INSTANCE.dtoToEntity(leave));
	}
	
	@RequestMapping(value="/driver/leave/{id}",method=RequestMethod.DELETE)
	public void deleteLeave(@PathVariable("id") Integer id) {
		leaveRepo.deleteById(id);
	}
	
	
	
	@RequestMapping(value="/driver/leave/{rut}",method=RequestMethod.GET)
	public List<LeaveDTO> getLeaves(@PathVariable("rut") String rut) {
		return LeaveMapper.INSTANCE.listToDTOList(leaveRepo.findByRutOrderByStartDesc(rut));
	}
}
