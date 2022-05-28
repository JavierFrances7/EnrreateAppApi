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
@Table(name = "comentario_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioEvento.findAll", query = "SELECT c FROM ComentarioEvento c"),
    @NamedQuery(name = "ComentarioEvento.findByIdComentario", query = "SELECT c FROM ComentarioEvento c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "ComentarioEvento.findByFecha", query = "SELECT c FROM ComentarioEvento c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "ComentarioEvento.findByComentario", query = "SELECT c FROM ComentarioEvento c WHERE c.comentario = :comentario")})
public class ComentarioEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private Integer idComentario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
    @ManyToOne(optional = false)
    private Evento idEvento;
    @JoinColumn(name = "uid_usuario", referencedColumnName = "uid_usuario")
    @ManyToOne(optional = false)
    private Usuario uidUsuario;

    public ComentarioEvento() {
    }

    public ComentarioEvento(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public ComentarioEvento(Integer idComentario, Date fecha, String comentario) {
        this.idComentario = idComentario;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
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

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
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
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioEvento)) {
            return false;
        }
        ComentarioEvento other = (ComentarioEvento) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.ComentarioEvento[ idComentario=" + idComentario + " ]";
    }
    
}
