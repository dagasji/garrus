package org.wrex.driver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wrex.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DriverControllerTest {

	@Autowired
	DriverController rest;

	@Test
	public void getAll() {
		Assert.assertEquals(4,rest.getAll().size());
	}
}
