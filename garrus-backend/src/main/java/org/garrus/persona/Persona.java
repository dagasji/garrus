package org.garrus.persona;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona2")
public class Persona {

	
	@Id
	private String rut;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private String telefono;
	
	@Column
	private String comentarios;
	
	@Column
	private String direccionCenso;
	
	@Column
	private String sexo;
	
	@Column
	private String run;
	
	@Column
	private String sector;
	
	@Column
	private int voto;
	

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
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
