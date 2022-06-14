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
@Table(name = "comentario_establecimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioEstablecimiento.findAll", query = "SELECT c FROM ComentarioEstablecimiento c"),
    @NamedQuery(name = "ComentarioEstablecimiento.findByIdComentario", query = "SELECT c FROM ComentarioEstablecimiento c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "ComentarioEstablecimiento.findByFecha", query = "SELECT c FROM ComentarioEstablecimiento c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "ComentarioEstablecimiento.findByComentario", query = "SELECT c FROM ComentarioEstablecimiento c WHERE c.comentario = :comentario")})
public class ComentarioEstablecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_comentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "uid_establecimiento", referencedColumnName = "uid_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento uidEstablecimiento;
    @JoinColumn(name = "uid_usuario", referencedColumnName = "uid_usuario")
    @ManyToOne(optional = false)
    private Usuario uidUsuario;

    public ComentarioEstablecimiento() {
    }

    public ComentarioEstablecimiento(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public ComentarioEstablecimiento(Integer idComentario, Date fecha, String comentario) {
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
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioEstablecimiento)) {
            return false;
        }
        ComentarioEstablecimiento other = (ComentarioEstablecimiento) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.ComentarioEstablecimiento[ idComentario=" + idComentario + " ]";
    }
    
}
