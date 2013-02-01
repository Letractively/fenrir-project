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
public class IpPaisPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_ip_pais")
    private int idIpPais;
    @Basic(optional = false)
    @Column(name = "id_pais")
    private int idPais;
    @Basic(optional = false)
    @Column(name = "id_continente")
    private int idContinente;

    public IpPaisPK() {
    }

    public IpPaisPK(int idIpPais, int idPais, int idContinente) {
        this.idIpPais = idIpPais;
        this.idPais = idPais;
        this.idContinente = idContinente;
    }

    public int getIdIpPais() {
        return idIpPais;
    }

    public void setIdIpPais(int idIpPais) {
        this.idIpPais = idIpPais;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idIpPais;
        hash += (int) idPais;
        hash += (int) idContinente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IpPaisPK)) {
            return false;
        }
        IpPaisPK other = (IpPaisPK) object;
        if (this.idIpPais != other.idIpPais) {
            return false;
        }
        if (this.idPais != other.idPais) {
            return false;
        }
        if (this.idContinente != other.idContinente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.IpPaisPK[ idIpPais=" + idIpPais + ", idPais=" + idPais + ", idContinente=" + idContinente + " ]";
    }
    
}
