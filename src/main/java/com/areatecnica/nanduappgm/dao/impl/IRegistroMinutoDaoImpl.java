/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.dao.impl;

import com.areatecnica.nanduappgm.dao.IRegistroMinutoDao;
import com.areatecnica.nanduappgm.entities.Bus;
import com.areatecnica.nanduappgm.entities.RegistroMinuto;
import com.areatecnica.nanduappgm.entities.Terminal;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author ianfr
 */
public class IRegistroMinutoDaoImpl extends GenericDAOImpl<RegistroMinuto> implements IRegistroMinutoDao<RegistroMinuto> {

    @Override
    public List<RegistroMinuto> findByDate(Date fecha) {
        return this.entityManager.createNamedQuery("RegistroMinuto.findByRegistroMinutoFechaMinuto").setParameter("registroMinutoFechaMinuto", fecha).getResultList();
    }

    @Override
    public List<RegistroMinuto> findByBusPagaDates(Bus bus, Date from, Date to) {
        return this.entityManager.createNamedQuery("RegistroMinuto.findByRegistroMfindByRegfindByRegistroMinutoDesdeIdBus").setParameter("registroMinutoDesdeIdBus", bus).setParameter("registroMinutoFechaMinuto", from).setParameter("registroMinutoFechaMinuto", to).getResultList();
    }

    @Override
    public List<RegistroMinuto> findByBusRecibeDate(Bus bus, Date fecha) {
        return this.entityManager.createNamedQuery("RegistroMinuto.findByRegistroMinutoHastaIdBus").setParameter("registroMinutoHastaIdBus", bus).setParameter("registroMinutoFechaMinuto", fecha).getResultList();
    }

    @Override
    public List<RegistroMinuto> findByBusSinRecaudar(Bus bus) {
        return this.entityManager.createNamedQuery("RegistroMinuto.findByRegistroMinutoDesdeSinRecaudar").setParameter("registroMinutoDesdeIdBus", bus).getResultList();
    }

    @Override
    public List<RegistroMinuto> findBySinRecaudar() {
        return this.entityManager.createNamedQuery("RegistroMinuto.findByRegistroMinutoRecaudado").setParameter("registroMinutoRecaudado", Boolean.FALSE).getResultList();
    }

    @Override
    public List<RegistroMinuto> findByTerminalSinRecaudar(Terminal terminal) {
        try {
            return this.entityManager.
                    createNamedQuery("RegistroMinuto.findByRegistroMinutoSinRecaudar").
                    setParameter("registroMinutoRecaudado", Boolean.FALSE).
                    setParameter("busIdTerminal", terminal).
                    getResultList();
        } catch (NoResultException ne) {
            return null;
        }
    }


}
