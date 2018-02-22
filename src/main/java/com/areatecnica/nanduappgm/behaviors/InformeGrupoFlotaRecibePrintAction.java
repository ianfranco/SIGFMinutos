/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.behaviors;

import com.areatecnica.nanduappgm.controllers.RegistroMinutoController;
import com.areatecnica.nanduappgm.controllers.ReportController;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author ianfrancoconcha
 */
public class InformeGrupoFlotaRecibePrintAction extends AbstractAction {

    private RegistroMinutoController controller;
    private Date fecha;
    private ReportController report;
    private Map map;
    //private static final String path = ""; 
    private InputStream file = getClass().getResourceAsStream("/INF-RegistroMinutosRecibeFlota.jrxml");
    private InputStream file2 = getClass().getResourceAsStream("/INF-RegistroMinutosRecibeFlotaIndependiente.jrxml");

    public InformeGrupoFlotaRecibePrintAction() {
    }

    public InformeGrupoFlotaRecibePrintAction(RegistroMinutoController controller) {
        this.controller = controller;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fecha = this.controller.getFecha();
        this.map = new HashMap();
        this.map.put("fecha", fecha);

        int option = JOptionPane.showConfirmDialog(null, "Separar por flota?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            this.report = new ReportController(file2);
            this.file2 = null;
            this.file2 = getClass().getResourceAsStream("/INF-RegistroMinutosRecibeFlotaIndependiente.jrxml");
        }else{
            this.report = new ReportController(file);
            this.file = null; 
            this.file = getClass().getResourceAsStream("/INF-RegistroMinutosRecibeFlota.jrxml");
        }

        
        this.report.setMap(map);
        this.report.loadFile();
    }

}
