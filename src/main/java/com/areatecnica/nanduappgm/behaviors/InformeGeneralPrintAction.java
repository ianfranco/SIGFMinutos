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

/**
 *
 * @author ianfrancoconcha
 */
public class InformeGeneralPrintAction  extends AbstractAction {

    private RegistroMinutoController controller; 
    private Date fecha; 
    private ReportController report; 
    private Map map; 
    //private static final String path = ""; 
    private InputStream file = getClass().getResourceAsStream("/INF-RegistroMinutos.jrxml");

    public InformeGeneralPrintAction() {
    }
    
    public InformeGeneralPrintAction(RegistroMinutoController controller){
        this.controller = controller; 
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.fecha = this.controller.getFecha(); 
        this.map = new HashMap(); 
        this.map.put("fecha", fecha); 
        
        this.report = new ReportController(file); 
        this.report.setMap(map);
        
        this.report.loadFile();
        
        this.file = null; 
        
        this.file = getClass().getResourceAsStream("/INF-RegistroMinutos.jrxml");
    }
    
}
