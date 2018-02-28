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
@Table(name = "cuenta", catalog = "sigf", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByCuentaId", query = "SELECT c FROM Cuenta c WHERE c.cuentaId = :cuentaId")
    , @NamedQuery(name = "Cuenta.findByCuentaAdministrador", query = "SELECT c FROM Cuenta c WHERE c.cuentaAdministrador = :cuentaAdministrador")
    , @NamedQuery(name = "Cuenta.findByCuentaRut", query = "SELECT c FROM Cuenta c WHERE c.cuentaRut = :cuentaRut")
    , @NamedQuery(name = "Cuenta.findByCuentaActiva", query = "SELECT c FROM Cuenta c WHERE c.cuentaActiva = :cuentaActiva")
    , @NamedQuery(name = "Cuenta.findByCuentaFechaIngreso", query = "SELECT c FROM Cuenta c WHERE c.cuentaFechaIngreso = :cuentaFechaIngreso")
    , @NamedQuery(name = "Cuenta.findByLastUpdate", query = "SELECT c FROM Cuenta c WHERE c.lastUpdate = :lastUpdate")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cuenta_id")
    private Integer cuentaId;
    @Basic(optional = false)
    @Column(name = "cuenta_administrador")
    private String cuentaAdministrador;
    @Basic(optional = false)
    @Column(name = "cuenta_rut")
    private String cuentaRut;
    @Basic(optional = false)
    @Column(name = "cuenta_activa")
    private boolean cuentaActiva;
    @Basic(optional = false)
    @Column(name = "cuenta_fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cuentaFechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadNegocioIdCuenta")
    private List<UnidadNegocio> unidadNegocioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaCompensacionIdCuenta")
    private List<CajaCompensacion> cajaCompensacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representanteLegalIdCuenta")
    private List<RepresentanteLegal> representanteLegalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flotaIdCuenta")
    private List<Flota> flotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoServicioIdCuenta")
    private List<GrupoServicio> grupoServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminalIdCuenta")
    private List<Terminal> terminalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesoRecaudacionIdCuenta")
    private List<ProcesoRecaudacion> procesoRecaudacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mutualIdCuenta")
    private List<Mutual> mutualList;
    @JoinColumn(name = "cuenta_id_tipo", referencedColumnName = "tipo_cuenta_id")
    @ManyToOne(optional = false)
    private TipoCuenta cuentaIdTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaIdCuenta")
    private List<Empresa> empresaList;

    public Cuenta() {
    }

    public Cuenta(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Cuenta(Integer cuentaId, String cuentaAdministrador, String cuentaRut, boolean cuentaActiva, Date cuentaFechaIngreso) {
        this.cuentaId = cuentaId;
        this.cuentaAdministrador = cuentaAdministrador;
        this.cuentaRut = cuentaRut;
        this.cuentaActiva = cuentaActiva;
        this.cuentaFechaIngreso = cuentaFechaIngreso;
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getCuentaAdministrador() {
        return cuentaAdministrador;
    }

    public void setCuentaAdministrador(String cuentaAdministrador) {
        this.cuentaAdministrador = cuentaAdministrador;
    }

    public String getCuentaRut() {
        return cuentaRut;
    }

    public void setCuentaRut(String cuentaRut) {
        this.cuentaRut = cuentaRut;
    }

    public boolean getCuentaActiva() {
        return cuentaActiva;
    }

    public void setCuentaActiva(boolean cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
    }

    public Date getCuentaFechaIngreso() {
        return cuentaFechaIngreso;
    }

    public void setCuentaFechaIngreso(Date cuentaFechaIngreso) {
        this.cuentaFechaIngreso = cuentaFechaIngreso;
    }
    
    @XmlTransient
    public List<UnidadNegocio> getUnidadNegocioList() {
        return unidadNegocioList;
    }

    public void setUnidadNegocioList(List<UnidadNegocio> unidadNegocioList) {
        this.unidadNegocioList = unidadNegocioList;
    }

    @XmlTransient
    public List<CajaCompensacion> getCajaCompensacionList() {
        return cajaCompensacionList;
    }

    public void setCajaCompensacionList(List<CajaCompensacion> cajaCompensacionList) {
        this.cajaCompensacionList = cajaCompensacionList;
    }

    @XmlTransient
    public List<RepresentanteLegal> getRepresentanteLegalList() {
        return representanteLegalList;
    }

    public void setRepresentanteLegalList(List<RepresentanteLegal> representanteLegalList) {
        this.representanteLegalList = representanteLegalList;
    }

    @XmlTransient
    public List<Flota> getFlotaList() {
        return flotaList;
    }

    public void setFlotaList(List<Flota> flotaList) {
        this.flotaList = flotaList;
    }

    @XmlTransient
    public List<GrupoServicio> getGrupoServicioList() {
        return grupoServicioList;
    }

    public void setGrupoServicioList(List<GrupoServicio> grupoServicioList) {
        this.grupoServicioList = grupoServicioList;
    }

    @XmlTransient
    public List<Terminal> getTerminalList() {
        return terminalList;
    }

    public void setTerminalList(List<Terminal> terminalList) {
        this.terminalList = terminalList;
    }

    @XmlTransient
    public List<ProcesoRecaudacion> getProcesoRecaudacionList() {
        return procesoRecaudacionList;
    }

    public void setProcesoRecaudacionList(List<ProcesoRecaudacion> procesoRecaudacionList) {
        this.procesoRecaudacionList = procesoRecaudacionList;
    }

    @XmlTransient
    public List<Mutual> getMutualList() {
        return mutualList;
    }

    public void setMutualList(List<Mutual> mutualList) {
        this.mutualList = mutualList;
    }

    public TipoCuenta getCuentaIdTipo() {
        return cuentaIdTipo;
    }

    public void setCuentaIdTipo(TipoCuenta cuentaIdTipo) {
        this.cuentaIdTipo = cuentaIdTipo;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaId != null ? cuentaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cuentaId == null && other.cuentaId != null) || (this.cuentaId != null && !this.cuentaId.equals(other.cuentaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.nanduappgm.entities.Cuenta[ cuentaId=" + cuentaId + " ]";
    }
    
}
