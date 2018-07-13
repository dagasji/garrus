package org.wrex.rides;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.wrex.driver.Driver;
import org.wrex.vehicles.Vehicle;

@Entity
public class Ride {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	
	@Column(columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	@Column
	private String plate;
	
	@Column
	private String rutChofer;
	
	@ManyToOne
	@JoinColumn(name="rutChofer",insertable=false,updatable=false)
	private Driver chofer;
	
	@ManyToOne
	@JoinColumn(name="plate",insertable=false,updatable=false)
	private Vehicle vehicle;
	
	@Column
	private String details;
	
	@Column
	private Integer distance;
	
	

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getRutChofer() {
		return rutChofer;
	}

	public void setRutChofer(String rutChofer) {
		this.rutChofer = rutChofer;
	}

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

	public Driver getChofer() {
		return chofer;
	}

	public void setChofer(Driver chofer) {
		this.chofer = chofer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
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
