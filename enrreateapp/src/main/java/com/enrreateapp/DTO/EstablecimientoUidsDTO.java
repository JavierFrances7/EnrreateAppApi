package com.enrreateapp.DTO;

public class EstablecimientoUidsDTO {

	private String uidEstablecimiento;
	private String nombreEstablecimiento;
	private String imagenPerfil;

	public EstablecimientoUidsDTO() {
	}

	public EstablecimientoUidsDTO(String uidEstablecimiento, String nombreEstablecimiento, String imagenPerfil) {
		this.uidEstablecimiento = uidEstablecimiento;
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.imagenPerfil = imagenPerfil;
	}

	public String getUidEstablecimiento() {
		return uidEstablecimiento;
	}

	public void setUidEstablecimiento(String uidEstablecimiento) {
		this.uidEstablecimiento = uidEstablecimiento;
	}

	public String getImagenPerfil() {
		return imagenPerfil;
	}

	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}

	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

}
