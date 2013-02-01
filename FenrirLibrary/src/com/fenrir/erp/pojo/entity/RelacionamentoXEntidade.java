/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tbl_relacionamento_x_entidade")
@NamedQueries({
    @NamedQuery(name = "RelacionamentoXEntidade.findAll", query = "SELECT r FROM RelacionamentoXEntidade r")})
public class RelacionamentoXEntidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelacionamentoXEntidadePK relacionamentoXEntidadePK;
    @JoinColumn(name = "id_sistemaFK", referencedColumnName = "id_sistema", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sistema sistema;
    @JoinColumn(name = "id_relacionamentoFK", referencedColumnName = "id_relacionamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Relacionamento relacionamento;
    @JoinColumn(name = "id_entidadeFK", referencedColumnName = "id_entidade", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Entidade entidade;

    public RelacionamentoXEntidade() {
    }

    public RelacionamentoXEntidade(RelacionamentoXEntidadePK relacionamentoXEntidadePK) {
        this.relacionamentoXEntidadePK = relacionamentoXEntidadePK;
    }

    public RelacionamentoXEntidade(int idrelacionamentoFK, int identidadeFK, int idsistemaFK) {
        this.relacionamentoXEntidadePK = new RelacionamentoXEntidadePK(idrelacionamentoFK, identidadeFK, idsistemaFK);
    }

    public RelacionamentoXEntidadePK getRelacionamentoXEntidadePK() {
        return relacionamentoXEntidadePK;
    }

    public void setRelacionamentoXEntidadePK(RelacionamentoXEntidadePK relacionamentoXEntidadePK) {
        this.relacionamentoXEntidadePK = relacionamentoXEntidadePK;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Relacionamento getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(Relacionamento relacionamento) {
        this.relacionamento = relacionamento;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relacionamentoXEntidadePK != null ? relacionamentoXEntidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionamentoXEntidade)) {
            return false;
        }
        RelacionamentoXEntidade other = (RelacionamentoXEntidade) object;
        if ((this.relacionamentoXEntidadePK == null && other.relacionamentoXEntidadePK != null) || (this.relacionamentoXEntidadePK != null && !this.relacionamentoXEntidadePK.equals(other.relacionamentoXEntidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.RelacionamentoXEntidade[ relacionamentoXEntidadePK=" + relacionamentoXEntidadePK + " ]";
    }
    
}
