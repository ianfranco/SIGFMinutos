/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.dao.impl;

import com.areatecnica.nanduappgm.dao.IFlotaDao;
import com.areatecnica.nanduappgm.entities.Flota;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author ianfr
 */
public class FlotaDaoImpl extends GenericDAOImpl<Flota> implements IFlotaDao<Flota> {

    public FlotaDaoImpl() {
        super(Flota.class);
    }

    
    public List<Flota> findById(int id) {
        try {
            return this.entityManager.createNamedQuery("Flota.findByFlotaId").setParameter("flotaId", id).getResultList();
        } catch (NoResultException ne) {            
            return null;
        }
    }

}
