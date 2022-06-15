package com.enrreateapp.DTO;

import java.util.Date;

import com.enrreateapp.model.Establecimiento;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CreatePreguntaEstablecimientoDTO {

	private int idPregunta;
	private String pregunta;
	private String respuesta;
	private Date fecha;
	private EstablecimientoUidsDTO establecimiento;
	private UsuarioUidsDTO usuario;

	public CreatePreguntaEstablecimientoDTO() {
	}

	public CreatePreguntaEstablecimientoDTO(int idPregunta, String pregunta, String respuesta, Date fecha,
			EstablecimientoUidsDTO establecimiento, UsuarioUidsDTO usuario) {
		super();
		this.idPregunta = idPregunta;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.fecha = fecha;
		this.establecimiento = establecimiento;
		this.usuario = usuario;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstablecimientoUidsDTO getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(EstablecimientoUidsDTO establecimiento) {
		this.establecimiento = establecimiento;
	}

	public UsuarioUidsDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioUidsDTO usuario) {
		this.usuario = usuario;
	}

}
