/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enrreateapp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Javier
 */
@Embeddable
public class UsuarioValoraEstablecimientoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "usuario_uid")
    private String usuarioUid;
    @Basic(optional = false)
    @Column(name = "establecimiento_uid")
    private String establecimientoUid;

    public UsuarioValoraEstablecimientoPK() {
    }

    public UsuarioValoraEstablecimientoPK(String usuarioUid, String establecimientoUid) {
        this.usuarioUid = usuarioUid;
        this.establecimientoUid = establecimientoUid;
    }

    public String getUsuarioUid() {
        return usuarioUid;
    }

    public void setUsuarioUid(String usuarioUid) {
        this.usuarioUid = usuarioUid;
    }

    public String getEstablecimientoUid() {
        return establecimientoUid;
    }

    public void setEstablecimientoUid(String establecimientoUid) {
        this.establecimientoUid = establecimientoUid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioUid != null ? usuarioUid.hashCode() : 0);
        hash += (establecimientoUid != null ? establecimientoUid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioValoraEstablecimientoPK)) {
            return false;
        }
        UsuarioValoraEstablecimientoPK other = (UsuarioValoraEstablecimientoPK) object;
        if ((this.usuarioUid == null && other.usuarioUid != null) || (this.usuarioUid != null && !this.usuarioUid.equals(other.usuarioUid))) {
            return false;
        }
        if ((this.establecimientoUid == null && other.establecimientoUid != null) || (this.establecimientoUid != null && !this.establecimientoUid.equals(other.establecimientoUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.UsuarioValoraEstablecimientoPK[ usuarioUid=" + usuarioUid + ", establecimientoUid=" + establecimientoUid + " ]";
    }
    
}
