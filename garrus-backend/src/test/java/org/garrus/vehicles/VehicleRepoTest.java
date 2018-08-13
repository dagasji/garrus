package org.garrus.vehicles;

import org.apache.commons.collections4.IterableUtils;
import org.garrus.Application;
import org.garrus.vehicles.VehicleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class VehicleRepoTest {

	@Autowired
	VehicleRepository vehicleDao;


	@Test
	public void getOnRepiar() {
		Assert.assertEquals("LAKN-55", vehicleDao.findByOnRepair(true).iterator().next().getPlate());
	}
	
	@Test
	public void getNotOnRepair() {
		Assert.assertEquals(3, IterableUtils.toList(vehicleDao.findByOnRepair(false)).size());
	}
}
