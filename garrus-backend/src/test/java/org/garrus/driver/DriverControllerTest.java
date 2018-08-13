package org.garrus.driver;

import javax.transaction.Transactional;

import org.garrus.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DriverControllerTest {

	@Autowired
	DriverController rest;

	@Test
	public void testGetAll() {
		Assert.assertEquals(2,rest.getAll().size());
	}
	
	@Test
	public void testGetByRut() {
		DriverDTO dri = rest.getByRut("22222222-2");
		Assert.assertEquals("Walter", dri.getName());
	}
	
	@Test
	@Transactional
	public void testSave() {
		DriverDTO dri = new DriverDTO();
		dri.setRut("2");
		dri.setName("test");
		rest.save(dri);
		Assert.assertEquals("test", rest.getByRut("2").getName());
	}
	
	@Test
	@Transactional
	public void testSaveExists() {
		DriverDTO dri = new DriverDTO();
		dri.setRut("22222222-2");
		dri.setName("test");
		rest.save(dri);
		Assert.assertEquals(2, rest.getAll().size());
	}

}
