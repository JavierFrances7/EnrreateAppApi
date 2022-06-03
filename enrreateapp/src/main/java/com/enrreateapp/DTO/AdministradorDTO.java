package com.enrreateapp.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class AdministradorDTO {

	private String uidAdministrador;
	private String nombre;
	private String correo;
	private String displayName;

	public AdministradorDTO() {
	}

	public AdministradorDTO(String uidAdministrador, String nombre, String correo, String displayName) {
		super();
		this.uidAdministrador = uidAdministrador;
		this.nombre = nombre;
		this.correo = correo;
		this.displayName = displayName;
	}

	public String getUidAdministrador() {
		return uidAdministrador;
	}

	public void setUidAdministrador(String uidAdministrador) {
		this.uidAdministrador = uidAdministrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
