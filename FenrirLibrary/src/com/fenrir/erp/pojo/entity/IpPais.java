/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_ip_pais")
@NamedQueries({
    @NamedQuery(name = "IpPais.findAll", query = "SELECT i FROM IpPais i")})
public class IpPais implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IpPaisPK ipPaisPK;
    @Basic(optional = false)
    @Column(name = "vl_start_ip")
    private String vlStartIp;
    @Basic(optional = false)
    @Column(name = "vl_end_ip")
    private String vlEndIp;
    @JoinColumns({
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false),
        @JoinColumn(name = "id_continente", referencedColumnName = "id_continente", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pais pais;

    public IpPais() {
    }

    public IpPais(IpPaisPK ipPaisPK) {
        this.ipPaisPK = ipPaisPK;
    }

    public IpPais(IpPaisPK ipPaisPK, String vlStartIp, String vlEndIp) {
        this.ipPaisPK = ipPaisPK;
        this.vlStartIp = vlStartIp;
        this.vlEndIp = vlEndIp;
    }

    public IpPais(int idIpPais, int idPais, int idContinente) {
        this.ipPaisPK = new IpPaisPK(idIpPais, idPais, idContinente);
    }

    public IpPaisPK getIpPaisPK() {
        return ipPaisPK;
    }

    public void setIpPaisPK(IpPaisPK ipPaisPK) {
        this.ipPaisPK = ipPaisPK;
    }

    public String getVlStartIp() {
        return vlStartIp;
    }

    public void setVlStartIp(String vlStartIp) {
        this.vlStartIp = vlStartIp;
    }

    public String getVlEndIp() {
        return vlEndIp;
    }

    public void setVlEndIp(String vlEndIp) {
        this.vlEndIp = vlEndIp;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ipPaisPK != null ? ipPaisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IpPais)) {
            return false;
        }
        IpPais other = (IpPais) object;
        if ((this.ipPaisPK == null && other.ipPaisPK != null) || (this.ipPaisPK != null && !this.ipPaisPK.equals(other.ipPaisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.IpPais[ ipPaisPK=" + ipPaisPK + " ]";
    }
    
}
