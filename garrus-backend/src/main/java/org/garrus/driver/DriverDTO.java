package org.garrus.driver;

import org.garrus.dto.GenericDTO;

public class DriverDTO  extends GenericDTO{
	
	private String rut;
	
	private String name;
	

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rut == null) ? 0 : rut.hashCode());
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
		DriverDTO other = (DriverDTO) obj;
		if (rut == null) {
			if (other.rut != null)
				return false;
		} else if (!rut.equals(other.rut))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DriverDTO [rut=");
		builder.append(rut);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	
}
