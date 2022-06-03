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
public class UsuarioValoraEventoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "uid_usuario")
    private String uidUsuario;
    @Basic(optional = false)
    @Column(name = "id_evento")
    private int idEvento;

    public UsuarioValoraEventoPK() {
    }

    public UsuarioValoraEventoPK(String uidUsuario, int idEvento) {
        this.uidUsuario = uidUsuario;
        this.idEvento = idEvento;
    }

    public String getUidUsuario() {
        return uidUsuario;
    }

    public void setUidUsuario(String uidUsuario) {
        this.uidUsuario = uidUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uidUsuario != null ? uidUsuario.hashCode() : 0);
        hash += (int) idEvento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioValoraEventoPK)) {
            return false;
        }
        UsuarioValoraEventoPK other = (UsuarioValoraEventoPK) object;
        if ((this.uidUsuario == null && other.uidUsuario != null) || (this.uidUsuario != null && !this.uidUsuario.equals(other.uidUsuario))) {
            return false;
        }
        if (this.idEvento != other.idEvento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.UsuarioValoraEventoPK[ uidUsuario=" + uidUsuario + ", idEvento=" + idEvento + " ]";
    }
    
}
