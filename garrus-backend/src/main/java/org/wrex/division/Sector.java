package org.wrex.division;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sector {
	
	
	@Id
	private String name;

	@Column
	private String description;

	
	@Column
	private String divisionName;
	
	@Column
	private String permissions;
	
	@ManyToOne
	@JoinColumn(name="divisionName",insertable=false,updatable=false)
	private Division division;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Sector other = (Sector) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sector [name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", divisionName=");
		builder.append(divisionName);
		builder.append(", permissions=");
		builder.append(permissions);
		builder.append("]");
		return builder.toString();
	}
	

	

	
}
