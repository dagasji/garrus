package org.wrex.vehicles;


import java.util.List;
import java.util.TimeZone;

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
public class VehicleControllerTest {

	@Autowired
	VehicleController rest;
	
	 
	@Test
	public void testGetByPlate() {
		VehicleDTO dto = rest.getByPlate("FYJA-44");
		Assert.assertEquals("gasolina", dto.getGas());
	}

	@Test
	@Transactional
	public void testDeleteByPlate() {
		rest.deleteByPlate("FYJA-44");
		VehicleDTO dto = rest.getByPlate("FYJA-44");
		Assert.assertNull(dto);
	}

	@Test
	public void testGetAll() {
		List<VehicleDTO> res = rest.getAll();
		Assert.assertEquals(4, res.size());
	}

	@Test
	public void testGetAvaliableAll() {
		List<VehicleDTO> res = rest.getAvaliable("2018-07-27T15:01:00", "2018-07-27T19:59:00");
		Assert.assertEquals(3, res.size());
	}
	
	@Test
	public void testGetAvaliableUsed() {
		List<VehicleDTO> res = rest.getAvaliable("2018-07-26T16:01:00", "2018-07-26T17:59:00");
		Assert.assertEquals(1, res.size());
		VehicleDTO jy =  new VehicleDTO();
		jy.setPlate("JYSH-22");
		Assert.assertEquals(false, res.contains(jy));
		
		VehicleDTO uk =  new VehicleDTO();
		jy.setPlate("UKWH-33");
		Assert.assertEquals(false, res.contains(uk));
	}

	private VehicleDTO generateDto() {
		VehicleDTO dto = new VehicleDTO();
		dto.setPlate("AAAA");
		return dto;
	}
	@Test
	@Transactional
	public void testSave() {
		rest.save(generateDto());
		Assert.assertEquals("AAAA",rest.getByPlate("AAAA").getPlate());
	}

	@Test
	@Transactional
	public void testAddEntry() {
		EntryDTO entry =  new EntryDTO();
		entry.setDate("2018-07-28");
		entry.setInfo("Test");
		entry.setPlate("JYSH-22");
		rest.addEntry(entry);
		List<EntryDTO> entries = rest.getEntries("JYSH-22");
		Assert.assertEquals(1,entries.size());
		Assert.assertEquals("Test",entries.get(0).getInfo());
	}

	@Test
	@Transactional
	public void testDeleteEntry() {
		rest.deleteEntry(1);
		List<EntryDTO> entries = rest.getEntries("FYJA-44");
		EntryDTO entry =  new EntryDTO();
		entry.setId(1);
		Assert.assertTrue(!entries.contains(entry));
	}

	@Test
	public void testGetEntries() {
		List<EntryDTO> entries = rest.getEntries("FYJA-44");
		EntryDTO entry =  new EntryDTO();
		entry.setId(1);
		Assert.assertTrue(entries.contains(entry));
		entry.setId(2);
		Assert.assertTrue(entries.contains(entry));
		entry.setId(3);
		Assert.assertTrue(entries.contains(entry));
	}

}
