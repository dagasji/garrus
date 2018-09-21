package org.garrus.division;

import org.apache.commons.lang3.StringUtils;
import org.garrus.dto.GenericDTO;
import org.junit.Test;

public class SectorDTO extends GenericDTO {

	private String name;

	private String description;

	private String divisionName;

	private String permissions;

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getPermissionList(){
		return this.permissions.split(",");
	}
	
	
	public void setPermissionList( String[] perm){
		this.permissions  = StringUtils.join(perm, ",");
	}
	
	@Test
	public void test() {
		String [] data = {"MODULE_VEHICLE_ACCESS","MODULE_VEHICLE_MODIFY"};
		this.permissions = "MODULE_VEHICLE_ACCESS,MODULE_VEHICLE_MODIFY";
		org.junit.Assert.assertArrayEquals(data, this.getPermissionList());
		
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		SectorDTO other = (SectorDTO) obj;
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
