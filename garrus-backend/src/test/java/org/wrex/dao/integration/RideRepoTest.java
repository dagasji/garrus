package org.wrex.dao.integration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wrex.Application;
import org.wrex.rides.Ride;
import org.wrex.rides.RideRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RideRepoTest {

	@Autowired
	RideRepository rideDao;

	final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Test
//	@Transactional
	public void fidnRidesWalter() {
		List<Ride> rides =  rideDao.findByOptionalParameter(null, "22222222-2", null, null);
		Assert.assertEquals(2, rides.size());
	}

	@Test
//	@Transactional
	public void fidnRidesFYJA() {
		List<Ride> rides =  rideDao.findByOptionalParameter("FYJA-44", null, null, null);
		Assert.assertEquals(3, rides.size());
	}
	
	@Test
//	@Transactional
	public void fidnRidesFYJAByDanilo() {
		List<Ride> rides =  rideDao.findByOptionalParameter("FYJA-44", "11111111-1", null, null);
		Assert.assertEquals(2, rides.size());
	}
	
	
	@Test
//	@Transactional
	public void fidnRidesByStartDate() {
		Calendar start = Calendar.getInstance();
		start.set(2018, 5, 27,1,0);
		List<Ride> rides =  rideDao.findByOptionalParameter(null, null, start.getTime(), null);
		Assert.assertEquals(3, rides.size());
	}
	
	@Test
	@Transactional
	public void addRide() {
		Ride ride = new Ride();
		ride.setDetails("asdasd");
		ride.setDistance(120);
		ride.setEnd(new Date());
		ride.setStart(new Date());
		ride.setRutChofer("11111111-1");
		ride.setPlate("FYJA-44");
		rideDao.save(ride);
	}
	
	@Test
//	@Transactional
	public void fidnRidesByEndDate() {
		Calendar start = Calendar.getInstance();
		start.set(2018, 5, 28);
		List<Ride> rides =  rideDao.findByOptionalParameter(null, null, null, start.getTime());
		Assert.assertEquals(3, rides.size());
	}
	
	@Test
//	@Transactional
	public void fidnRidesByStartAndEndDate() {
		Calendar start = Calendar.getInstance();
		start.set(2018, 5, 27,0,0);
		Calendar end = Calendar.getInstance();
		end.set(2018, 5, 30,23,59);
		List<Ride> rides =  rideDao.findByOptionalParameter(null, null, start.getTime(), end.getTime());
		Assert.assertEquals(3, rides.size());
	}
}
