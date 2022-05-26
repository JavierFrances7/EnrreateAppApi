/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enrreateapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUid", query = "SELECT u FROM Usuario u WHERE u.uid = :uid"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuario.findByDisplayName", query = "SELECT u FROM Usuario u WHERE u.displayName = :displayName")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uid")
    private String uid;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "display_name")
    private String displayName;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Evento> eventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uidUsuario")
    private List<ComentarioEvento> comentarioEventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioValoraEstablecimiento> usuarioValoraEstablecimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uidUsuario")
    private List<ComentarioEstablecimiento> comentarioEstablecimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioAsisteEstablecimiento> usuarioAsisteEstablecimientoList;

    public Usuario() {
    }

    public Usuario(String uid) {
        this.uid = uid;
    }

    public Usuario(String uid, String nombre, String apellidos, String nombreUsuario, String correo, Date fechaNacimiento) {
        this.uid = uid;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<ComentarioEvento> getComentarioEventoList() {
        return comentarioEventoList;
    }

    public void setComentarioEventoList(List<ComentarioEvento> comentarioEventoList) {
        this.comentarioEventoList = comentarioEventoList;
    }

    @XmlTransient
    public List<UsuarioValoraEstablecimiento> getUsuarioValoraEstablecimientoList() {
        return usuarioValoraEstablecimientoList;
    }

    public void setUsuarioValoraEstablecimientoList(List<UsuarioValoraEstablecimiento> usuarioValoraEstablecimientoList) {
        this.usuarioValoraEstablecimientoList = usuarioValoraEstablecimientoList;
    }

    @XmlTransient
    public List<ComentarioEstablecimiento> getComentarioEstablecimientoList() {
        return comentarioEstablecimientoList;
    }

    public void setComentarioEstablecimientoList(List<ComentarioEstablecimiento> comentarioEstablecimientoList) {
        this.comentarioEstablecimientoList = comentarioEstablecimientoList;
    }

    @XmlTransient
    public List<UsuarioAsisteEstablecimiento> getUsuarioAsisteEstablecimientoList() {
        return usuarioAsisteEstablecimientoList;
    }

    public void setUsuarioAsisteEstablecimientoList(List<UsuarioAsisteEstablecimiento> usuarioAsisteEstablecimientoList) {
        this.usuarioAsisteEstablecimientoList = usuarioAsisteEstablecimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.Usuario[ uid=" + uid + " ]";
    }
    
}
