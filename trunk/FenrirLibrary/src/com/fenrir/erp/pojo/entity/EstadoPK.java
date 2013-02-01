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
public class EstadoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_estado")
    private int idEstado;
    @Basic(optional = false)
    @Column(name = "id_regiao_pais")
    private int idRegiaoPais;

    public EstadoPK() {
    }

    public EstadoPK(int idEstado, int idRegiaoPais) {
        this.idEstado = idEstado;
        this.idRegiaoPais = idRegiaoPais;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdRegiaoPais() {
        return idRegiaoPais;
    }

    public void setIdRegiaoPais(int idRegiaoPais) {
        this.idRegiaoPais = idRegiaoPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEstado;
        hash += (int) idRegiaoPais;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPK)) {
            return false;
        }
        EstadoPK other = (EstadoPK) object;
        if (this.idEstado != other.idEstado) {
            return false;
        }
        if (this.idRegiaoPais != other.idRegiaoPais) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.EstadoPK[ idEstado=" + idEstado + ", idRegiaoPais=" + idRegiaoPais + " ]";
    }
    
}
