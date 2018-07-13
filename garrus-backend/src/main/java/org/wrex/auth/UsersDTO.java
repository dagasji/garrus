package org.wrex.auth;

import org.wrex.division.SectorDTO;

public class UsersDTO {

	private String username;
	private String password;
	private String name;
	private String specialPermissions;
	private SectorDTO sector;
	
	
	public String getSpecialPermissions() {
		return specialPermissions;
	}
	public void setSpecialPermissions(String specialPermissions) {
		this.specialPermissions = specialPermissions;
	}
	public SectorDTO getSector() {
		return sector;
	}
	public void setSector(SectorDTO sector) {
		this.sector = sector;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersDTO [username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append(", specialPermissions=");
		builder.append(specialPermissions);
		builder.append(", sector=");
		builder.append(sector);
		builder.append("]");
		return builder.toString();
	}
	
	
}
