/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.behaviors;

import com.areatecnica.nanduappgm.controllers.RegistroMinutoController;
import com.areatecnica.nanduappgm.dao.IRegistroMinutoDao;
import com.areatecnica.nanduappgm.dao.impl.IRegistroMinutoDaoImpl;
import com.areatecnica.nanduappgm.entities.RegistroMinuto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author ianfrancoconcha
 */
public class RegistroMinutoSaveAction extends RegistroMinutoAbstractAction {

    //private RegistroMinutoController controller;
    private IRegistroMinutoDao dao;

    public RegistroMinutoSaveAction(RegistroMinutoController controller) {
        super(controller);
        init();
    }

    private void init() {
        this.dao = new IRegistroMinutoDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.getController().getRegistroMinuto() != null) {

            System.err.println("BUS DESDE:" + this.getController().getRegistroMinuto().getRegistroMinutoDesdeIdBus().getBusId());
            System.err.println("BUS HASTA:" + this.getController().getRegistroMinuto().getRegistroMinutoHastaIdBus().getBusId());

            if (this.getController().getRegistroMinuto().getRegistroMinutoDesdeIdBus().getBusId() != this.getController().getRegistroMinuto().getRegistroMinutoHastaIdBus().getBusId()) {
                if (this.getController().getRegistroMinuto().getRegistroMinutoMonto() > 0) {
                    this.dao.create(this.getController().getRegistroMinuto());
                    this.getController().getModel().add(this.getController().getRegistroMinuto());
                    this.getController().getView().getTable().setRowSelectionInterval(0, 0);

                    //this.getController().setRegistroMinuto(null);
                    this.getController().setRegistroMinuto(new RegistroMinuto());
                    this.getController().getRegistroMinuto().setRegistroMinutoFechaMinuto(this.getController().getFecha());

                    this.getController().resetRegistroMinuto();
                } else {
                    this.getController().getView().getTotalTextField().setBackground(Color.YELLOW);
                    System.err.println("Monto debe ser mayor a 0");
                }
            } else {
                System.err.println("Los buses son iguales: ");
                this.getController().getView().getBusRecibeTextField().setBackground(Color.RED);
                this.getController().getView().getBusPagaTextField().setBackground(Color.RED);
            }

        } else {
            System.err.println("error item nulo ");
        }
    }

}
