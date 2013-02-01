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
public class TelefonesEntidadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_telefones")
    private int idTelefones;
    @Basic(optional = false)
    @Column(name = "id_tipo_telefone")
    private int idTipoTelefone;

    public TelefonesEntidadePK() {
    }

    public TelefonesEntidadePK(int idTelefones, int idTipoTelefone) {
        this.idTelefones = idTelefones;
        this.idTipoTelefone = idTipoTelefone;
    }

    public int getIdTelefones() {
        return idTelefones;
    }

    public void setIdTelefones(int idTelefones) {
        this.idTelefones = idTelefones;
    }

    public int getIdTipoTelefone() {
        return idTipoTelefone;
    }

    public void setIdTipoTelefone(int idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTelefones;
        hash += (int) idTipoTelefone;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonesEntidadePK)) {
            return false;
        }
        TelefonesEntidadePK other = (TelefonesEntidadePK) object;
        if (this.idTelefones != other.idTelefones) {
            return false;
        }
        if (this.idTipoTelefone != other.idTipoTelefone) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.TelefonesEntidadePK[ idTelefones=" + idTelefones + ", idTipoTelefone=" + idTipoTelefone + " ]";
    }
    
}
