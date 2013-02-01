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
@Table(name = "tbl_estado")
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")})
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadoPK estadoPK;
    @Basic(optional = false)
    @Column(name = "cd_estado_ibge")
    private int cdEstadoIbge;
    @Basic(optional = false)
    @Column(name = "nm_estado")
    private String nmEstado;
    @Basic(optional = false)
    @Column(name = "sg_uf")
    private String sgUf;
    @Basic(optional = false)
    @Column(name = "vl_municipios")
    private int vlMunicipios;
    @Column(name = "vl_eleitores")
    private Integer vlEleitores;
    @Column(name = "vl_sess\u00f5es")
    private Integer vlSessões;
    @Column(name = "cd_geografico")
    private Integer cdGeografico;
    @JoinColumn(name = "id_regiao_pais", referencedColumnName = "id_regiao_pais", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RegiaoPais regiaoPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Municipio> municipioCollection;

    public Estado() {
    }

    public Estado(EstadoPK estadoPK) {
        this.estadoPK = estadoPK;
    }

    public Estado(EstadoPK estadoPK, int cdEstadoIbge, String nmEstado, String sgUf, int vlMunicipios) {
        this.estadoPK = estadoPK;
        this.cdEstadoIbge = cdEstadoIbge;
        this.nmEstado = nmEstado;
        this.sgUf = sgUf;
        this.vlMunicipios = vlMunicipios;
    }

    public Estado(int idEstado, int idRegiaoPais) {
        this.estadoPK = new EstadoPK(idEstado, idRegiaoPais);
    }

    public EstadoPK getEstadoPK() {
        return estadoPK;
    }

    public void setEstadoPK(EstadoPK estadoPK) {
        this.estadoPK = estadoPK;
    }

    public int getCdEstadoIbge() {
        return cdEstadoIbge;
    }

    public void setCdEstadoIbge(int cdEstadoIbge) {
        this.cdEstadoIbge = cdEstadoIbge;
    }

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    public String getSgUf() {
        return sgUf;
    }

    public void setSgUf(String sgUf) {
        this.sgUf = sgUf;
    }

    public int getVlMunicipios() {
        return vlMunicipios;
    }

    public void setVlMunicipios(int vlMunicipios) {
        this.vlMunicipios = vlMunicipios;
    }

    public Integer getVlEleitores() {
        return vlEleitores;
    }

    public void setVlEleitores(Integer vlEleitores) {
        this.vlEleitores = vlEleitores;
    }

    public Integer getVlSessões() {
        return vlSessões;
    }

    public void setVlSessões(Integer vlSessões) {
        this.vlSessões = vlSessões;
    }

    public Integer getCdGeografico() {
        return cdGeografico;
    }

    public void setCdGeografico(Integer cdGeografico) {
        this.cdGeografico = cdGeografico;
    }

    public RegiaoPais getRegiaoPais() {
        return regiaoPais;
    }

    public void setRegiaoPais(RegiaoPais regiaoPais) {
        this.regiaoPais = regiaoPais;
    }

    public Collection<Municipio> getMunicipioCollection() {
        return municipioCollection;
    }

    public void setMunicipioCollection(Collection<Municipio> municipioCollection) {
        this.municipioCollection = municipioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoPK != null ? estadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.estadoPK == null && other.estadoPK != null) || (this.estadoPK != null && !this.estadoPK.equals(other.estadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Estado[ estadoPK=" + estadoPK + " ]";
    }
    
}
