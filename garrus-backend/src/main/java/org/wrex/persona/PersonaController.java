package org.wrex.persona;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
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
public class PersonaController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(PersonaController.class.getName());

	@Autowired
	private PersonaRepository repo;

	@RequestMapping(value = "/persona/{rut}", method = RequestMethod.GET)
	public PersonaDTO getUserByRut(@PathVariable("rut") String rut) {
		if (logger.isDebugEnabled()) {
			logger.debug("getUserByRut(String) - start"); //$NON-NLS-1$
		}

		Optional<Persona> persona = repo.findById(rut);
		if (persona.isPresent()) {
			PersonaDTO returnPersonaDTO = PersonaMapper.INSTANCE.entityToDTO(persona.get());
			if (logger.isDebugEnabled()) {
				logger.debug("getUserByRut(String) - end"); //$NON-NLS-1$
			}
			return returnPersonaDTO;
		} else
			return null;
	}

	@RequestMapping(value = "/persona/getAll", method = RequestMethod.GET)
	public List<PersonaDTO> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start"); //$NON-NLS-1$
		}

		List<PersonaDTO> returnList = PersonaMapper.INSTANCE.listToDTOList(IterableUtils.toList(repo.findAll()));
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end"); //$NON-NLS-1$
		}
		return returnList;
	}

	@RequestMapping(value = "/persona", method = RequestMethod.GET)
	public List<PersonaDTO> findByRutOrName(@RequestParam(value = "param", required = true) String param) {
		if (logger.isDebugEnabled()) {
			logger.debug("findByRutOrName(String) - start"); //$NON-NLS-1$
		}

		String run = param.replace(".", "");
		run = StringUtils.substringBefore(run, "-");

		List<PersonaDTO> returnList = PersonaMapper.INSTANCE
				.listToDTOList(IterableUtils.toList(repo.findByRunContainingOrNombreIgnoreCaseContaining(run, param)));
		if (logger.isDebugEnabled()) {
			logger.debug("findByRutOrName(String) - end"); //$NON-NLS-1$
		}
		return returnList;
	}

	@RequestMapping(value = "/persona", method = RequestMethod.POST)
	public void saveUser(@RequestBody PersonaDTO persona) {
		if (logger.isDebugEnabled()) {
			logger.debug("saveUser(PersonaDTO) - start"); //$NON-NLS-1$
		}

		Optional<Persona> present = repo.findById(persona.getName());
		if (!present.isPresent())
			repo.save(PersonaMapper.INSTANCE.dtoToEntity(persona));

		if (logger.isDebugEnabled()) {
			logger.debug("saveUser(PersonaDTO) - end"); //$NON-NLS-1$
		}
	}

	@RequestMapping(value = "/persona/{rut}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable("rut") String rut, @RequestBody PersonaDTO persona) {
		if (logger.isDebugEnabled()) {
			logger.debug("updateUser(String, PersonaDTO) - start"); //$NON-NLS-1$
		}

		Optional<Persona> present = repo.findById(rut);
		if (present.isPresent())
			repo.save(PersonaMapper.INSTANCE.dtoToEntity(persona));

		if (logger.isDebugEnabled()) {
			logger.debug("updateUser(String, PersonaDTO) - end"); //$NON-NLS-1$
		}
	}

	@RequestMapping(value = "/persona/{rut}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("rut") String rut) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteUser(String) - start"); //$NON-NLS-1$
		}

		Optional<Persona> present = repo.findById(rut);
		if (present.isPresent())
			repo.deleteById(rut);

		if (logger.isDebugEnabled()) {
			logger.debug("deleteUser(String) - end"); //$NON-NLS-1$
		}
	}
}
