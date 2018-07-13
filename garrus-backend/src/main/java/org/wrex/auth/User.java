package org.wrex.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.wrex.division.Sector;

@Entity(name="users")
public class User {
	
	@Id
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String name;

	@Column
	private String specialPermissions;
	
	@ManyToOne
	@JoinColumn(name="sector")
	private Sector sector;
	
	public String getUsername() {
		return username;
	}
	
	

	public Sector getSector() {
		return sector;
	}



	public void setSector(Sector sector) {
		this.sector = sector;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [username=");
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



	public String getSpecialPermissions() {
		return specialPermissions;
	}

	public void setSpecialPermissions(String specialPermissions) {
		this.specialPermissions = specialPermissions;
	}
	

}
