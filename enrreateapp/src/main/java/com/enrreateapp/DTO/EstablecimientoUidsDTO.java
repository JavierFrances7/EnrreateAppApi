package com.enrreateapp.DTO;

public class EstablecimientoUidsDTO {

	private String uidEstablecimiento;
	private String imagenPerfil;

	public EstablecimientoUidsDTO() {
	}

	public EstablecimientoUidsDTO(String uidEstablecimiento, String imagenPerfil) {
		super();
		this.uidEstablecimiento = uidEstablecimiento;
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

}
