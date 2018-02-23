/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.controllers;

import com.areatecnica.nanduappgm.helpers.CurrentDate;
import com.areatecnica.nanduappgm.views.ReporteMesFlotaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ianfrancoconcha
 */
public class InformeMinutosPagadosFlotaController {

    private ReporteMesFlotaView view;
    private ReporteMesFlotaController controller;
    private ReportController report;
    private Map map;
    private CurrentDate currDate;
    //private static final String path = ""; 
    private InputStream file = getClass().getResourceAsStream("/INF-RegistroMinutosPendientesPagar.jrxml");

    public InformeMinutosPagadosFlotaController() {
    }

    public InformeMinutosPagadosFlotaController(ReporteMesFlotaView view) {
        this.view = view;
        this.controller = new ReporteMesFlotaController(view);
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

        this.currDate = new CurrentDate(1, this.controller.getMes()+1, this.controller.getAnio());

        this.map = new HashMap();
        this.map.put("from", currDate.date());
        this.map.put("to", currDate.getMaxDate());
        this.map.put("fecha", currDate.getStringMonthYear());
        
        System.err.println("FROM:"+currDate.date()+" TO:"+currDate.getMaxDate());

        this.report = new ReportController(this.view.getTabbedPane(), this.file, map, "Resumenu Minutos x Flota:");
        this.report.setMap(map);

        this.report.loadFile();

        this.file = null;

        this.file = getClass().getResourceAsStream("/INF-RegistroMinutosPendientesPagar.jrxml");
    }

}
