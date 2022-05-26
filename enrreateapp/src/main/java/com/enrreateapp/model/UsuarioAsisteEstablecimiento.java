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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "usuario_asiste_establecimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioAsisteEstablecimiento.findAll", query = "SELECT u FROM UsuarioAsisteEstablecimiento u"),
    @NamedQuery(name = "UsuarioAsisteEstablecimiento.findByUidUsuario", query = "SELECT u FROM UsuarioAsisteEstablecimiento u WHERE u.usuarioAsisteEstablecimientoPK.uidUsuario = :uidUsuario"),
    @NamedQuery(name = "UsuarioAsisteEstablecimiento.findByUidEstablecimiento", query = "SELECT u FROM UsuarioAsisteEstablecimiento u WHERE u.usuarioAsisteEstablecimientoPK.uidEstablecimiento = :uidEstablecimiento"),
    @NamedQuery(name = "UsuarioAsisteEstablecimiento.findByFecha", query = "SELECT u FROM UsuarioAsisteEstablecimiento u WHERE u.fecha = :fecha")})
public class UsuarioAsisteEstablecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioAsisteEstablecimientoPK usuarioAsisteEstablecimientoPK;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "uid_establecimiento", referencedColumnName = "uid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Establecimiento establecimiento;
    @JoinColumn(name = "uid_usuario", referencedColumnName = "uid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioAsisteEstablecimiento() {
    }

    public UsuarioAsisteEstablecimiento(UsuarioAsisteEstablecimientoPK usuarioAsisteEstablecimientoPK) {
        this.usuarioAsisteEstablecimientoPK = usuarioAsisteEstablecimientoPK;
    }

    public UsuarioAsisteEstablecimiento(UsuarioAsisteEstablecimientoPK usuarioAsisteEstablecimientoPK, Date fecha) {
        this.usuarioAsisteEstablecimientoPK = usuarioAsisteEstablecimientoPK;
        this.fecha = fecha;
    }

    public UsuarioAsisteEstablecimiento(String uidUsuario, String uidEstablecimiento) {
        this.usuarioAsisteEstablecimientoPK = new UsuarioAsisteEstablecimientoPK(uidUsuario, uidEstablecimiento);
    }

    public UsuarioAsisteEstablecimientoPK getUsuarioAsisteEstablecimientoPK() {
        return usuarioAsisteEstablecimientoPK;
    }

    public void setUsuarioAsisteEstablecimientoPK(UsuarioAsisteEstablecimientoPK usuarioAsisteEstablecimientoPK) {
        this.usuarioAsisteEstablecimientoPK = usuarioAsisteEstablecimientoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioAsisteEstablecimientoPK != null ? usuarioAsisteEstablecimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioAsisteEstablecimiento)) {
            return false;
        }
        UsuarioAsisteEstablecimiento other = (UsuarioAsisteEstablecimiento) object;
        if ((this.usuarioAsisteEstablecimientoPK == null && other.usuarioAsisteEstablecimientoPK != null) || (this.usuarioAsisteEstablecimientoPK != null && !this.usuarioAsisteEstablecimientoPK.equals(other.usuarioAsisteEstablecimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.UsuarioAsisteEstablecimiento[ usuarioAsisteEstablecimientoPK=" + usuarioAsisteEstablecimientoPK + " ]";
    }
    
}
