package org.garrus.auth;

import java.util.ArrayList;
import java.util.List;

public enum PermissionEnum {
	
	
	GOD ("Acceso dios"),
	MODULE_VEHICLE_ACCESS ("Acceso a módulo de vehiculos"),
	MODULE_VEHICLE_MODIFY ("Modificacion en módulo de vehiculos");
	

	
	private String description;
	
	
	private PermissionEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static List<PermissionDTO> getAll(){
		List<PermissionDTO> list = new ArrayList<>();
		for (PermissionEnum iterable_element : PermissionEnum.values()){
				list.add(new PermissionDTO(iterable_element.name(),iterable_element.description));
		}
		return list;
	}
	
	
}
