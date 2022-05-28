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
public class UsuarioAsisteEstablecimientoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "uid_usuario")
    private String uidUsuario;
    @Basic(optional = false)
    @Column(name = "uid_establecimiento")
    private String uidEstablecimiento;

    public UsuarioAsisteEstablecimientoPK() {
    }

    public UsuarioAsisteEstablecimientoPK(String uidUsuario, String uidEstablecimiento) {
        this.uidUsuario = uidUsuario;
        this.uidEstablecimiento = uidEstablecimiento;
    }

    public String getUidUsuario() {
        return uidUsuario;
    }

    public void setUidUsuario(String uidUsuario) {
        this.uidUsuario = uidUsuario;
    }

    public String getUidEstablecimiento() {
        return uidEstablecimiento;
    }

    public void setUidEstablecimiento(String uidEstablecimiento) {
        this.uidEstablecimiento = uidEstablecimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uidUsuario != null ? uidUsuario.hashCode() : 0);
        hash += (uidEstablecimiento != null ? uidEstablecimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioAsisteEstablecimientoPK)) {
            return false;
        }
        UsuarioAsisteEstablecimientoPK other = (UsuarioAsisteEstablecimientoPK) object;
        if ((this.uidUsuario == null && other.uidUsuario != null) || (this.uidUsuario != null && !this.uidUsuario.equals(other.uidUsuario))) {
            return false;
        }
        if ((this.uidEstablecimiento == null && other.uidEstablecimiento != null) || (this.uidEstablecimiento != null && !this.uidEstablecimiento.equals(other.uidEstablecimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.UsuarioAsisteEstablecimientoPK[ uidUsuario=" + uidUsuario + ", uidEstablecimiento=" + uidEstablecimiento + " ]";
    }
    
}
