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
@Table(name = "tbl_endereco")
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnderecoPK enderecoPK;
    @Basic(optional = false)
    @Column(name = "nm_bairro")
    private String nmBairro;
    @Basic(optional = false)
    @Column(name = "ds_logradouro")
    private String dsLogradouro;
    @Column(name = "cd_cep_logradouro")
    private String cdCepLogradouro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endereco")
    private Collection<EnderecoHasEntidade> enderecoHasEntidadeCollection;
    @JoinColumns({
        @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio", insertable = false, updatable = false),
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false),
        @JoinColumn(name = "id_continente", referencedColumnName = "id_continente", insertable = false, updatable = false),
        @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", insertable = false, updatable = false),
        @JoinColumn(name = "id_regiao_pais", referencedColumnName = "id_regiao_pais", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Municipio municipio;

    public Endereco() {
    }

    public Endereco(EnderecoPK enderecoPK) {
        this.enderecoPK = enderecoPK;
    }

    public Endereco(EnderecoPK enderecoPK, String nmBairro, String dsLogradouro) {
        this.enderecoPK = enderecoPK;
        this.nmBairro = nmBairro;
        this.dsLogradouro = dsLogradouro;
    }

    public Endereco(int idEndereco, int idMunicipio, int idPais, int idContinente, int idEstado, int idRegiaoPais) {
        this.enderecoPK = new EnderecoPK(idEndereco, idMunicipio, idPais, idContinente, idEstado, idRegiaoPais);
    }

    public EnderecoPK getEnderecoPK() {
        return enderecoPK;
    }

    public void setEnderecoPK(EnderecoPK enderecoPK) {
        this.enderecoPK = enderecoPK;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getDsLogradouro() {
        return dsLogradouro;
    }

    public void setDsLogradouro(String dsLogradouro) {
        this.dsLogradouro = dsLogradouro;
    }

    public String getCdCepLogradouro() {
        return cdCepLogradouro;
    }

    public void setCdCepLogradouro(String cdCepLogradouro) {
        this.cdCepLogradouro = cdCepLogradouro;
    }

    public Collection<EnderecoHasEntidade> getEnderecoHasEntidadeCollection() {
        return enderecoHasEntidadeCollection;
    }

    public void setEnderecoHasEntidadeCollection(Collection<EnderecoHasEntidade> enderecoHasEntidadeCollection) {
        this.enderecoHasEntidadeCollection = enderecoHasEntidadeCollection;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enderecoPK != null ? enderecoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.enderecoPK == null && other.enderecoPK != null) || (this.enderecoPK != null && !this.enderecoPK.equals(other.enderecoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Endereco[ enderecoPK=" + enderecoPK + " ]";
    }
    
}
