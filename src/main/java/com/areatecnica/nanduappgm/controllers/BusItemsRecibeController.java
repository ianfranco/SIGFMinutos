/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.controllers;

import com.areatecnica.nanduappgm.models.BusTableModel;
import com.areatecnica.nanduappgm.entities.Bus;
import com.areatecnica.nanduappgm.models.ProcesoRecaudacionSolyMar;
import com.areatecnica.nanduappgm.views.BusItemsView;
import com.areatecnica.nanduappgm.views.MDIApplicationMain;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import javax.swing.JTextField;

/**
 *
 * @author ianfr
 */
public class BusItemsRecibeController extends Observable {

    private ProcesoRecaudacionSolyMar procesoRecaudacion;
    private BusItemsView view;
    private RegistroMinutoController controller; 
    private BusTableModel model;
    private Bus bus;
    private Bus toDelete; 

    public BusItemsRecibeController(RegistroMinutoController controller, Bus bus, Bus toDelete) {
        super();
        this.procesoRecaudacion = new ProcesoRecaudacionSolyMar();
        this.controller = controller;
        this.bus = bus; 
        this.toDelete = toDelete; 
        init();
    }

    private void init() {
        this.model = new BusTableModel(procesoRecaudacion.getProceso());
        this.model.deleteItem(toDelete);
        
        this.view = new BusItemsView(null, Boolean.TRUE);
        this.view.setTitle("Lista de Buses");
        this.view.getBusTable().setModel(model);
        this.view.getBusTable().doLayout();
        this.view.getBusTable().requestFocus();

        this.view.getBusTable().setRowSelectionInterval(0, 0);

        this.view.getBusTable().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    getBus();
                }
            }
        });

        this.view.getBusTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    getBus();
                }
            }

        });

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIApplicationMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIApplicationMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIApplicationMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIApplicationMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        this.view.setLocationRelativeTo(null);
        this.view.setSize(600, 400);
        this.view.setVisible(true);
    }

    public void getBus() {
        int row = view.getBusTable().getSelectedRow();

        if (row > -1) {
            bus = model.getSelectedItem(row);
            
            this.controller.setBusRecibe(bus);
            this.controller.getView().getBusRecibeTextField().requestFocus();
            view.dispose();
            
        }

    }
}
