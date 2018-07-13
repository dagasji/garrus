package org.wrex.division;

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
public class DivisionController {
	
	@Autowired
	private DivisionRepository divisionRepo;
	
	@Autowired
	private SectorRepository sectorRepo;

	@RequestMapping(value="/division/{name}",method=RequestMethod.GET)
	public DivisionDTO getDivisionByName(@PathVariable("name") String name) {
		Optional<Division> div = divisionRepo.findById(name);
		if (div.isPresent())
			return DivisionMapper.INSTANCE.entityToDTO(div.get());
		else
			return null;
	}
	
	@RequestMapping(value="/division/{name}",method=RequestMethod.PUT)
	public void updateDivision(@PathVariable("name") String name, @RequestBody DivisionDTO division) {
		Optional<Division> div = divisionRepo.findById(name);
		if (div.isPresent())
			divisionRepo.save(DivisionMapper.INSTANCE.dtoToEntity(division));
	}
	
	@RequestMapping(value="/division/",method=RequestMethod.POST)
	public void createDivision(@RequestBody DivisionDTO division) {
		Optional<Division> div = divisionRepo.findById(division.getName());
		if (!div.isPresent())
			divisionRepo.save(DivisionMapper.INSTANCE.dtoToEntity(division));
	}
	
   
  	@RequestMapping("/division/listAll")
  	public List<DivisionDTO> getAll() {
  		return DivisionMapper.INSTANCE.listToDTOList(IterableUtils.toList(divisionRepo.findAll()));
  	}
  	
}
