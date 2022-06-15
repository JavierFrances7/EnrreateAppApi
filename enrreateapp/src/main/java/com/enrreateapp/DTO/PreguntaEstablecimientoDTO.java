package com.enrreateapp.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PreguntaEstablecimientoDTO {

	private String idPregunta;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	private String pregunta;
	private String respuesta;
	private EstablecimientoUidsDTO uidEstablecimiento;
	private UsuarioUidsDTO uidUsuario;



	public PreguntaEstablecimientoDTO() {
	}


	public PreguntaEstablecimientoDTO(String idPregunta, Date fecha, String pregunta, String respuesta,
			EstablecimientoUidsDTO uidEstablecimiento, UsuarioUidsDTO uidUsuario) {
		super();
		this.idPregunta = idPregunta;
		this.fecha = fecha;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.uidEstablecimiento = uidEstablecimiento;
		this.uidUsuario = uidUsuario;
	}


	public String getIdPregunta() {
		return idPregunta;
	}


	public void setIdPregunta(String idPregunta) {
		this.idPregunta = idPregunta;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
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


	public EstablecimientoUidsDTO getUidEstablecimiento() {
		return uidEstablecimiento;
	}


	public void setUidEstablecimiento(EstablecimientoUidsDTO uidEstablecimiento) {
		this.uidEstablecimiento = uidEstablecimiento;
	}


	public UsuarioUidsDTO getUidUsuario() {
		return uidUsuario;
	}


	public void setUidUsuario(UsuarioUidsDTO uidUsuario) {
		this.uidUsuario = uidUsuario;
	}


	
}
