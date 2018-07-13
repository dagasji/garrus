package org.wrex.auth;

public class PermissionDTO{
	String key;
	String description;
	
	
	public PermissionDTO(String key, String description) {
		super();
		this.key = key;
		this.description = description;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PermissionDTO [key=");
		builder.append(key);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	
}
