/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author felipe-andrade
 */
@Embeddable
public class RelacionamentoXEntidadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_relacionamentoFK")
    private int idrelacionamentoFK;
    @Basic(optional = false)
    @Column(name = "id_entidadeFK")
    private int identidadeFK;
    @Basic(optional = false)
    @Column(name = "id_sistemaFK")
    private int idsistemaFK;

    public RelacionamentoXEntidadePK() {
    }

    public RelacionamentoXEntidadePK(int idrelacionamentoFK, int identidadeFK, int idsistemaFK) {
        this.idrelacionamentoFK = idrelacionamentoFK;
        this.identidadeFK = identidadeFK;
        this.idsistemaFK = idsistemaFK;
    }

    public int getIdrelacionamentoFK() {
        return idrelacionamentoFK;
    }

    public void setIdrelacionamentoFK(int idrelacionamentoFK) {
        this.idrelacionamentoFK = idrelacionamentoFK;
    }

    public int getIdentidadeFK() {
        return identidadeFK;
    }

    public void setIdentidadeFK(int identidadeFK) {
        this.identidadeFK = identidadeFK;
    }

    public int getIdsistemaFK() {
        return idsistemaFK;
    }

    public void setIdsistemaFK(int idsistemaFK) {
        this.idsistemaFK = idsistemaFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idrelacionamentoFK;
        hash += (int) identidadeFK;
        hash += (int) idsistemaFK;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionamentoXEntidadePK)) {
            return false;
        }
        RelacionamentoXEntidadePK other = (RelacionamentoXEntidadePK) object;
        if (this.idrelacionamentoFK != other.idrelacionamentoFK) {
            return false;
        }
        if (this.identidadeFK != other.identidadeFK) {
            return false;
        }
        if (this.idsistemaFK != other.idsistemaFK) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.RelacionamentoXEntidadePK[ idrelacionamentoFK=" + idrelacionamentoFK + ", identidadeFK=" + identidadeFK + ", idsistemaFK=" + idsistemaFK + " ]";
    }
    
}
