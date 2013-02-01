/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.dao;

import com.fenrir.erp.pojo.entity.Endereco;

/**
 *
 * @author felipe-andrade
 */
public class EnderecoDAO extends GenericDAO<Endereco> {
     private static final long serialVersionUID = 1L;
     
     EnderecoDAO(){
         super(Endereco.class);
     }
}
