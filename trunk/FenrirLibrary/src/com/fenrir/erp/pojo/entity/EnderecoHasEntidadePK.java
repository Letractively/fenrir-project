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
public class EnderecoHasEntidadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_endereco")
    private int idEndereco;
    @Basic(optional = false)
    @Column(name = "id_municipio")
    private int idMunicipio;
    @Basic(optional = false)
    @Column(name = "id_pais")
    private int idPais;
    @Basic(optional = false)
    @Column(name = "id_estado")
    private int idEstado;
    @Basic(optional = false)
    @Column(name = "id_continente")
    private int idContinente;
    @Basic(optional = false)
    @Column(name = "id_regiao_pais")
    private int idRegiaoPais;
    @Basic(optional = false)
    @Column(name = "id_entidade")
    private int idEntidade;

    public EnderecoHasEntidadePK() {
    }

    public EnderecoHasEntidadePK(int idEndereco, int idMunicipio, int idPais, int idEstado, int idContinente, int idRegiaoPais, int idEntidade) {
        this.idEndereco = idEndereco;
        this.idMunicipio = idMunicipio;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idContinente = idContinente;
        this.idRegiaoPais = idRegiaoPais;
        this.idEntidade = idEntidade;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public int getIdRegiaoPais() {
        return idRegiaoPais;
    }

    public void setIdRegiaoPais(int idRegiaoPais) {
        this.idRegiaoPais = idRegiaoPais;
    }

    public int getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(int idEntidade) {
        this.idEntidade = idEntidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEndereco;
        hash += (int) idMunicipio;
        hash += (int) idPais;
        hash += (int) idEstado;
        hash += (int) idContinente;
        hash += (int) idRegiaoPais;
        hash += (int) idEntidade;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnderecoHasEntidadePK)) {
            return false;
        }
        EnderecoHasEntidadePK other = (EnderecoHasEntidadePK) object;
        if (this.idEndereco != other.idEndereco) {
            return false;
        }
        if (this.idMunicipio != other.idMunicipio) {
            return false;
        }
        if (this.idPais != other.idPais) {
            return false;
        }
        if (this.idEstado != other.idEstado) {
            return false;
        }
        if (this.idContinente != other.idContinente) {
            return false;
        }
        if (this.idRegiaoPais != other.idRegiaoPais) {
            return false;
        }
        if (this.idEntidade != other.idEntidade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.EnderecoHasEntidadePK[ idEndereco=" + idEndereco + ", idMunicipio=" + idMunicipio + ", idPais=" + idPais + ", idEstado=" + idEstado + ", idContinente=" + idContinente + ", idRegiaoPais=" + idRegiaoPais + ", idEntidade=" + idEntidade + " ]";
    }
    
}