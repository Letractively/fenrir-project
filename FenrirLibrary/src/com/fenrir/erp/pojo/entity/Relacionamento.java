/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_relacionamento")
@NamedQueries({
    @NamedQuery(name = "Relacionamento.findAll", query = "SELECT r FROM Relacionamento r")})
public class Relacionamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_relacionamento")
    private Integer idRelacionamento;
    @Basic(optional = false)
    @Column(name = "nm_relacionamento")
    private String nmRelacionamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relacionamento")
    private Collection<RelacionamentoXEntidade> relacionamentoXEntidadeCollection;

    public Relacionamento() {
    }

    public Relacionamento(Integer idRelacionamento) {
        this.idRelacionamento = idRelacionamento;
    }

    public Relacionamento(Integer idRelacionamento, String nmRelacionamento) {
        this.idRelacionamento = idRelacionamento;
        this.nmRelacionamento = nmRelacionamento;
    }

    public Integer getIdRelacionamento() {
        return idRelacionamento;
    }

    public void setIdRelacionamento(Integer idRelacionamento) {
        this.idRelacionamento = idRelacionamento;
    }

    public String getNmRelacionamento() {
        return nmRelacionamento;
    }

    public void setNmRelacionamento(String nmRelacionamento) {
        this.nmRelacionamento = nmRelacionamento;
    }

    public Collection<RelacionamentoXEntidade> getRelacionamentoXEntidadeCollection() {
        return relacionamentoXEntidadeCollection;
    }

    public void setRelacionamentoXEntidadeCollection(Collection<RelacionamentoXEntidade> relacionamentoXEntidadeCollection) {
        this.relacionamentoXEntidadeCollection = relacionamentoXEntidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelacionamento != null ? idRelacionamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacionamento)) {
            return false;
        }
        Relacionamento other = (Relacionamento) object;
        if ((this.idRelacionamento == null && other.idRelacionamento != null) || (this.idRelacionamento != null && !this.idRelacionamento.equals(other.idRelacionamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Relacionamento[ idRelacionamento=" + idRelacionamento + " ]";
    }
    
}
