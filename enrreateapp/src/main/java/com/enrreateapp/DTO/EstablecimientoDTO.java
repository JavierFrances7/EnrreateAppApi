package com.enrreateapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstablecimientoDTO {

	private String uidEstablecimiento;
	private String nombreEstablecimiento;
	private String nombreGestor;
	private String correo;
	private float latitud;
	private float longitud;
	private String ciudad;
	private String direccion;
	private int aforoMaximo;
	private float valoracionMedia;

}
