package org.wrex.driver;

import static org.junit.Assert.fail;

import java.util.List;

import javax.transaction.Transactional;

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
	public void testGetAll() {
		Assert.assertEquals(2,rest.getAll().size());
	}
	
	@Test
	public void testGetByRut() {
		DriverDTO dri = rest.getByRut("22222222-2");
		Assert.assertEquals("Walter", dri.getName());
	}


	@Test
	public void testGetAvaliableAll() {
		List<DriverDTO> res = rest.getAvaliable("2018-07-27T11:01:00", "2018-07-27T15:59:00");
		Assert.assertEquals(2, res.size());
	}
	
	@Test
	public void testGetAvaliableNone() {
		List<DriverDTO> res = rest.getAvaliable("2018-07-26T11:01:00", "2018-07-27T15:59:00");
		Assert.assertTrue(res.isEmpty());
	}
	
	@Test
	public void testGetAvaliableLeave() {
		List<DriverDTO> res = rest.getAvaliable("2018-07-28T11:01:00", "2018-07-28T15:59:00");
		Assert.assertEquals("Danilo",res.get(0).getName());
	}
	
	@Test
	public void testGetAvaliableLeave2() {
		List<DriverDTO> res = rest.getAvaliable("2018-07-29T11:01:00", "2018-07-29T15:59:00");
		Assert.assertEquals("Danilo",res.get(0).getName());
	}
	

	@Test
	public void testGetAvaliableOne() {
		List<DriverDTO> res = rest.getAvaliable("2018-07-26T14:01:00", "2018-07-26T18:59:00");
		Assert.assertEquals(1, res.size());
		Assert.assertEquals("Walter", res.get(0).getName());
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
