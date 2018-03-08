/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.entities;

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
 * @author ianfrancoconcha
 */
@Entity
@Table(name = "modelo_marca_bus", catalog = "sigf", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeloMarcaBus.findAll", query = "SELECT m FROM ModeloMarcaBus m")
    , @NamedQuery(name = "ModeloMarcaBus.findByModeloMarcaBusId", query = "SELECT m FROM ModeloMarcaBus m WHERE m.modeloMarcaBusId = :modeloMarcaBusId")
    , @NamedQuery(name = "ModeloMarcaBus.findByModeloMarcaBusNombre", query = "SELECT m FROM ModeloMarcaBus m WHERE m.modeloMarcaBusNombre = :modeloMarcaBusNombre")
    })
public class ModeloMarcaBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "modelo_marca_bus_id")
    private Integer modeloMarcaBusId;
    @Basic(optional = false)
    @Column(name = "modelo_marca_bus_nombre")
    private String modeloMarcaBusNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busIdModelo")
    private List<Bus> busList;
    @JoinColumn(name = "modelo_marca_bus_id_marca", referencedColumnName = "marca_bus_id")
    @ManyToOne(optional = false)
    private MarcaBus modeloMarcaBusIdMarca;

    public ModeloMarcaBus() {
    }

    public ModeloMarcaBus(Integer modeloMarcaBusId) {
        this.modeloMarcaBusId = modeloMarcaBusId;
    }

    public ModeloMarcaBus(Integer modeloMarcaBusId, String modeloMarcaBusNombre) {
        this.modeloMarcaBusId = modeloMarcaBusId;
        this.modeloMarcaBusNombre = modeloMarcaBusNombre;
    }

    public Integer getModeloMarcaBusId() {
        return modeloMarcaBusId;
    }

    public void setModeloMarcaBusId(Integer modeloMarcaBusId) {
        this.modeloMarcaBusId = modeloMarcaBusId;
    }

    public String getModeloMarcaBusNombre() {
        return modeloMarcaBusNombre;
    }

    public void setModeloMarcaBusNombre(String modeloMarcaBusNombre) {
        this.modeloMarcaBusNombre = modeloMarcaBusNombre;
    }

    @XmlTransient
    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public MarcaBus getModeloMarcaBusIdMarca() {
        return modeloMarcaBusIdMarca;
    }

    public void setModeloMarcaBusIdMarca(MarcaBus modeloMarcaBusIdMarca) {
        this.modeloMarcaBusIdMarca = modeloMarcaBusIdMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modeloMarcaBusId != null ? modeloMarcaBusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloMarcaBus)) {
            return false;
        }
        ModeloMarcaBus other = (ModeloMarcaBus) object;
        if ((this.modeloMarcaBusId == null && other.modeloMarcaBusId != null) || (this.modeloMarcaBusId != null && !this.modeloMarcaBusId.equals(other.modeloMarcaBusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.nanduappgm.entities.ModeloMarcaBus[ modeloMarcaBusId=" + modeloMarcaBusId + " ]";
    }
    
}
