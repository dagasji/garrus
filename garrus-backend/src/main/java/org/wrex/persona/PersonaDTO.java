package org.wrex.persona;

import org.wrex.dto.GenericDTO;

public class PersonaDTO extends GenericDTO {

	
	private String rut;
	
	
	private String name;
	
	
	private String direccion;
	
	
	private String telefono;
	
	
	private String comentarios;
	
	
	private String direccionCenso;
	
	
	private String sexo;
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonaDTO [rut=");
		builder.append(rut);
		builder.append(", name=");
		builder.append(name);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", comentarios=");
		builder.append(comentarios);
		builder.append(", direccionCenso=");
		builder.append(direccionCenso);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append("]");
		return builder.toString();
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
		PersonaDTO other = (PersonaDTO) obj;
		if (rut == null) {
			if (other.rut != null)
				return false;
		} else if (!rut.equals(other.rut))
			return false;
		return true;
	}

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getDireccionCenso() {
		return direccionCenso;
	}

	public void setDireccionCenso(String direccionCenso) {
		this.direccionCenso = direccionCenso;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
}
