package org.garrus.driver;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/driver")
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepo;
	

	@RequestMapping("/detail/{rut}")
	public DriverDTO getByRut(@PathVariable("rut") String rut) {
		return 	DriverMapper.INSTANCE.entityToDTO(driverRepo.findById(rut).get());
	}
   
   
  	@RequestMapping("/listAll")
  	public List<DriverDTO> getAll() {
  		return DriverMapper.INSTANCE.listToDTOList(IterableUtils.toList(driverRepo.findAll()));
  	}

	public void save(@RequestBody DriverDTO driver) {
		driverRepo.save(DriverMapper.INSTANCE.dtoToEntity(driver));
	}
	
}
