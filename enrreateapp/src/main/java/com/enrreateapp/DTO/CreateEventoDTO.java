package com.enrreateapp.DTO;

import java.util.Date;

import com.enrreateapp.model.Establecimiento;

public class CreateEventoDTO {

	private String nombre;
	private int aforoMaximo;
	private Date fechaInicio;
	private Date fechaFin;
	private int edadMinima;
	private String tipoMusica;
	private Establecimiento establecimiento;
	

	public CreateEventoDTO() {
	}



	public CreateEventoDTO(String nombre, int aforoMaximo, Date fechaInicio, Date fechaFin, int edadMinima,
			String tipoMusica, Establecimiento establecimiento) {
		super();
		this.nombre = nombre;
		this.aforoMaximo = aforoMaximo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.edadMinima = edadMinima;
		this.tipoMusica = tipoMusica;
		this.establecimiento = establecimiento;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAforoMaximo() {
		return aforoMaximo;
	}


	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getEdadMinima() {
		return edadMinima;
	}


	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}


	public String getTipoMusica() {
		return tipoMusica;
	}


	public void setTipoMusica(String tipoMusica) {
		this.tipoMusica = tipoMusica;
	}



	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}



	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}


}
