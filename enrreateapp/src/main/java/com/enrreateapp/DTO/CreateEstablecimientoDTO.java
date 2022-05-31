package com.enrreateapp.DTO;

public class CreateEstablecimientoDTO {

	private String uidEstablecimiento;
	private String nombreEstablecimiento;
	private String nombreGestor;
	private String correo;
	private boolean verificadoAdmin;
	
	public String getUidEstablecimiento() {
		return uidEstablecimiento;
	}
	public void setUidEstablecimiento(String uidEstablecimiento) {
		this.uidEstablecimiento = uidEstablecimiento;
	}
	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}
	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}
	public String getNombreGestor() {
		return nombreGestor;
	}
	public void setNombreGestor(String nombreGestor) {
		this.nombreGestor = nombreGestor;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public boolean isVerificadoAdmin() {
		return verificadoAdmin;
	}
	public void setVerificadoAdmin(boolean verificadoAdmin) {
		this.verificadoAdmin = verificadoAdmin;
	}
	
	
	
}
