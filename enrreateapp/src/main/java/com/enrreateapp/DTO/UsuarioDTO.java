package com.enrreateapp.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDTO {

	private String uidUsuario;
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String correo;
	private Date fechaNacimiento;

}
