package org.wrex.dao.integration;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wrex.Application;
import org.wrex.division.Division;
import org.wrex.division.DivisionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DivisionRepoTest {

	@Autowired
	DivisionRepository divDao;

	@Test
	@Transactional
	public void getDivision() {
		Division div = divDao.findById("Administracion").get();
		Assert.assertEquals("Administración municipal", div.getDescription());
		Assert.assertEquals("Servicios generales", div.getSectors().get(0).getName());
	}

}
