package com.enrreateapp.DTO;


public class UsuarioUidsDTO {
	
	private String uidUsuario;
	private String nombre;
	private String imagenPerfil;

	
	public UsuarioUidsDTO() {
	}

	public UsuarioUidsDTO(String uidUsuario, String nombre, String imagenPerfil) {
		this.uidUsuario = uidUsuario;
		this.nombre = nombre;
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

}
