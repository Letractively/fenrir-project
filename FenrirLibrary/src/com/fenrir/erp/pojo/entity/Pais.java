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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_pais")
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")})
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaisPK paisPK;
    @Basic(optional = false)
    @Column(name = "cd_bacem")
    private int cdBacem;
    @Basic(optional = false)
    @Column(name = "nm_pais")
    private String nmPais;
    @Column(name = "vl_area_pais")
    private Integer vlAreaPais;
    @JoinColumn(name = "id_moeda", referencedColumnName = "id_moeda")
    @ManyToOne(optional = false)
    private Moeda idMoeda;
    @JoinColumn(name = "id_continente", referencedColumnName = "id_continente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Continente continente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<Municipio> municipioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<IpPais> ipPaisCollection;

    public Pais() {
    }

    public Pais(PaisPK paisPK) {
        this.paisPK = paisPK;
    }

    public Pais(PaisPK paisPK, int cdBacem, String nmPais) {
        this.paisPK = paisPK;
        this.cdBacem = cdBacem;
        this.nmPais = nmPais;
    }

    public Pais(int idPais, int idContinente) {
        this.paisPK = new PaisPK(idPais, idContinente);
    }

    public PaisPK getPaisPK() {
        return paisPK;
    }

    public void setPaisPK(PaisPK paisPK) {
        this.paisPK = paisPK;
    }

    public int getCdBacem() {
        return cdBacem;
    }

    public void setCdBacem(int cdBacem) {
        this.cdBacem = cdBacem;
    }

    public String getNmPais() {
        return nmPais;
    }

    public void setNmPais(String nmPais) {
        this.nmPais = nmPais;
    }

    public Integer getVlAreaPais() {
        return vlAreaPais;
    }

    public void setVlAreaPais(Integer vlAreaPais) {
        this.vlAreaPais = vlAreaPais;
    }

    public Moeda getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(Moeda idMoeda) {
        this.idMoeda = idMoeda;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public Collection<Municipio> getMunicipioCollection() {
        return municipioCollection;
    }

    public void setMunicipioCollection(Collection<Municipio> municipioCollection) {
        this.municipioCollection = municipioCollection;
    }

    public Collection<IpPais> getIpPaisCollection() {
        return ipPaisCollection;
    }

    public void setIpPaisCollection(Collection<IpPais> ipPaisCollection) {
        this.ipPaisCollection = ipPaisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisPK != null ? paisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.paisPK == null && other.paisPK != null) || (this.paisPK != null && !this.paisPK.equals(other.paisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Pais[ paisPK=" + paisPK + " ]";
    }
    
}
