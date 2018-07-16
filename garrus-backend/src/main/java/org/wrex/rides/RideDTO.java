package org.wrex.rides;


import java.util.Date;

import org.wrex.driver.DriverDTO;
import org.wrex.vehicles.VehicleDTO;

public class RideDTO {

	private Integer id;
	
	private Date start;

	private Date end;
	
	private DriverDTO chofer;
	
	private VehicleDTO vehicle;
	
	private String details;
	
	private Integer distance;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	
	public DriverDTO getChofer() {
		return chofer;
	}

	public void setChofer(DriverDTO chofer) {
		this.chofer = chofer;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	
}
