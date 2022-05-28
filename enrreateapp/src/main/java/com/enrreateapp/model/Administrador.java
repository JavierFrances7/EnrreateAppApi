/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enrreateapp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByUidAdministrador", query = "SELECT a FROM Administrador a WHERE a.uidAdministrador = :uidAdministrador"),
    @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Administrador.findByCorreo", query = "SELECT a FROM Administrador a WHERE a.correo = :correo"),
    @NamedQuery(name = "Administrador.findByDisplayName", query = "SELECT a FROM Administrador a WHERE a.displayName = :displayName")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uid_administrador")
    private String uidAdministrador;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Column(name = "display_name")
    private String displayName;

    public Administrador() {
    }

    public Administrador(String uidAdministrador) {
        this.uidAdministrador = uidAdministrador;
    }

    public Administrador(String uidAdministrador, String nombre, String correo) {
        this.uidAdministrador = uidAdministrador;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getUidAdministrador() {
        return uidAdministrador;
    }

    public void setUidAdministrador(String uidAdministrador) {
        this.uidAdministrador = uidAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uidAdministrador != null ? uidAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.uidAdministrador == null && other.uidAdministrador != null) || (this.uidAdministrador != null && !this.uidAdministrador.equals(other.uidAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.Administrador[ uidAdministrador=" + uidAdministrador + " ]";
    }
    
}
