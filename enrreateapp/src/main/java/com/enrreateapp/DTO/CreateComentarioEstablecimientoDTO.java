package com.enrreateapp.DTO;

import java.util.Date;

import com.enrreateapp.model.Establecimiento;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateComentarioEstablecimientoDTO {

	private String idComentario;
	private Date fecha;
	private String comentario;
	private EstablecimientoUidsDTO establecimiento;
	private UsuarioUidsDTO usuario;

	public CreateComentarioEstablecimientoDTO() {
	}

	public CreateComentarioEstablecimientoDTO(String idComentario, Date fecha, String comentario,
			EstablecimientoUidsDTO establecimiento, UsuarioUidsDTO usuario) {
		super();
		this.idComentario = idComentario;
		this.fecha = fecha;
		this.comentario = comentario;
		this.establecimiento = establecimiento;
		this.usuario = usuario;
	}

	public String getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(String idComentario) {
		this.idComentario = idComentario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
