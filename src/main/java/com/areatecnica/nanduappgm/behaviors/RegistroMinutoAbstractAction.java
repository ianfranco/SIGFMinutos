/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.behaviors;

import com.areatecnica.nanduappgm.controllers.RegistroMinutoController;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author ianfrancoconcha
 */
public class RegistroMinutoAbstractAction extends AbstractAction{

    private RegistroMinutoController controller;

    public RegistroMinutoAbstractAction(RegistroMinutoController controller) {
        this.controller = controller;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RegistroMinutoController getController() {
        return controller;
    }
   
}
