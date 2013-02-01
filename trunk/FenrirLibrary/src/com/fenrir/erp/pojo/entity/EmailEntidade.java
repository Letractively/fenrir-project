/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_email_entidade")
@NamedQueries({
    @NamedQuery(name = "EmailEntidade.findAll", query = "SELECT e FROM EmailEntidade e")})
public class EmailEntidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_email_entidade")
    private Integer idEmailEntidade;
    @Column(name = "nm_email_entidade")
    private String nmEmailEntidade;
    @JoinColumn(name = "id_entidadeFK", referencedColumnName = "id_entidade")
    @ManyToOne
    private Entidade identidadeFK;

    public EmailEntidade() {
    }

    public EmailEntidade(Integer idEmailEntidade) {
        this.idEmailEntidade = idEmailEntidade;
    }

    public Integer getIdEmailEntidade() {
        return idEmailEntidade;
    }

    public void setIdEmailEntidade(Integer idEmailEntidade) {
        this.idEmailEntidade = idEmailEntidade;
    }

    public String getNmEmailEntidade() {
        return nmEmailEntidade;
    }

    public void setNmEmailEntidade(String nmEmailEntidade) {
        this.nmEmailEntidade = nmEmailEntidade;
    }

    public Entidade getIdentidadeFK() {
        return identidadeFK;
    }

    public void setIdentidadeFK(Entidade identidadeFK) {
        this.identidadeFK = identidadeFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmailEntidade != null ? idEmailEntidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailEntidade)) {
            return false;
        }
        EmailEntidade other = (EmailEntidade) object;
        if ((this.idEmailEntidade == null && other.idEmailEntidade != null) || (this.idEmailEntidade != null && !this.idEmailEntidade.equals(other.idEmailEntidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.EmailEntidade[ idEmailEntidade=" + idEmailEntidade + " ]";
    }
    
}
