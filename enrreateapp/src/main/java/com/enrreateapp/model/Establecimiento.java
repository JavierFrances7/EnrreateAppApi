/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enrreateapp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "establecimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Establecimiento.findAll", query = "SELECT e FROM Establecimiento e"),
    @NamedQuery(name = "Establecimiento.findByUidEstablecimiento", query = "SELECT e FROM Establecimiento e WHERE e.uidEstablecimiento = :uidEstablecimiento"),
    @NamedQuery(name = "Establecimiento.findByNombreEstablecimiento", query = "SELECT e FROM Establecimiento e WHERE e.nombreEstablecimiento = :nombreEstablecimiento"),
    @NamedQuery(name = "Establecimiento.findByNombreGestor", query = "SELECT e FROM Establecimiento e WHERE e.nombreGestor = :nombreGestor"),
    @NamedQuery(name = "Establecimiento.findByCorreo", query = "SELECT e FROM Establecimiento e WHERE e.correo = :correo"),
    @NamedQuery(name = "Establecimiento.findByVerificadoAdmin", query = "SELECT e FROM Establecimiento e WHERE e.verificadoAdmin = :verificadoAdmin"),
    @NamedQuery(name = "Establecimiento.findByDisplayName", query = "SELECT e FROM Establecimiento e WHERE e.displayName = :displayName"),
    @NamedQuery(name = "Establecimiento.findByLatitud", query = "SELECT e FROM Establecimiento e WHERE e.latitud = :latitud"),
    @NamedQuery(name = "Establecimiento.findByLongitud", query = "SELECT e FROM Establecimiento e WHERE e.longitud = :longitud"),
    @NamedQuery(name = "Establecimiento.findByCiudad", query = "SELECT e FROM Establecimiento e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Establecimiento.findByDireccion", query = "SELECT e FROM Establecimiento e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Establecimiento.findByAforoMaximo", query = "SELECT e FROM Establecimiento e WHERE e.aforoMaximo = :aforoMaximo"),
    @NamedQuery(name = "Establecimiento.findByValoracionMedia", query = "SELECT e FROM Establecimiento e WHERE e.valoracionMedia = :valoracionMedia")})
public class Establecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uid_establecimiento")
    private String uidEstablecimiento;
    @Basic(optional = false)
    @Column(name = "nombre_establecimiento")
    private String nombreEstablecimiento;
    @Basic(optional = false)
    @Column(name = "nombre_gestor")
    private String nombreGestor;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "verificado_admin")
    private short verificadoAdmin;
    @Column(name = "display_name")
    private String displayName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Float latitud;
    @Column(name = "longitud")
    private Float longitud;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "aforo_maximo")
    private Integer aforoMaximo;
    @Column(name = "valoracion_media")
    private Float valoracionMedia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uidEstablecimiento")
    private List<Evento> eventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "establecimiento")
    private List<UsuarioValoraEstablecimiento> usuarioValoraEstablecimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uidEstablecimiento")
    private List<ComentarioEstablecimiento> comentarioEstablecimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "establecimiento")
    private List<UsuarioAsisteEstablecimiento> usuarioAsisteEstablecimientoList;

    public Establecimiento() {
    }

    public Establecimiento(String uidEstablecimiento) {
        this.uidEstablecimiento = uidEstablecimiento;
    }

    public Establecimiento(String uidEstablecimiento, String nombreEstablecimiento, String nombreGestor, String correo, short verificadoAdmin) {
        this.uidEstablecimiento = uidEstablecimiento;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.nombreGestor = nombreGestor;
        this.correo = correo;
        this.verificadoAdmin = verificadoAdmin;
    }

    public String getUidEstablecimiento() {
        return uidEstablecimiento;
    }

    public void setUidEstablecimiento(String uidEstablecimiento) {
        this.uidEstablecimiento = uidEstablecimiento;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getNombreGestor() {
        return nombreGestor;
    }

    public void setNombreGestor(String nombreGestor) {
        this.nombreGestor = nombreGestor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public short getVerificadoAdmin() {
        return verificadoAdmin;
    }

    public void setVerificadoAdmin(short verificadoAdmin) {
        this.verificadoAdmin = verificadoAdmin;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(Integer aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public Float getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(Float valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
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
        hash += (uidEstablecimiento != null ? uidEstablecimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Establecimiento)) {
            return false;
        }
        Establecimiento other = (Establecimiento) object;
        if ((this.uidEstablecimiento == null && other.uidEstablecimiento != null) || (this.uidEstablecimiento != null && !this.uidEstablecimiento.equals(other.uidEstablecimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.Establecimiento[ uidEstablecimiento=" + uidEstablecimiento + " ]";
    }
    
}
