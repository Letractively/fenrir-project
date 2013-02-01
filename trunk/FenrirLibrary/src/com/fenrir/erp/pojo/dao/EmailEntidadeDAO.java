/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.dao;

import com.fenrir.erp.pojo.entity.EmailEntidade;

/**
 *
 * @author felipe-andrade
 */
public class EmailEntidadeDAO extends GenericDAO<EmailEntidade> {
    private static final long serialVersionUID = 1L;
    
    EmailEntidadeDAO(){
        super(EmailEntidade.class);
    }
}
