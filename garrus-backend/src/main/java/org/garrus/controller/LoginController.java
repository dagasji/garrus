package org.garrus.controller;

import org.garrus.api.domain.UserDTO;
import org.garrus.dao.UserRepository;
import org.garrus.entities.User;
import org.garrus.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	UserRepository userDao;

	static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	    @RequestMapping("/userByemail")
		public UserDTO getByEmail(@RequestParam String email) {
			LOG.info("getByEmail "  + email);
			User user = userDao.findOneByEmail(email);
			if (user != null)
				return UserMapper.INSTANCE.userToUserDTO(user);
			return null;
		}
}
