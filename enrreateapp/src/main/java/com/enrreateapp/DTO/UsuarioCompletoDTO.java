package com.enrreateapp.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

public class UsuarioCompletoDTO {

	private String uidUsuario;
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String correo;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date fechaNacimiento;
	private String displayName;
	private String imagenPerfil;


	public UsuarioCompletoDTO() {
	}

	public UsuarioCompletoDTO(String uidUsuario, String nombre, String apellidos, String nombreUsuario, String correo,
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getImagenPerfil() {
		return imagenPerfil;
	}

	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}
	

}
