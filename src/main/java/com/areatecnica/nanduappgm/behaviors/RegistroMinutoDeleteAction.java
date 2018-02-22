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
import javax.swing.JOptionPane;

/**
 *
 * @author ianfrancoconcha
 */
public class RegistroMinutoDeleteAction extends RegistroMinutoAbstractAction {

    private RegistroMinuto registro;
    private IRegistroMinutoDao dao;

    public RegistroMinutoDeleteAction(RegistroMinutoController controller) {
        super(controller);
        init();
    }

    private void init() {
        this.dao = new IRegistroMinutoDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int row = this.getController().getView().getTable().getSelectedRow();

        if (row > -1) {

            this.registro = this.getController().getModel().get(row);

            if (this.registro != null) {

                int option = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    if (!this.registro.getRegistroMinutoRecaudado()) {

                        this.dao.delete(this.registro);
                        this.getController().getModel().delete(registro);
                        
                    } else {
                        this.getController().getView().getTotalTextField().setBackground(Color.red);
                        
                        JOptionPane.showMessageDialog(null, "El minuto ya fue recaudado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else {
                System.err.println("Los buses son iguales: ");
                this.getController().getView().getBusRecibeTextField().setBackground(Color.red);
                this.getController().getView().getBusPagaTextField().setBackground(Color.red);
            }

        } else {
            System.err.println("error item nulo ");
        }
    }

}
