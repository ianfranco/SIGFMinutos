/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.controllers;

import com.areatecnica.nanduappgm.behaviors.FindBusPagaAction;
import com.areatecnica.nanduappgm.behaviors.FindBusRecibeAction;
import com.areatecnica.nanduappgm.behaviors.InformeGeneralPrintAction;
import com.areatecnica.nanduappgm.behaviors.InformeGrupoFlotaPagaPrintAction;
import com.areatecnica.nanduappgm.behaviors.InformeGrupoFlotaRecibePrintAction;
import com.areatecnica.nanduappgm.behaviors.RegistroMinutoDeleteAction;
import com.areatecnica.nanduappgm.behaviors.RegistroMinutoSaveAction;
import com.areatecnica.nanduappgm.dao.IRegistroMinutoDao;
import com.areatecnica.nanduappgm.dao.impl.IRegistroMinutoDaoImpl;
import com.areatecnica.nanduappgm.entities.Bus;
import com.areatecnica.nanduappgm.entities.RegistroMinuto;
import com.areatecnica.nanduappgm.helpers.CurrentDate;
import com.areatecnica.nanduappgm.helpers.NextObject;
import com.areatecnica.nanduappgm.helpers.TextSelectionFocusAdapter;
import com.areatecnica.nanduappgm.models.ProcesoRecaudacionSolyMar;
import com.areatecnica.nanduappgm.models.RegistroMinutoTableModel;
import com.areatecnica.nanduappgm.views.MDIApplicationMain;
import com.areatecnica.nanduappgm.views.RegistroMinutoView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ianfrancoconcha
 */
public class RegistroMinutoController {

    private final MDIApplicationMain frame;
    private final RegistroMinutoView view;
    private RegistroMinutoTableModel model;
    private List<RegistroMinuto> items;
    private RegistroMinuto registroMinuto;
    private IRegistroMinutoDao dao;
    private final ProcesoRecaudacionSolyMar proceso;
    private Date fecha;
    private CurrentDate currDate;

    public RegistroMinutoController(MDIApplicationMain frame, RegistroMinutoView view) {
        this.frame = frame;
        this.view = view;
        this.proceso = new ProcesoRecaudacionSolyMar();
        this.currDate = new CurrentDate();
        init();
    }

    private void init() {

        findRegistroMinuto();

        this.view.getFechaRegistroMinuto().setDate(new Date());
        

        this.view.getBusPagaTextField().addFocusListener(new FindBusPagaAction(this));

        this.view.getBusPagaTextField().addFocusListener(new TextSelectionFocusAdapter(this.view.getBusPagaTextField()));

        //this.view.getBusPagaTextField().setDocument(new NumbersDocument());
        this.view.getBusPagaTextField().addKeyListener(new NextObject(null, this.view.getBusRecibeTextField(), this.view.getBusPagaButton(), null));

        this.view.getBusRecibeTextField().addFocusListener(new FindBusRecibeAction(this));

        this.view.getBusRecibeTextField().addFocusListener(new TextSelectionFocusAdapter(this.view.getBusRecibeTextField()));

        //this.view.getBusRecibeTextField().setDocument(new NumbersDocument());
        this.view.getBusRecibeTextField().addKeyListener(new NextObject(this.view.getBusPagaTextField(), this.view.getTotalTextField(), this.view.getBusRecibeButton(), null));

        this.view.getBusPagaButton().addActionListener((e) -> {
            BusItemsPagaController busItemsController = new BusItemsPagaController(this, this.registroMinuto.getRegistroMinutoDesdeIdBus());
        });

        this.view.getBusPagaButton().addKeyListener(new NextObject(null, null, null, this.view.getBusPagaTextField()));

        this.view.getBusRecibeButton().addActionListener((e) -> {
            BusItemsRecibeController busItemsController = new BusItemsRecibeController(this, this.registroMinuto.getRegistroMinutoHastaIdBus(), this.registroMinuto.getRegistroMinutoDesdeIdBus());
        });

        this.view.getBusRecibeButton().addKeyListener(new NextObject(null, null, null, this.view.getBusRecibeTextField()));

        this.view.getTotalTextField().addKeyListener(new NextObject(this.view.getBusRecibeTextField(), this.view.getSaveButton(), null, null));

        this.view.getTotalTextField().addFocusListener(new TextSelectionFocusAdapter(this.view.getTotalTextField()));

        this.view.getTotalTextField().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                setCantidad();
            }
        });

        //this.view.getTotalTextField().setDocument(new NumbersDocument());
        this.view.getFindButton().addActionListener((ActionEvent e) -> {
            findRegistroMinuto();
        });

        this.view.getSaveButton().addKeyListener(new NextObject(this.view.getTotalTextField(), null, this.view.getResetButton(), null));

        this.view.getResetButton().addKeyListener(new NextObject(null, null, null, this.view.getSaveButton()));

        this.view.getResetButton().addActionListener((ActionEvent e) -> {
            resetRegistroMinuto();
        });

        this.view.getSaveButton().addActionListener(new RegistroMinutoSaveAction(this));
        
        this.view.getPrintButton().addActionListener(new InformeGeneralPrintAction(this));
        
        this.view.getPagaFlotaButton().addActionListener(new InformeGrupoFlotaPagaPrintAction(this));
        
        this.view.getDeleteButton().addActionListener(new RegistroMinutoDeleteAction(this));
        
        this.view.getRecibeFlotaButton().addActionListener(new InformeGrupoFlotaRecibePrintAction(this));
    }

    private void findRegistroMinuto() {
        this.fecha = this.view.getFechaRegistroMinuto().getDate();
        this.dao = new IRegistroMinutoDaoImpl();
        this.items = this.dao.findByDate(fecha);
        this.model = new RegistroMinutoTableModel(items);
        this.view.getTable().setModel(model);
        this.view.getPanelRegistroMinuto().setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Minutos al "+this.currDate.format(fecha)));
        this.registroMinuto = new RegistroMinuto();
        this.registroMinuto.setRegistroMinutoFechaMinuto(fecha);
        
        this.view.getBusPagaTextField().setEnabled(true);
        this.view.getBusRecibeTextField().setEnabled(true);
        this.view.getTotalTextField().setEnabled(true);
        this.view.getBusPagaButton().setEnabled(true);
        this.view.getBusRecibeButton().setEnabled(true);
        this.view.getSaveButton().setEnabled(true);
        this.view.getResetButton().setEnabled(true);
        
        resetRegistroMinuto();
       
    }

    public MDIApplicationMain getFrame() {
        return frame;
    }

    public ProcesoRecaudacionSolyMar getProceso() {
        return proceso;
    }

    public RegistroMinutoView getView() {
        return view;
    }

    public RegistroMinutoTableModel getModel() {
        return model;
    }

    public Date getFecha(){
        return this.fecha;
    }
    
    public void setRegistroMinuto(RegistroMinuto registroMinuto) {
        this.registroMinuto = registroMinuto;
        this.registroMinuto.setRegistroMinutoCantidad(0);
        this.registroMinuto.setRegistroMinutoRecaudado(Boolean.FALSE);
        this.registroMinuto.setRegistroMinutoFechaMinuto(this.fecha);
    }

    public RegistroMinuto getRegistroMinuto() {
        return registroMinuto;
    }
    
    public void setBusPaga(Bus bus) {
        if (bus != null) {
            this.registroMinuto.setRegistroMinutoDesdeIdBus(bus);
            this.view.getBusPagaTextField().setBackground(Color.WHITE);
            this.view.getBusPagaTextField().setText(String.valueOf(bus.getBusNumero()));
            this.view.getNombreFlotaPagaLabel().setText(this.registroMinuto.getRegistroMinutoDesdeIdBus().getBusIdFlota().getFlotaNombre());
            this.view.getPpuPagaLabel().setText(this.registroMinuto.getRegistroMinutoDesdeIdBus().getBusPatente());
            //this.view.getBusRecibeTextField().requestFocus();
        }else{
            System.err.println("el bus que paga es nulo");
        }
    }

    public void setBusRecibe(Bus bus) {
        if (bus != null) {
            this.registroMinuto.setRegistroMinutoHastaIdBus(bus);
            this.view.getBusRecibeTextField().setBackground(Color.WHITE);
            this.view.getBusRecibeTextField().setText(String.valueOf(bus.getBusNumero()));
            this.view.getNombreFlotaRecibeLabel().setText(this.registroMinuto.getRegistroMinutoHastaIdBus().getBusIdFlota().getFlotaNombre());
            this.view.getPpuRecibeLabel().setText(this.registroMinuto.getRegistroMinutoHastaIdBus().getBusPatente());
            //this.view.getTotalTextField().requestFocus();
        }else{
            System.err.println("el bus que recibe es nulo");
        }
    }

    public void setCantidad() {
        try {
            int cantidad = Integer.parseInt(this.view.getTotalTextField().getText());
            this.view.getTotalTextField().setBackground(Color.WHITE);

            this.registroMinuto.setRegistroMinutoMonto(cantidad);

            if (this.registroMinuto.getRegistroMinutoDesdeIdBus() != null && this.registroMinuto.getRegistroMinutoHastaIdBus() != null) {
                this.view.getSaveButton().setEnabled(Boolean.TRUE);
            } else {
                this.view.getSaveButton().setEnabled(Boolean.FALSE);
            }

        } catch (NumberFormatException e) {
            this.view.getTotalTextField().setBackground(Color.RED);
        }
    }

    public void resetRegistroMinuto() {

        this.view.getBusPagaTextField().setText("");
        this.view.getBusPagaTextField().setBackground(Color.WHITE);
        this.view.getBusRecibeTextField().setText("");
        this.view.getBusRecibeTextField().setBackground(Color.WHITE);
        this.view.getTotalTextField().setText("0");
        this.view.getTotalTextField().setBackground(Color.WHITE);
        this.view.getPpuPagaLabel().setText("");
        this.view.getNombreFlotaPagaLabel().setText("");
        this.view.getPpuRecibeLabel().setText("");
        this.view.getNombreFlotaRecibeLabel().setText("");

        this.view.getSaveButton().setEnabled(Boolean.FALSE);
        this.view.getBusPagaTextField().requestFocus();
        
    }

}
