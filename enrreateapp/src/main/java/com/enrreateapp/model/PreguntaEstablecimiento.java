/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enrreateapp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "pregunta_establecimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaEstablecimiento.findAll", query = "SELECT p FROM PreguntaEstablecimiento p"),
    @NamedQuery(name = "PreguntaEstablecimiento.findByIdPregunta", query = "SELECT p FROM PreguntaEstablecimiento p WHERE p.idPregunta = :idPregunta"),
    @NamedQuery(name = "PreguntaEstablecimiento.findByFecha", query = "SELECT p FROM PreguntaEstablecimiento p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PreguntaEstablecimiento.findByRespuesta", query = "SELECT p FROM PreguntaEstablecimiento p WHERE p.respuesta = :respuesta"),
    @NamedQuery(name = "PreguntaEstablecimiento.findByPregunta", query = "SELECT p FROM PreguntaEstablecimiento p WHERE p.pregunta = :pregunta")})
public class PreguntaEstablecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pregunta")
    private Integer idPregunta;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "respuesta")
    private String respuesta;
    @Basic(optional = false)
    @Column(name = "pregunta")
    private String pregunta;
    @JoinColumn(name = "uid_establecimiento", referencedColumnName = "uid_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento uidEstablecimiento;
    @JoinColumn(name = "uid_usuario", referencedColumnName = "uid_usuario")
    @ManyToOne(optional = false)
    private Usuario uidUsuario;

    public PreguntaEstablecimiento() {
    }

    public PreguntaEstablecimiento(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public PreguntaEstablecimiento(Integer idPregunta, String pregunta) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Establecimiento getUidEstablecimiento() {
        return uidEstablecimiento;
    }

    public void setUidEstablecimiento(Establecimiento uidEstablecimiento) {
        this.uidEstablecimiento = uidEstablecimiento;
    }

    public Usuario getUidUsuario() {
        return uidUsuario;
    }

    public void setUidUsuario(Usuario uidUsuario) {
        this.uidUsuario = uidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaEstablecimiento)) {
            return false;
        }
        PreguntaEstablecimiento other = (PreguntaEstablecimiento) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.PreguntaEstablecimiento[ idPregunta=" + idPregunta + " ]";
    }
    
}
