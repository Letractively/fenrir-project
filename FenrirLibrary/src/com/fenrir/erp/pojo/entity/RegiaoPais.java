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
@Table(name = "tbl_regiao_pais")
@NamedQueries({
    @NamedQuery(name = "RegiaoPais.findAll", query = "SELECT r FROM RegiaoPais r")})
public class RegiaoPais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_regiao_pais")
    private Integer idRegiaoPais;
    @Basic(optional = false)
    @Column(name = "nm_regiao")
    private String nmRegiao;
    @Column(name = "cd_regiao")
    private Integer cdRegiao;
    @Column(name = "cd_geografico")
    private Integer cdGeografico;
    @Basic(optional = false)
    @Column(name = "vl_area")
    private int vlArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regiaoPais")
    private Collection<Estado> estadoCollection;

    public RegiaoPais() {
    }

    public RegiaoPais(Integer idRegiaoPais) {
        this.idRegiaoPais = idRegiaoPais;
    }

    public RegiaoPais(Integer idRegiaoPais, String nmRegiao, int vlArea) {
        this.idRegiaoPais = idRegiaoPais;
        this.nmRegiao = nmRegiao;
        this.vlArea = vlArea;
    }

    public Integer getIdRegiaoPais() {
        return idRegiaoPais;
    }

    public void setIdRegiaoPais(Integer idRegiaoPais) {
        this.idRegiaoPais = idRegiaoPais;
    }

    public String getNmRegiao() {
        return nmRegiao;
    }

    public void setNmRegiao(String nmRegiao) {
        this.nmRegiao = nmRegiao;
    }

    public Integer getCdRegiao() {
        return cdRegiao;
    }

    public void setCdRegiao(Integer cdRegiao) {
        this.cdRegiao = cdRegiao;
    }

    public Integer getCdGeografico() {
        return cdGeografico;
    }

    public void setCdGeografico(Integer cdGeografico) {
        this.cdGeografico = cdGeografico;
    }

    public int getVlArea() {
        return vlArea;
    }

    public void setVlArea(int vlArea) {
        this.vlArea = vlArea;
    }

    public Collection<Estado> getEstadoCollection() {
        return estadoCollection;
    }

    public void setEstadoCollection(Collection<Estado> estadoCollection) {
        this.estadoCollection = estadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegiaoPais != null ? idRegiaoPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegiaoPais)) {
            return false;
        }
        RegiaoPais other = (RegiaoPais) object;
        if ((this.idRegiaoPais == null && other.idRegiaoPais != null) || (this.idRegiaoPais != null && !this.idRegiaoPais.equals(other.idRegiaoPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.RegiaoPais[ idRegiaoPais=" + idRegiaoPais + " ]";
    }
    
}
