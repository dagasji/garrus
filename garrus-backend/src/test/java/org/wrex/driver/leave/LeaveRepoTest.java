package org.wrex.driver.leave;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wrex.Application;
import org.wrex.driver.leave.LeaveRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LeaveRepoTest {

	@Autowired
	private LeaveRepository repo;

	
	@Test
	public void fidnLeaves() {

		Calendar start = Calendar.getInstance();
		start.set(2018, 6, 28);
		Calendar end = Calendar.getInstance();
		end.set(2018, 6, 29);
		Assert.assertEquals(1, repo.findLeavesBetweenDates(start.getTime(),end.getTime()).size());
	}
	
	@Test
	public void findByRut() {
		Assert.assertEquals(new Integer(1), repo.findByRutOrderByStartDesc("22222222-2").get(0).getId());
	}
	
	@Test
	public void count() {
		Assert.assertEquals(1, repo.count());
	}

}
