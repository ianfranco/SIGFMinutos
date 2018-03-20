/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author ianfrancoconcha
 */
@Entity
@Table(name = "registro_minuto", catalog = "sigf", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroMinuto.findAll", query = "SELECT r FROM RegistroMinuto r")
    , @NamedQuery(name = "RegistroMinuto.findByRegistroMinutoId", query = "SELECT r FROM RegistroMinuto r WHERE r.registroMinutoId = :registroMinutoId")
    , @NamedQuery(name = "RegistroMinuto.findByRegistroMinutoFechaMinuto", query = "SELECT r FROM RegistroMinuto r WHERE r.registroMinutoFechaMinuto = :registroMinutoFechaMinuto")
    , @NamedQuery(name = "RegistroMinuto.findByRegistroMinutoCantidad", query = "SELECT r FROM RegistroMinuto r WHERE r.registroMinutoCantidad = :registroMinutoCantidad")
    , @NamedQuery(name = "RegistroMinuto.findByRegistroMinutoMonto", query = "SELECT r FROM RegistroMinuto r WHERE r.registroMinutoMonto = :registroMinutoMonto")
    , @NamedQuery(name = "RegistroMinuto.findByRegistroMinutoRecaudado", query = "SELECT r FROM RegistroMinuto r WHERE r.registroMinutoRecaudado = :registroMinutoRecaudado")
    })
public class RegistroMinuto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "registro_minuto_id")
    private Integer registroMinutoId;
    @Basic(optional = false)
    @Column(name = "registro_minuto_fecha_minuto")
    @Temporal(TemporalType.DATE)
    private Date registroMinutoFechaMinuto;
    @Column(name = "registro_minuto_cantidad")
    private Integer registroMinutoCantidad;
    @Basic(optional = false)
    @Column(name = "registro_minuto_monto")
    private int registroMinutoMonto;
    @Basic(optional = false)
    @Column(name = "registro_minuto_recaudado")
    private boolean registroMinutoRecaudado;
    @JoinColumn(name = "registro_minuto_desde_id_bus", referencedColumnName = "bus_id")
    @ManyToOne(optional = false)
    private Bus registroMinutoDesdeIdBus;
    @JoinColumn(name = "registro_minuto_hasta_id_bus", referencedColumnName = "bus_id")
    @ManyToOne(optional = false)
    private Bus registroMinutoHastaIdBus;

    public RegistroMinuto() {
    }

    public RegistroMinuto(Integer registroMinutoId) {
        this.registroMinutoId = registroMinutoId;
    }

    public RegistroMinuto(Integer registroMinutoId, Date registroMinutoFechaMinuto, int registroMinutoMonto, boolean registroMinutoRecaudado) {
        this.registroMinutoId = registroMinutoId;
        this.registroMinutoFechaMinuto = registroMinutoFechaMinuto;
        this.registroMinutoMonto = registroMinutoMonto;
        this.registroMinutoRecaudado = registroMinutoRecaudado;
    }

    public Integer getRegistroMinutoId() {
        return registroMinutoId;
    }

    public void setRegistroMinutoId(Integer registroMinutoId) {
        this.registroMinutoId = registroMinutoId;
    }

    public Date getRegistroMinutoFechaMinuto() {
        return registroMinutoFechaMinuto;
    }

    public void setRegistroMinutoFechaMinuto(Date registroMinutoFechaMinuto) {
        this.registroMinutoFechaMinuto = registroMinutoFechaMinuto;
    }

    public Integer getRegistroMinutoCantidad() {
        return registroMinutoCantidad;
    }

    public void setRegistroMinutoCantidad(Integer registroMinutoCantidad) {
        this.registroMinutoCantidad = registroMinutoCantidad;
    }

    public int getRegistroMinutoMonto() {
        return registroMinutoMonto;
    }

    public void setRegistroMinutoMonto(int registroMinutoMonto) {
        this.registroMinutoMonto = registroMinutoMonto;
    }

    public boolean getRegistroMinutoRecaudado() {
        return registroMinutoRecaudado;
    }

    public void setRegistroMinutoRecaudado(boolean registroMinutoRecaudado) {
        this.registroMinutoRecaudado = registroMinutoRecaudado;
    }

    public Bus getRegistroMinutoDesdeIdBus() {
        return registroMinutoDesdeIdBus;
    }

    public void setRegistroMinutoDesdeIdBus(Bus registroMinutoDesdeIdBus) {
        this.registroMinutoDesdeIdBus = registroMinutoDesdeIdBus;
    }

    public Bus getRegistroMinutoHastaIdBus() {
        return registroMinutoHastaIdBus;
    }

    public void setRegistroMinutoHastaIdBus(Bus registroMinutoHastaIdBus) {
        this.registroMinutoHastaIdBus = registroMinutoHastaIdBus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroMinutoId != null ? registroMinutoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroMinuto)) {
            return false;
        }
        RegistroMinuto other = (RegistroMinuto) object;
        if ((this.registroMinutoId == null && other.registroMinutoId != null) || (this.registroMinutoId != null && !this.registroMinutoId.equals(other.registroMinutoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.nanduappgm.entities.RegistroMinuto[ registroMinutoId=" + registroMinutoId + " ]";
    }
    
}
