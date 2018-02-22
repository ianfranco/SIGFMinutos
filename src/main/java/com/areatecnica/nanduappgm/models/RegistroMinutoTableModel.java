/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.models;

import com.areatecnica.nanduappgm.entities.RegistroMinuto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ianfrancoconcha
 */
public class RegistroMinutoTableModel extends AbstractTableModel {

    private String[] names = {"Nº", "Nº Bus Paga", "Nº Bus Recibe", "Total"};
    private List<RegistroMinuto> items;
    private RegistroMinuto item;

    public RegistroMinutoTableModel(List<RegistroMinuto> items) {
        this.items = items;
        init();
    }

    private void init() {

    }

    @Override
    public int getRowCount() {
        return this.items.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return getRowCount()-rowIndex;
            case 1:
                return items.get(rowIndex).getRegistroMinutoDesdeIdBus().getBusNumero();
            case 2:
                return items.get(rowIndex).getRegistroMinutoHastaIdBus().getBusNumero();
            case 3:
                return items.get(rowIndex).getRegistroMinutoMonto();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }
    
    public RegistroMinuto get(int row){
        return this.items.get(row);
    }

    public void delete(RegistroMinuto registro) {
        if (this.items.contains(registro)) {
            this.items.remove(registro);
            fireTableChanged(null);
        }
    }

    public void add(RegistroMinuto registro) {
        if (registro != null) {
            this.items.add(0, registro);
            fireTableChanged(null);
        }

    }

}
