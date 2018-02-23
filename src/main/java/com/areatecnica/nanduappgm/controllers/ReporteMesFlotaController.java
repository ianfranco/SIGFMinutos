/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.controllers;

import com.areatecnica.nanduappgm.entities.Flota;
import com.areatecnica.nanduappgm.models.FlotaComboBoxModel;
import com.areatecnica.nanduappgm.views.ReporteMesFlotaView;
import com.ibm.icu.util.Calendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author ianfrancoconcha
 */
public class ReporteMesFlotaController {

    private ReporteMesFlotaView view;
    private int mes;
    private int anio;
    private Flota flota;
    private FlotaComboBoxModel model;

    public ReporteMesFlotaController(ReporteMesFlotaView view) {
        this.view = view;
        init();
    }

    private void init() {
        Calendar calendar = Calendar.getInstance();
        this.anio = calendar.get(Calendar.YEAR);
        this.mes = calendar.get(Calendar.MONTH);

        this.view.getYearTextField().setText(String.valueOf(anio));
        this.view.getMonthComboBox().setSelectedIndex(mes);

        this.model = new FlotaComboBoxModel();

        this.view.getFlotaComboBox().setModel(model);

        this.view.getFlotaComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFlota();
            }
        });

        this.view.getYearTextField().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                setAnio();
            }
        });

        this.view.getMonthComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMes();
            }
        });

    }

    public Flota getFlota() {
        return flota;
    }

    private void setFlota() {
        int index = this.view.getFlotaComboBox().getSelectedIndex();

        if (index > -1) {
            this.flota = this.model.getElementAt(index);
        }
    }

    private void setAnio() {
        try {
            String _anio = this.view.getYearTextField().getText();
            this.anio = Integer.parseInt(_anio);
            this.view.getYearTextField().setBackground(Color.WHITE);
        } catch (NumberFormatException e) {
            this.view.getYearTextField().setBackground(Color.RED);
        }
    }

    private void setMes() {
        int _mes = this.view.getMonthComboBox().getSelectedIndex();
        if (_mes > -1) {
            this.mes = _mes;
        }
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

}
