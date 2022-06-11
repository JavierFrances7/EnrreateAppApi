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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByAforoMaximo", query = "SELECT e FROM Evento e WHERE e.aforoMaximo = :aforoMaximo"),
    @NamedQuery(name = "Evento.findByFechaInicio", query = "SELECT e FROM Evento e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Evento.findByFechaFin", query = "SELECT e FROM Evento e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "Evento.findByEdadMinima", query = "SELECT e FROM Evento e WHERE e.edadMinima = :edadMinima"),
    @NamedQuery(name = "Evento.findByTipoMusica", query = "SELECT e FROM Evento e WHERE e.tipoMusica = :tipoMusica"),
    @NamedQuery(name = "Evento.findByNombre", query = "SELECT e FROM Evento e WHERE e.nombre = :nombre")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evento")
    private Integer idEvento;
    @Column(name = "aforo_maximo")
    private Integer aforoMaximo;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "edad_minima")
    private Integer edadMinima;
    @Column(name = "tipo_musica")
    private String tipoMusica;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<UsuarioValoraEvento> usuarioValoraEventoList;
    @JoinColumn(name = "uid_establecimiento", referencedColumnName = "uid_establecimiento")
    @ManyToOne(optional = false)
    private Establecimiento uidEstablecimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private List<ComentarioEvento> comentarioEventoList;

    public Evento() {
    }

    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Evento(Integer idEvento, Date fechaInicio, String nombre) {
        this.idEvento = idEvento;
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(Integer aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<UsuarioValoraEvento> getUsuarioValoraEventoList() {
        return usuarioValoraEventoList;
    }

    public void setUsuarioValoraEventoList(List<UsuarioValoraEvento> usuarioValoraEventoList) {
        this.usuarioValoraEventoList = usuarioValoraEventoList;
    }

    public Establecimiento getUidEstablecimiento() {
        return uidEstablecimiento;
    }

    public void setUidEstablecimiento(Establecimiento uidEstablecimiento) {
        this.uidEstablecimiento = uidEstablecimiento;
    }

    @XmlTransient
    public List<ComentarioEvento> getComentarioEventoList() {
        return comentarioEventoList;
    }

    public void setComentarioEventoList(List<ComentarioEvento> comentarioEventoList) {
        this.comentarioEventoList = comentarioEventoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enrreateapp.model.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
