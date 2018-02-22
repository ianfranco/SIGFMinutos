/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.behaviors;

import com.areatecnica.nanduappgm.controllers.RegistroMinutoController;
import com.areatecnica.nanduappgm.dao.IBusDao;
import com.areatecnica.nanduappgm.dao.impl.IBusDaoImpl;
import com.areatecnica.nanduappgm.entities.Bus;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author ianfr
 */
public class FindBusRecibeAction extends FocusAdapter {

    private RegistroMinutoController controller;
    //private RegistroMinuto registroMinuto; 
    private Bus recibe;
    private final IBusDao dao;
    private String busNumero;

    public FindBusRecibeAction(RegistroMinutoController controller) {
        this.controller = controller;
        this.dao = new IBusDaoImpl();
    }

    @Override
    public void focusLost(FocusEvent e) {
        find();
    }

    public void find() {
        try {

            this.busNumero = this.controller.getView().getBusRecibeTextField().getText();

            this.recibe = this.dao.findByNumeroBusProceso(Integer.valueOf(busNumero), this.controller.getProceso().getProceso());

            if (this.recibe != null) {
                
                this.controller.getRegistroMinuto().setRegistroMinutoHastaIdBus(this.recibe);
                
                this.controller.getView().getBusRecibeTextField().setBackground(Color.WHITE);
                
                this.controller.setBusRecibe(recibe);
                
            } else {
                this.controller.getView().getBusRecibeTextField().setBackground(Color.RED);
            }

        } catch (NullPointerException ee) {
            this.controller.getView().getBusRecibeTextField().setBackground(Color.RED);
            ee.printStackTrace();
        } catch (NumberFormatException ex) {
            this.controller.getView().getBusRecibeTextField().setBackground(Color.GREEN);
        }
        
    }

}
