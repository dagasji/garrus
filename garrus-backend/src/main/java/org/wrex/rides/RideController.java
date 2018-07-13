package org.wrex.rides;

import java.util.Date;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RideController {

	@Autowired
	private RideRepository repo;

	@RequestMapping(value = "/ride/", method = RequestMethod.POST)
	public void addRide(@RequestBody RideDTO ride) {
		repo.save(RideMapper.INSTANCE.dtoToEntity(ride));
	}

	@RequestMapping("/ride/listAll")
	public List<RideDTO> getAll() {
		return RideMapper.INSTANCE.listToDTOList(IterableUtils.toList(repo.findAll()));
	}

	@RequestMapping("/driver/{idRide}")
	public RideDTO save(@PathVariable Integer idRide) {
		return RideMapper.INSTANCE.entityToDTO(repo.findById(idRide).get());
	}

	@RequestMapping("/driver/find")
	public List<RideDTO> find(@RequestParam(value="plate",required=false) String plate, 
							  @RequestParam(value="rutChofer",required=false) String rutChofer,
							  @RequestParam(value="dateStart",required=false) Date dateStart,
							  @RequestParam(value="dateEnd",required=false) Date dateEnd) {
		
		return RideMapper.INSTANCE.listToDTOList(IterableUtils.toList((repo.findByOptionalParameter(plate, rutChofer, dateStart, dateEnd))));
	}

}
