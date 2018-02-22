/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.dao;

import com.areatecnica.nanduappgm.entities.Bus;
import com.areatecnica.nanduappgm.entities.EstadoBus;
import com.areatecnica.nanduappgm.entities.Flota;
import com.areatecnica.nanduappgm.entities.GrupoServicio;
import com.areatecnica.nanduappgm.entities.ProcesoRecaudacion;
import com.areatecnica.nanduappgm.entities.Terminal;
import com.areatecnica.nanduappgm.entities.UnidadNegocio;
import java.util.List;

/**
 *
 * @author ianfr
 */
public interface IBusDao<T> extends IGenericDAO<T> {
    
    public int findMaxNumeroUnidad(UnidadNegocio unidadNegocio);
    
    public List<Bus> findByUnidad(UnidadNegocio unidadNegocio);
    
    public List<Bus> findByFlotaAndUnidad(Flota flota, UnidadNegocio unidadNegocio);
        
    public List<Bus> findByFlota(Flota flota);
    
    public List<Bus> findByProceso(ProcesoRecaudacion procesoRecaudacion);
    
    public List<Bus> findByGrupoServicio(GrupoServicio grupoServicio);
    
    public List<Bus> findByTerminal(Terminal terminal);
    
    public Bus findDefaultBus(EstadoBus estadoBus);
    
    public Bus findByNumeroBus(int numero);
    
    public Bus findByNumeroBusProceso(int numero, ProcesoRecaudacion procesoRecaudacion);
}
