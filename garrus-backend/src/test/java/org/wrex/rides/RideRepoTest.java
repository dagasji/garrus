package org.wrex.rides;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.transaction.Transactional;

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
import org.wrex.rides.Ride;
import org.wrex.rides.RideRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RideRepoTest {

	@Autowired
	RideRepository rideDao;

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
	public void fidnRidesWalter() {
		List<Ride> rides =  rideDao.findByOptionalParameter(null, "22222222-2", null, null);
		Assert.assertEquals(2, rides.size());
	}

	@Test
	public void fidnRidesFYJA() {
		List<Ride> rides =  rideDao.findByOptionalParameter("FYJA-44", null, null, null);
		Assert.assertEquals(1, rides.size());
	}
	
	@Test
	public void fidnRidesFYJAByDanilo() {
		List<Ride> rides =  rideDao.findByOptionalParameter("UKWH-33", "11111111-1", null, null);
		Assert.assertEquals(1, rides.size());
	}
	
	
	@Test
	public void fidnRidesByStartDate() {
		Calendar start = Calendar.getInstance();
		start.set(2018, 6, 26,15,0);
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
	public void fidnRidesByEndDate() {
		Calendar start = Calendar.getInstance();
		start.set(2018, 6, 27,10,16);
		List<Ride> rides =  rideDao.findByOptionalParameter(null, null, null, start.getTime());
		Assert.assertEquals(3, rides.size());
	}
	
	@Test
	public void fidnRidesByStartAndEndDate() {
		Calendar start = Calendar.getInstance();
		start.set(2018, 6, 26,10,0);
		Calendar end = Calendar.getInstance();
		end.set(2018, 6, 27,10,59);
		List<Ride> rides =  rideDao.findByOptionalParameter(null, null, start.getTime(), end.getTime());
		Assert.assertEquals(3, rides.size());
	}
}
