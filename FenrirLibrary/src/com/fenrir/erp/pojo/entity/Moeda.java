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
@Table(name = "tbl_moeda")
@NamedQueries({
    @NamedQuery(name = "Moeda.findAll", query = "SELECT m FROM Moeda m")})
public class Moeda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_moeda")
    private Integer idMoeda;
    @Basic(optional = false)
    @Column(name = "nm_moeda")
    private String nmMoeda;
    @Column(name = "sg_moeda")
    private String sgMoeda;
    @Column(name = "nm_moeda_singular")
    private String nmMoedaSingular;
    @Column(name = "nm_moeda_plural")
    private String nmMoedaPlural;
    @Column(name = "nm_centesimo")
    private String nmCentesimo;
    @Column(name = "nm_centesimo_singular")
    private String nmCentesimoSingular;
    @Column(name = "nm_centesimo_plural")
    private String nmCentesimoPlural;
    @Column(name = "cd_externo")
    private String cdExterno;
    @Column(name = "cd_mercante")
    private String cdMercante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMoeda")
    private Collection<Pais> paisCollection;

    public Moeda() {
    }

    public Moeda(Integer idMoeda) {
        this.idMoeda = idMoeda;
    }

    public Moeda(Integer idMoeda, String nmMoeda) {
        this.idMoeda = idMoeda;
        this.nmMoeda = nmMoeda;
    }

    public Integer getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(Integer idMoeda) {
        this.idMoeda = idMoeda;
    }

    public String getNmMoeda() {
        return nmMoeda;
    }

    public void setNmMoeda(String nmMoeda) {
        this.nmMoeda = nmMoeda;
    }

    public String getSgMoeda() {
        return sgMoeda;
    }

    public void setSgMoeda(String sgMoeda) {
        this.sgMoeda = sgMoeda;
    }

    public String getNmMoedaSingular() {
        return nmMoedaSingular;
    }

    public void setNmMoedaSingular(String nmMoedaSingular) {
        this.nmMoedaSingular = nmMoedaSingular;
    }

    public String getNmMoedaPlural() {
        return nmMoedaPlural;
    }

    public void setNmMoedaPlural(String nmMoedaPlural) {
        this.nmMoedaPlural = nmMoedaPlural;
    }

    public String getNmCentesimo() {
        return nmCentesimo;
    }

    public void setNmCentesimo(String nmCentesimo) {
        this.nmCentesimo = nmCentesimo;
    }

    public String getNmCentesimoSingular() {
        return nmCentesimoSingular;
    }

    public void setNmCentesimoSingular(String nmCentesimoSingular) {
        this.nmCentesimoSingular = nmCentesimoSingular;
    }

    public String getNmCentesimoPlural() {
        return nmCentesimoPlural;
    }

    public void setNmCentesimoPlural(String nmCentesimoPlural) {
        this.nmCentesimoPlural = nmCentesimoPlural;
    }

    public String getCdExterno() {
        return cdExterno;
    }

    public void setCdExterno(String cdExterno) {
        this.cdExterno = cdExterno;
    }

    public String getCdMercante() {
        return cdMercante;
    }

    public void setCdMercante(String cdMercante) {
        this.cdMercante = cdMercante;
    }

    public Collection<Pais> getPaisCollection() {
        return paisCollection;
    }

    public void setPaisCollection(Collection<Pais> paisCollection) {
        this.paisCollection = paisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMoeda != null ? idMoeda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moeda)) {
            return false;
        }
        Moeda other = (Moeda) object;
        if ((this.idMoeda == null && other.idMoeda != null) || (this.idMoeda != null && !this.idMoeda.equals(other.idMoeda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Moeda[ idMoeda=" + idMoeda + " ]";
    }
    
}
