package org.garrus.auth;

import javax.transaction.Transactional;

import org.garrus.Application;
import org.garrus.user.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepoTest {

	@Autowired
	UserRepository userDao;

	@Test
	@Transactional
	public void getUser() {
		User user = userDao.findById("Konum").get();
		Assert.assertEquals("Guillermo Gefaell", user.getName());
	}

}
