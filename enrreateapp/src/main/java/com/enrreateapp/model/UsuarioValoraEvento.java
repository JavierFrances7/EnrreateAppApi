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
@Table(name = "usuario_valora_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioValoraEvento.findAll", query = "SELECT u FROM UsuarioValoraEvento u"),
    @NamedQuery(name = "UsuarioValoraEvento.findByUidUsuario", query = "SELECT u FROM UsuarioValoraEvento u WHERE u.usuarioValoraEventoPK.uidUsuario = :uidUsuario"),
    @NamedQuery(name = "UsuarioValoraEvento.findByIdEvento", query = "SELECT u FROM UsuarioValoraEvento u WHERE u.usuarioValoraEventoPK.idEvento = :idEvento"),
    @NamedQuery(name = "UsuarioValoraEvento.findByNota", query = "SELECT u FROM UsuarioValoraEvento u WHERE u.nota = :nota")})
public class UsuarioValoraEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioValoraEventoPK usuarioValoraEventoPK;
    @Basic(optional = false)
    @Column(name = "nota")
    private int nota;
    @JoinColumn(name = "id_evento", referencedColumnName = "id_evento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento;
    @JoinColumn(name = "uid_usuario", referencedColumnName = "uid_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioValoraEvento() {
    }

    public UsuarioValoraEvento(UsuarioValoraEventoPK usuarioValoraEventoPK) {
        this.usuarioValoraEventoPK = usuarioValoraEventoPK;
    }

    public UsuarioValoraEvento(UsuarioValoraEventoPK usuarioValoraEventoPK, int nota) {
        this.usuarioValoraEventoPK = usuarioValoraEventoPK;
        this.nota = nota;
    }

    public UsuarioValoraEvento(String uidUsuario, int idEvento) {
        this.usuarioValoraEventoPK = new UsuarioValoraEventoPK(uidUsuario, idEvento);
    }

    public UsuarioValoraEventoPK getUsuarioValoraEventoPK() {
        return usuarioValoraEventoPK;
    }

    public void setUsuarioValoraEventoPK(UsuarioValoraEventoPK usuarioValoraEventoPK) {
        this.usuarioValoraEventoPK = usuarioValoraEventoPK;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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
        hash += (usuarioValoraEventoPK != null ? usuarioValoraEventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioValoraEvento)) {
            return false;
        }
        UsuarioValoraEvento other = (UsuarioValoraEvento) object;
        if ((this.usuarioValoraEventoPK == null && other.usuarioValoraEventoPK != null) || (this.usuarioValoraEventoPK != null && !this.usuarioValoraEventoPK.equals(other.usuarioValoraEventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.UsuarioValoraEvento[ usuarioValoraEventoPK=" + usuarioValoraEventoPK + " ]";
    }
    
}
