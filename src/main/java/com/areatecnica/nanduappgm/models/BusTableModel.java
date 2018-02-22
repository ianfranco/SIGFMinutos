/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.models;

import com.areatecnica.nanduappgm.dao.IBusDao;
import com.areatecnica.nanduappgm.dao.impl.IBusDaoImpl;
import com.areatecnica.nanduappgm.entities.Bus;
import com.areatecnica.nanduappgm.entities.ProcesoRecaudacion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ianfr
 */
public class BusTableModel extends AbstractTableModel {

    private ProcesoRecaudacion procesoRecaudacion;
    private IBusDao dao;
    private List<Bus> items;
    private final static String[] columnNames = {"#", "N° Bus", "PPU", "Flota"};

    public BusTableModel(ProcesoRecaudacion procesoRecaudacion) {
        this.procesoRecaudacion = procesoRecaudacion;
        init();
    }

    private void init() {
        this.dao = new IBusDaoImpl();
        this.items = this.dao.findByProceso(procesoRecaudacion);
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return items.get(rowIndex).getBusNumero();
            case 2:
                return items.get(rowIndex).getBusPatente();
            case 3:
                return items.get(rowIndex).getBusIdFlota().getFlotaNombre();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Bus getSelectedItem(int row) {
        return this.items.get(row);
    }

    public void deleteItem(Bus bus){
        if(this.items.contains(bus)){
            this.items.remove(bus);
            System.err.println("Se ha eliminado el bus");
        }
    }
    
}
