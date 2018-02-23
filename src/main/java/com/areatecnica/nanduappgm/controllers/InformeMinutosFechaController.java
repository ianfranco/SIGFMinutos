/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.controllers;

import com.areatecnica.nanduappgm.helpers.CurrentDate;
import com.areatecnica.nanduappgm.views.ReporteFechaView;
import com.areatecnica.nanduappgm.views.ReporteMesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ianfrancoconcha
 */
public class InformeMinutosFechaController {

    private ReporteFechaView view;
    private ReporteFechaController controller;
    private ReportController report;
    private Map map;
    private CurrentDate currDate;
    //private static final String path = ""; 
    private InputStream file = getClass().getResourceAsStream("/INF-RegistroMinutos.jrxml");

    public InformeMinutosFechaController() {
    }

    public InformeMinutosFechaController(ReporteFechaView view) {
        this.view = view;
        this.controller = new ReporteFechaController(view);
        this.currDate = new CurrentDate();
        init();
    }

    private void init() {
        this.view.getViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadReport();
            }
        });
        
        
    }

    public void loadReport() {
        currDate.setDate(this.view.getDateTextField().getDate());
        
        this.map = new HashMap();
        this.map.put("fecha", this.currDate.date());
        

        this.report = new ReportController(this.view.getTabbedPane(), this.file, map, "Registro Minutos al "+ currDate.toString());
        this.report.setMap(map);

        this.report.loadFile();

        this.file = null;

        this.file = getClass().getResourceAsStream("/INF-RegistroMinutos.jrxml");
    }

}
