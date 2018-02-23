/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.controllers;

import com.areatecnica.nanduappgm.views.ReporteFechaView;
import com.ibm.icu.util.Calendar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

/**
 *
 * @author ianfrancoconcha
 */
public class ReporteFechaController {

    private ReporteFechaView view;
    private Date fecha;

    public ReporteFechaController(ReporteFechaView view) {
        this.view = view;
        init();
    }

    private void init() {
        Calendar calendar = Calendar.getInstance();
        this.fecha = calendar.getTime();
        this.view.getDateTextField().setDate(fecha);

        this.view.getDateTextField().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                setDate();
            }
        });
        
    }
    
    public void setDate(){
        this.fecha = this.view.getDateTextField().getDate();
    }

    public Date getFecha() {
        return fecha;
    }

}
