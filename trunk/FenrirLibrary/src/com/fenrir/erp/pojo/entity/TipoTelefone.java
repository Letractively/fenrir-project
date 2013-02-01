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
@Table(name = "tbl_tipo_telefone")
@NamedQueries({
    @NamedQuery(name = "TipoTelefone.findAll", query = "SELECT t FROM TipoTelefone t")})
public class TipoTelefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_telefone")
    private Integer idTipoTelefone;
    @Basic(optional = false)
    @Column(name = "nm_tipo_telefone")
    private String nmTipoTelefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTelefone")
    private Collection<TelefonesEntidade> telefonesEntidadeCollection;

    public TipoTelefone() {
    }

    public TipoTelefone(Integer idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
    }

    public TipoTelefone(Integer idTipoTelefone, String nmTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
        this.nmTipoTelefone = nmTipoTelefone;
    }

    public Integer getIdTipoTelefone() {
        return idTipoTelefone;
    }

    public void setIdTipoTelefone(Integer idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
    }

    public String getNmTipoTelefone() {
        return nmTipoTelefone;
    }

    public void setNmTipoTelefone(String nmTipoTelefone) {
        this.nmTipoTelefone = nmTipoTelefone;
    }

    public Collection<TelefonesEntidade> getTelefonesEntidadeCollection() {
        return telefonesEntidadeCollection;
    }

    public void setTelefonesEntidadeCollection(Collection<TelefonesEntidade> telefonesEntidadeCollection) {
        this.telefonesEntidadeCollection = telefonesEntidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTelefone != null ? idTipoTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTelefone)) {
            return false;
        }
        TipoTelefone other = (TipoTelefone) object;
        if ((this.idTipoTelefone == null && other.idTipoTelefone != null) || (this.idTipoTelefone != null && !this.idTipoTelefone.equals(other.idTipoTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.TipoTelefone[ idTipoTelefone=" + idTipoTelefone + " ]";
    }
    
}
