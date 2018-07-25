package org.wrex.auth;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wrex.Application;
import org.wrex.auth.User;
import org.wrex.auth.UsersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepoTest {

	@Autowired
	UsersRepository userDao;

	@Test
	@Transactional
	public void getUser() {
		User user = userDao.findById("Konum").get();
		Assert.assertEquals("Servicios generales", user.getSector().getName());
	}

}
