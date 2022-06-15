package com.enrreateapp.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ComentarioEstablecimientoDTO {

	private String idComentario;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	private String comentario;
	private int nota;
	private EstablecimientoUidsDTO uidEstablecimiento;
	private UsuarioUidsDTO uidUsuario;



	public ComentarioEstablecimientoDTO() {
	}

	public ComentarioEstablecimientoDTO(String idComentario, Date fecha, String comentario, int nota,
			EstablecimientoUidsDTO uidEstablecimiento, UsuarioUidsDTO uidUsuario) {
		this.idComentario = idComentario;
		this.fecha = fecha;
		this.comentario = comentario;
		this.nota = nota;
		this.uidEstablecimiento = uidEstablecimiento;
		this.uidUsuario = uidUsuario;
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
