package com.enrreateapp.DTO;

import java.util.Date;

public class CreateUsuarioDTO {

	private String uidUsuario;
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String correo;
	private Date fechaNacimiento;
	private String imagenPerfil;


	public CreateUsuarioDTO() {
	}


	public CreateUsuarioDTO(String uidUsuario, String nombre, String apellidos, String nombreUsuario, String correo,
			Date fechaNacimiento, String imagenPerfil) {
		super();
		this.uidUsuario = uidUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.imagenPerfil = imagenPerfil;
	}

	public String getUidUsuario() {
		return uidUsuario;
	}

	public void setUidUsuario(String uidUsuario) {
		this.uidUsuario = uidUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getImagenPerfil() {
		return imagenPerfil;
	}

	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}
	

}
