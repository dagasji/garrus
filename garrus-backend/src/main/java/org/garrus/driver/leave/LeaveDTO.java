package org.garrus.driver.leave;

import org.garrus.driver.DriverDTO;
import org.garrus.dto.GenericDTO;

public class LeaveDTO  extends GenericDTO{

	private Integer id;
	
	private String rut;
	
	private String start;
	
	private String end;

	private DriverDTO chofer;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Leave [id=");
		builder.append(id);
		builder.append(", rut=");
		builder.append(rut);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append("]");
		return builder.toString();
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
		LeaveDTO other = (LeaveDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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
	
	
}
