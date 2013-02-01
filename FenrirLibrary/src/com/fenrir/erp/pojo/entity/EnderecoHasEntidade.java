/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_endereco_has_entidade")
@NamedQueries({
    @NamedQuery(name = "EnderecoHasEntidade.findAll", query = "SELECT e FROM EnderecoHasEntidade e")})
public class EnderecoHasEntidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnderecoHasEntidadePK enderecoHasEntidadePK;
    @Basic(optional = false)
    @Column(name = "ic_residencia_atual")
    private boolean icResidenciaAtual;
    @Column(name = "dt_inicio_moradia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInicioMoradia;
    @Column(name = "dt_fim_moradia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFimMoradia;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Entidade entidade;
    @JoinColumns({
        @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", insertable = false, updatable = false),
        @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio", insertable = false, updatable = false),
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false),
        @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", insertable = false, updatable = false),
        @JoinColumn(name = "id_continente", referencedColumnName = "id_continente", insertable = false, updatable = false),
        @JoinColumn(name = "id_regiao_pais", referencedColumnName = "id_regiao_pais", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Endereco endereco;

    public EnderecoHasEntidade() {
    }

    public EnderecoHasEntidade(EnderecoHasEntidadePK enderecoHasEntidadePK) {
        this.enderecoHasEntidadePK = enderecoHasEntidadePK;
    }

    public EnderecoHasEntidade(EnderecoHasEntidadePK enderecoHasEntidadePK, boolean icResidenciaAtual) {
        this.enderecoHasEntidadePK = enderecoHasEntidadePK;
        this.icResidenciaAtual = icResidenciaAtual;
    }

    public EnderecoHasEntidade(int idEndereco, int idMunicipio, int idPais, int idEstado, int idContinente, int idRegiaoPais, int idEntidade) {
        this.enderecoHasEntidadePK = new EnderecoHasEntidadePK(idEndereco, idMunicipio, idPais, idEstado, idContinente, idRegiaoPais, idEntidade);
    }

    public EnderecoHasEntidadePK getEnderecoHasEntidadePK() {
        return enderecoHasEntidadePK;
    }

    public void setEnderecoHasEntidadePK(EnderecoHasEntidadePK enderecoHasEntidadePK) {
        this.enderecoHasEntidadePK = enderecoHasEntidadePK;
    }

    public boolean getIcResidenciaAtual() {
        return icResidenciaAtual;
    }

    public void setIcResidenciaAtual(boolean icResidenciaAtual) {
        this.icResidenciaAtual = icResidenciaAtual;
    }

    public Date getDtInicioMoradia() {
        return dtInicioMoradia;
    }

    public void setDtInicioMoradia(Date dtInicioMoradia) {
        this.dtInicioMoradia = dtInicioMoradia;
    }

    public Date getDtFimMoradia() {
        return dtFimMoradia;
    }

    public void setDtFimMoradia(Date dtFimMoradia) {
        this.dtFimMoradia = dtFimMoradia;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enderecoHasEntidadePK != null ? enderecoHasEntidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnderecoHasEntidade)) {
            return false;
        }
        EnderecoHasEntidade other = (EnderecoHasEntidade) object;
        if ((this.enderecoHasEntidadePK == null && other.enderecoHasEntidadePK != null) || (this.enderecoHasEntidadePK != null && !this.enderecoHasEntidadePK.equals(other.enderecoHasEntidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.EnderecoHasEntidade[ enderecoHasEntidadePK=" + enderecoHasEntidadePK + " ]";
    }
    
}
