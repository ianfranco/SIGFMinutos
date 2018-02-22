/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.models;

import com.areatecnica.nanduappgm.dao.IProcesoRecaudacionDao;
import com.areatecnica.nanduappgm.dao.impl.IProcesoRecaudacionDaoImpl;
import com.areatecnica.nanduappgm.entities.ProcesoRecaudacion;

/**
 *
 * @author ianfrancoconcha
 */
public class ProcesoRecaudacionSolyMar {
    
    private ProcesoRecaudacion proceso; 
    private IProcesoRecaudacionDao dao; 

    public ProcesoRecaudacionSolyMar() {
        init();
    }
    
    public void init(){
        this.dao = new IProcesoRecaudacionDaoImpl();
        setProceso(this.dao.findById(2));
    }

    public ProcesoRecaudacion getProceso() {
        return proceso;
    }

    public void setProceso(ProcesoRecaudacion proceso) {
        this.proceso = proceso;
    }
    
    
}
