package com.enrreateapp.DTO;

public class EstablecimientoCompletoDTO {

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
	private int aforoActual;
	private boolean verificadoAdmin;


	public EstablecimientoCompletoDTO() {
	}

	public EstablecimientoCompletoDTO(String uidEstablecimiento, String nombreEstablecimiento, String nombreGestor,
			String correo, float latitud, float longitud, String ciudad, String direccion, int aforoMaximo,
			float valoracionMedia, int aforoActual, boolean verificadoAdmin) {
		super();
		this.uidEstablecimiento = uidEstablecimiento;
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.nombreGestor = nombreGestor;
		this.correo = correo;
		this.latitud = latitud;
		this.longitud = longitud;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.aforoMaximo = aforoMaximo;
		this.valoracionMedia = valoracionMedia;
		this.aforoActual = aforoActual;
		this.verificadoAdmin = verificadoAdmin;
	}

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

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getAforoMaximo() {
		return aforoMaximo;
	}

	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}

	public float getValoracionMedia() {
		return valoracionMedia;
	}

	public void setValoracionMedia(float valoracionMedia) {
		this.valoracionMedia = valoracionMedia;
	}

	public int getAforoActual() {
		return aforoActual;
	}

	public void setAforoActual(int aforoActual) {
		this.aforoActual = aforoActual;
	}

	public boolean isVerificadoAdmin() {
		return verificadoAdmin;
	}

	public void setVerificadoAdmin(boolean verificadoAdmin) {
		this.verificadoAdmin = verificadoAdmin;
	}

	
}
