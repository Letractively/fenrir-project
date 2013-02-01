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
import javax.persistence.JoinColumns;
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
@Table(name = "tbl_municipio")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MunicipioPK municipioPK;
    @Basic(optional = false)
    @Column(name = "cd_cidade_ibge")
    private int cdCidadeIbge;
    @Basic(optional = false)
    @Column(name = "nm_municipio")
    private String nmMunicipio;
    @Basic(optional = false)
    @Column(name = "ic_capital")
    private String icCapital;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipio")
    private Collection<Endereco> enderecoCollection;
    @JoinColumns({
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false),
        @JoinColumn(name = "id_continente", referencedColumnName = "id_continente", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pais pais;
    @JoinColumns({
        @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", insertable = false, updatable = false),
        @JoinColumn(name = "id_regiao_pais", referencedColumnName = "id_regiao_pais", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Estado estado;

    public Municipio() {
    }

    public Municipio(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public Municipio(MunicipioPK municipioPK, int cdCidadeIbge, String nmMunicipio, String icCapital) {
        this.municipioPK = municipioPK;
        this.cdCidadeIbge = cdCidadeIbge;
        this.nmMunicipio = nmMunicipio;
        this.icCapital = icCapital;
    }

    public Municipio(int idMunicipio, int idPais, int idContinente, int idEstado, int idRegiaoPais) {
        this.municipioPK = new MunicipioPK(idMunicipio, idPais, idContinente, idEstado, idRegiaoPais);
    }

    public MunicipioPK getMunicipioPK() {
        return municipioPK;
    }

    public void setMunicipioPK(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public int getCdCidadeIbge() {
        return cdCidadeIbge;
    }

    public void setCdCidadeIbge(int cdCidadeIbge) {
        this.cdCidadeIbge = cdCidadeIbge;
    }

    public String getNmMunicipio() {
        return nmMunicipio;
    }

    public void setNmMunicipio(String nmMunicipio) {
        this.nmMunicipio = nmMunicipio;
    }

    public String getIcCapital() {
        return icCapital;
    }

    public void setIcCapital(String icCapital) {
        this.icCapital = icCapital;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioPK != null ? municipioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.municipioPK == null && other.municipioPK != null) || (this.municipioPK != null && !this.municipioPK.equals(other.municipioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Municipio[ municipioPK=" + municipioPK + " ]";
    }
    
}
