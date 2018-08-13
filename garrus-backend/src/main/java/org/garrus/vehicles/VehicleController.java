package org.garrus.vehicles;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.garrus.vehicles.entry.EntryDTO;
import org.garrus.vehicles.entry.EntryMapper;
import org.garrus.vehicles.entry.EntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private")
public class VehicleController {

	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private EntryRepository entryRepo;

	@RequestMapping(value="/vehicle/{plate}",method=RequestMethod.GET)
	public VehicleDTO getByPlate(@PathVariable("plate") String plate) {
		if (logger.isDebugEnabled()) {
			logger.debug("load(String plate={}) - start", plate);
		}

		Optional<Vehicle> ve = vehicleRepo.findById(plate);
		if (ve.isPresent()) {
			if (logger.isDebugEnabled()) {
				logger.debug("load() - end - return value={}",ve);
			}
			return VehicleMapper.INSTANCE.entityToDTO(ve.get());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("load() - end - return value={null}");
		}
		return null;
	}
	
	@RequestMapping(value="/vehicle/{plate}", method=RequestMethod.DELETE)
	public void deleteByPlate(@PathVariable("plate") String plate) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(String plate={}) - start", plate);
		}

		vehicleRepo.deleteById(plate);

		if (logger.isDebugEnabled()) {
			logger.debug("delete() - end");
		}
	}
   
   
  	@RequestMapping("/vehicle/listAll")
  	public List<VehicleDTO> getAll() {
  		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start");
		}

		List<VehicleDTO> returnList = VehicleMapper.INSTANCE.listToDTOList(IterableUtils.toList(vehicleRepo.findAll()));
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList);
		}
		return returnList; 
  	}
  	
  	
  	@RequestMapping(value="/vehicle",method=RequestMethod.POST)
	public void save(@RequestBody VehicleDTO vehicle) {
  		if (logger.isDebugEnabled()) {
			logger.debug("save(VehicleDTO ve={}) - start", vehicle);
		}

  		vehicleRepo.save(VehicleMapper.INSTANCE.dtoToEntity(vehicle));

		if (logger.isDebugEnabled()) {
			logger.debug("save() - end");
		}
	}
  	
  	@RequestMapping(value="/vehicle/entry",method=RequestMethod.POST)
	public void addEntry(@RequestBody EntryDTO entry) {
  		if (logger.isDebugEnabled()) {
			logger.debug("addEntry(EntryDTO entry={}) - start", entry);
		}

  		entryRepo.save(EntryMapper.INSTANCE.dtoToEntity(entry));

		if (logger.isDebugEnabled()) {
			logger.debug("addEntry() - end");
		}
	}
  	
  	@RequestMapping(value="/vehicle/entry/{id}",method=RequestMethod.DELETE)
	public void deleteEntry(@PathVariable("id") int entryId) {
  		if (logger.isDebugEnabled()) {
			logger.debug("deleteEntry(EntryDTO entry={}) - start", entryId);
		}

  		entryRepo.deleteById(entryId);

		if (logger.isDebugEnabled()) {
			logger.debug("deleteEntry() - end");
		}
	}
  	
  	@RequestMapping(value="/vehicle/entry/{plate}",method=RequestMethod.GET)
	public List<EntryDTO> getEntries(@PathVariable("plate") String plate) {
  		if (logger.isDebugEnabled()) {
			logger.debug("getEntries(plate={}) - start", plate);
		}

		return EntryMapper.INSTANCE.listToDTOList(entryRepo.findByPlateOrderByDateDesc(plate));
  	}
}
