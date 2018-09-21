package org.garrus.rides;


import org.garrus.driver.DriverDTO;
import org.garrus.dto.GenericDTO;
import org.garrus.vehicles.VehicleDTO;

public class RideDTO  extends GenericDTO{

	private Integer id;
	
	private String start;

	private String end;
	
	private DriverDTO chofer;
	
	private VehicleDTO vehicle;
	
	private String details;
	
	private Integer distance;
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RideDTO [id=");
		builder.append(id);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append(", chofer=");
		builder.append(chofer);
		builder.append(", vehicle=");
		builder.append(vehicle);
		builder.append(", details=");
		builder.append(details);
		builder.append(", distance=");
		builder.append(distance);
		builder.append("]");
		return builder.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RideDTO other = (RideDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
