package org.garrus.division;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SectorController {
	
	@Autowired
	private SectorRepository sectorRepo;

	
	@RequestMapping(value="/sector/{name}",method=RequestMethod.GET)
	public SectorDTO getSectorByName(@PathVariable("name") String name) {
		Optional<Sector> div = sectorRepo.findById(name);
		if (div.isPresent())
			return SectorMapper.INSTANCE.entityToDTO(div.get());
		else
			return null;
	}
	
	@RequestMapping(value="/sector/{name}",method=RequestMethod.PUT)
	public void updateSector(@PathVariable("name") String name, @RequestBody SectorDTO sector) {
		Optional<Sector> div = sectorRepo.findById(name);
		if (div.isPresent())
			sectorRepo.save(SectorMapper.INSTANCE.dtoToEntity(sector));
	}
	
	@RequestMapping(value="/sector/",method=RequestMethod.POST)
	public void createSector(@RequestBody SectorDTO sector) {
		Optional<Sector> div = sectorRepo.findById(sector.getName());
		if (!div.isPresent())
			sectorRepo.save(SectorMapper.INSTANCE.dtoToEntity(sector));
	}
	
   
  	@RequestMapping("/sector/listAll")
  	public List<SectorDTO> getAllSector() {
  		return SectorMapper.INSTANCE.listToDTOList(IterableUtils.toList(sectorRepo.findAll()));
  	}
}
