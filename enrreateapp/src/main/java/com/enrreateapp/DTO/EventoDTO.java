package com.enrreateapp.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventoDTO {

	private String idEvento;
	private String nombre;
	private int aforoMaximo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaInicio;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaFin;
	private int edadMinima;
	private String tipoMusica;
	private EstablecimientoUidsDTO uidEstablecimiento;

	public EventoDTO() {
	}

	public EventoDTO(String idEvento, String nombre, int aforoMaximo, Date fechaInicio, Date fechaFin, int edadMinima,
			String tipoMusica, EstablecimientoUidsDTO uidEstablecimiento) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.aforoMaximo = aforoMaximo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.edadMinima = edadMinima;
		this.tipoMusica = tipoMusica;
		this.uidEstablecimiento = uidEstablecimiento;
	}


	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
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

	public EstablecimientoUidsDTO getUidEstablecimiento() {
		return uidEstablecimiento;
	}

	public void setUidEstablecimiento(EstablecimientoUidsDTO uidEstablecimiento) {
		this.uidEstablecimiento = uidEstablecimiento;
	}
	
}
