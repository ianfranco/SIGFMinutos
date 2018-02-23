/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.dao;

import com.areatecnica.nanduappgm.entities.Flota;
import java.util.List;

/**
 *
 * @author ianfr
 */
public interface IFlotaDao<T> extends IGenericDAO<T> {
   
    public List<Flota> findById(int id);
        
}
