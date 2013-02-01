/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.dao;

import com.fenrir.erp.pojo.entity.Contatos;
import java.util.*;

/**
 *
 * @author felipe-andrade
 */
public class ContatosDAO extends GenericDAO<Contatos> {
    
    private static final long serialVersionUID = 1L;
    
    ContatosDAO(){
        super(Contatos.class);
    }
    
    //public Contatos findAll(String email){
        //Map<String, Object> parameters = new HashMap<String, Object>();
        //parameters.put("email", email);    
 
        //return super.findOneResult(Contatos.FIND_ALL, parameters);
    //}
}
