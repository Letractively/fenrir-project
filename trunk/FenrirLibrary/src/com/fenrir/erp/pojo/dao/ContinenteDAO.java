/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.dao;

import com.fenrir.erp.pojo.entity.Continente;

/**
 *
 * @author felipe-andrade
 */
public class ContinenteDAO extends GenericDAO<Continente> {
    private static final long serialVersionUID = 1L;
    public ContinenteDAO(){
        super(Continente.class);
    }
}