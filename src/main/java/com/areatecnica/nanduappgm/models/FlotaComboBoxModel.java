/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.models;



import com.areatecnica.nanduappgm.dao.impl.FlotaDaoImpl;
import com.areatecnica.nanduappgm.entities.Flota;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class FlotaComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private FlotaDaoImpl dao;
    private List<Flota> list;
    private Flota proceso;

    public FlotaComboBoxModel() {
        this.dao = new FlotaDaoImpl();
        this.list = this.dao.findAll();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Flota getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public Flota getSelectedItem() {
        return proceso;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.proceso = (Flota) anItem;
    }

}
