package org.garrus.driver;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.garrus.driver.leave.Leave;
import org.garrus.driver.leave.LeaveDTO;
import org.garrus.driver.leave.LeaveMapper;
import org.garrus.driver.leave.LeaveRepository;
import org.garrus.mappers.DateTimeMapper;
import org.garrus.rides.Ride;
import org.garrus.rides.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/driver")
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepo;
	
	@Autowired
	private LeaveRepository leaveRepo;
	
	@Autowired
	private RideRepository rideRepo;

	@RequestMapping("/detail/{rut}")
	public DriverDTO getByRut(@PathVariable("rut") String rut) {
		return 	DriverMapper.INSTANCE.entityToDTO(driverRepo.findById(rut).get());
	}
   
   
  	@RequestMapping("/listAll")
  	public List<DriverDTO> getAll() {
  		return DriverMapper.INSTANCE.listToDTOList(IterableUtils.toList(driverRepo.findAll()));
  	}

  	@RequestMapping("/listAvaliable")
  	public List<DriverDTO> getAvaliable(@RequestParam(value="start",required=true) String start, @RequestParam(value="end",required=true) String end) {
  		List<Driver> avaliables = IterableUtils.toList(driverRepo.findAll());
  		DateTimeMapper mapper = new DateTimeMapper();
  		List<Leave> leaves = IterableUtils.toList(leaveRepo.findLeavesBetweenDates(mapper.asDate(start), mapper.asDate(end)));
  		List<Ride> rides = rideRepo.findByOptionalParameter(null, null, mapper.asDate(start), mapper.asDate(end));
  		rides.stream().forEach(p->avaliables.remove(p.getChofer()));
  		leaves.stream().forEach(p->avaliables.remove(p.getChofer()));
		return DriverMapper.INSTANCE.listToDTOList(avaliables);
  	}
  	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void save(@RequestBody DriverDTO driver) {
		driverRepo.save(DriverMapper.INSTANCE.dtoToEntity(driver));
	}
	
	
	@RequestMapping(value="/leave",method=RequestMethod.POST)
	public void addLeave(@RequestBody LeaveDTO leave) {
		leaveRepo.save(LeaveMapper.INSTANCE.dtoToEntity(leave));
	}
	
	@RequestMapping(value="/leave/{id}",method=RequestMethod.DELETE)
	public void deleteLeave(@PathVariable("id") Integer id) {
		leaveRepo.deleteById(id);
	}
	
	
	
	@RequestMapping(value="/leave/{rut}",method=RequestMethod.GET)
	public List<LeaveDTO> getLeaves(@PathVariable("rut") String rut) {
		return LeaveMapper.INSTANCE.listToDTOList(leaveRepo.findByRutOrderByStartDesc(rut));
	}
}
