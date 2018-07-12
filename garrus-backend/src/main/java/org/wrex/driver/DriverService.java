package org.wrex.driver;

import java.util.List;

public interface DriverService {

	public List<DriverDTO> getAllDrivers();
	
	public DriverDTO getDriverByRut(String rut);
	
	public void saveDriver(DriverDTO driver);
	
	public void deleteDriverByRut(String rut);
}
