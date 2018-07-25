package org.wrex.rides;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wrex.Application;
import org.wrex.driver.DriverDTO;
import org.wrex.vehicles.VehicleDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RideControllerTest {

	@Autowired
	private RideController rest;
	private SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");

	@Before
	public void before() throws Exception {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
		Date fixedDateTime = DATE_FORMATTER.parse("27/07/2018 10:12:00:000");
		DateTimeUtils.setCurrentMillisFixed(fixedDateTime.getTime());
	}

	@After
	public void after() throws Exception {
		DateTimeUtils.setCurrentMillisSystem();
	}

	@Test
	@Transactional
	public void testAddRideValid() {
		RideDTO ride = generateRide();
		rest.addRide(ride);
	}

	// @Test
	// @Transactional
	// public void testAddRideInValidVehicle() {
	// RideDTO ride= generateRide();
	// Calendar start = Calendar.getInstance();
	// start.set(2018, 6, 27,16,00);
	// Calendar end = Calendar.getInstance();
	// end.set(2018, 6, 27 ,17,00);
	// rest.addRide(ride);
	// }

	@Test
	@Transactional
	public void testUpdateRide() {
		RideDTO ride = rest.getById(1);
		ride.setDetails("Test");
		rest.updateRide(ride);
		Assert.assertEquals("Test", rest.getById(1).getDetails());
	}

	@Test
	public void testGetAll() {
		Assert.assertEquals(4, rest.getAll().size());
	}

	@Test
	public void testGetActive() {
		List<RideDTO> rides = rest.getActive();
		Assert.assertEquals(1, rides.size());
		Assert.assertEquals(new Integer(4), rides.get(0).getId());
	}

	@Test
	public void testGetNext() {
		List<RideDTO> rides = rest.getNext();
		Assert.assertEquals(1, rides.size());
		Assert.assertEquals(new Integer(1), rides.get(0).getId());
	}

	@Test
	public void testGetPast() {
		List<RideDTO> rides = rest.getPast();
		Assert.assertEquals(2, rides.size());
		RideDTO ride = new RideDTO();
		ride.setId(2);
		Assert.assertTrue(rides.contains(ride));
		ride.setId(3);
		Assert.assertTrue(rides.contains(ride));
	}

	@Test
	public void testGetById() {
		RideDTO ride = rest.getById(1);
		Assert.assertEquals("VIaje a natales", ride.getDetails());
	}

	@Test
	@Transactional
	public void testDelate() {
		rest.delate(1);
		List<RideDTO> rides = rest.getAll();
		RideDTO ride = new RideDTO();
		ride.setId(1);
		Assert.assertTrue(!rides.contains(ride));
	}

	private RideDTO generateRide() {
		DriverDTO dr = new DriverDTO();
		dr.setRut("22222222-2");
		RideDTO ride = new RideDTO();
		VehicleDTO ve = new VehicleDTO();
		ve.setPlate("FYJA-44");
		ride.setDetails("Test");
		ride.setDistance(120);
		ride.setEnd("2018-07-29T12:00:00");
		ride.setStart("2018-07-29T10:00:00");
		ride.setChofer(dr);
		ride.setVehicle(ve);
		return ride;
	}
}
