package org.garrus.driver.leave;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.garrus.driver.Driver;

@Entity
@Table(name = "leaves")
public class Leave {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String rut;
	
	@Column(columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@Column(columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date end;
	
	@ManyToOne
	@JoinColumn(name="rut",updatable=false,insertable=false)
	private Driver chofer;

	
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
		Leave other = (Leave) obj;
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

	
}
