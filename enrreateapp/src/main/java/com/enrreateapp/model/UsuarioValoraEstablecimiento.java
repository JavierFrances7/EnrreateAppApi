/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enrreateapp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "usuario_valora_establecimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioValoraEstablecimiento.findAll", query = "SELECT u FROM UsuarioValoraEstablecimiento u"),
    @NamedQuery(name = "UsuarioValoraEstablecimiento.findByUidUsuario", query = "SELECT u FROM UsuarioValoraEstablecimiento u WHERE u.usuarioValoraEstablecimientoPK.uidUsuario = :uidUsuario"),
    @NamedQuery(name = "UsuarioValoraEstablecimiento.findByUidEstablecimiento", query = "SELECT u FROM UsuarioValoraEstablecimiento u WHERE u.usuarioValoraEstablecimientoPK.uidEstablecimiento = :uidEstablecimiento"),
    @NamedQuery(name = "UsuarioValoraEstablecimiento.findByNota", query = "SELECT u FROM UsuarioValoraEstablecimiento u WHERE u.nota = :nota")})
public class UsuarioValoraEstablecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioValoraEstablecimientoPK usuarioValoraEstablecimientoPK;
    @Basic(optional = false)
    @Column(name = "nota")
    private String nota;
    @JoinColumn(name = "uid_establecimiento", referencedColumnName = "uid_establecimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Establecimiento establecimiento;
    @JoinColumn(name = "uid_usuario", referencedColumnName = "uid_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioValoraEstablecimiento() {
    }

    public UsuarioValoraEstablecimiento(UsuarioValoraEstablecimientoPK usuarioValoraEstablecimientoPK) {
        this.usuarioValoraEstablecimientoPK = usuarioValoraEstablecimientoPK;
    }

    public UsuarioValoraEstablecimiento(UsuarioValoraEstablecimientoPK usuarioValoraEstablecimientoPK, String nota) {
        this.usuarioValoraEstablecimientoPK = usuarioValoraEstablecimientoPK;
        this.nota = nota;
    }

    public UsuarioValoraEstablecimiento(String uidUsuario, String uidEstablecimiento) {
        this.usuarioValoraEstablecimientoPK = new UsuarioValoraEstablecimientoPK(uidUsuario, uidEstablecimiento);
    }

    public UsuarioValoraEstablecimientoPK getUsuarioValoraEstablecimientoPK() {
        return usuarioValoraEstablecimientoPK;
    }

    public void setUsuarioValoraEstablecimientoPK(UsuarioValoraEstablecimientoPK usuarioValoraEstablecimientoPK) {
        this.usuarioValoraEstablecimientoPK = usuarioValoraEstablecimientoPK;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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
        hash += (usuarioValoraEstablecimientoPK != null ? usuarioValoraEstablecimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioValoraEstablecimiento)) {
            return false;
        }
        UsuarioValoraEstablecimiento other = (UsuarioValoraEstablecimiento) object;
        if ((this.usuarioValoraEstablecimientoPK == null && other.usuarioValoraEstablecimientoPK != null) || (this.usuarioValoraEstablecimientoPK != null && !this.usuarioValoraEstablecimientoPK.equals(other.usuarioValoraEstablecimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.UsuarioValoraEstablecimiento[ usuarioValoraEstablecimientoPK=" + usuarioValoraEstablecimientoPK + " ]";
    }
    
}
