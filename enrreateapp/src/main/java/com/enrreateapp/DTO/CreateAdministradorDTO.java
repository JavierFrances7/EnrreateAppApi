package com.enrreateapp.DTO;

public class CreateAdministradorDTO {

	private String uidAdministrador;
	private String nombre;
	private String correo;

	public CreateAdministradorDTO() {
	}

	public CreateAdministradorDTO(String uidAdministrador, String nombre, String correo) {
		this.uidAdministrador = uidAdministrador;
		this.nombre = nombre;
		this.correo = correo;
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

}
