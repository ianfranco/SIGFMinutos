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
public class FindBusPagaAction extends FocusAdapter {

    private RegistroMinutoController controller;
    private Bus paga;
    private final IBusDao dao;
    private String busNumero;

    public FindBusPagaAction(RegistroMinutoController controller) {
        this.controller = controller;
        this.dao = new IBusDaoImpl();
    }

    @Override
    public void focusLost(FocusEvent e) {
        find();
    }

    public void find() {
        try {

            this.busNumero = this.controller.getView().getBusPagaTextField().getText();

            this.paga = this.dao.findByNumeroBusProceso(Integer.valueOf(busNumero), this.controller.getProceso().getProceso());

            if (this.paga != null) {

                this.controller.getRegistroMinuto().setRegistroMinutoDesdeIdBus(this.paga);
                
                this.controller.getView().getBusPagaTextField().setBackground(Color.WHITE);
                if (this.controller.getRegistroMinuto().getRegistroMinutoHastaIdBus() == null) {
                    this.controller.getView().getBusPagaTextField().setBackground(Color.WHITE);

                } else {
                    if (this.paga == this.controller.getRegistroMinuto().getRegistroMinutoHastaIdBus()) {
                        this.controller.getView().getBusRecibeTextField().setText("");
                    }
                }

                this.controller.setBusPaga(paga);

            } else {
                this.controller.getView().getBusPagaTextField().setBackground(Color.RED);
                //textField.setText("No existe el N° Ingresado");
            }

        } catch (NullPointerException ee) {
            this.controller.getView().getBusPagaTextField().setBackground(Color.RED);
            ee.printStackTrace();
        } catch (NumberFormatException ex) {
            this.controller.getView().getBusPagaTextField().setBackground(Color.GREEN);
        }
        
    }

}
