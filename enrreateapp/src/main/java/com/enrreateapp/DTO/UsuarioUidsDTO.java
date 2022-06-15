package com.enrreateapp.DTO;

public class UsuarioUidsDTO {

	private String uidUsuario;
	private String nombre;
	private String nombreUsuario;
	private String imagenPerfil;

	public UsuarioUidsDTO() {
	}

	public UsuarioUidsDTO(String uidUsuario, String nombre, String nombreUsuario, String imagenPerfil) {
		this.uidUsuario = uidUsuario;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.imagenPerfil = imagenPerfil;
	}

	public String getUidUsuario() {
		return uidUsuario;
	}

	public void setUidUsuario(String uidUsuario) {
		this.uidUsuario = uidUsuario;
	}

	public String getImagenPerfil() {
		return imagenPerfil;
	}

	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
