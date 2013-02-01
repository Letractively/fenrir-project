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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_telefones_entidade")
@NamedQueries({
    @NamedQuery(name = "TelefonesEntidade.findAll", query = "SELECT t FROM TelefonesEntidade t")})
public class TelefonesEntidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefonesEntidadePK telefonesEntidadePK;
    @Basic(optional = false)
    @Column(name = "cd_DDI_numero")
    private String cdDDInumero;
    @Basic(optional = false)
    @Column(name = "cd_DDD_numero")
    private String cdDDDnumero;
    @Basic(optional = false)
    @Column(name = "vl_numero")
    private String vlNumero;
    @JoinColumn(name = "id_tipo_telefone", referencedColumnName = "id_tipo_telefone", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoTelefone tipoTelefone;
    @JoinColumn(name = "id_entidadeFK", referencedColumnName = "id_entidade")
    @ManyToOne
    private Entidade identidadeFK;

    public TelefonesEntidade() {
    }

    public TelefonesEntidade(TelefonesEntidadePK telefonesEntidadePK) {
        this.telefonesEntidadePK = telefonesEntidadePK;
    }

    public TelefonesEntidade(TelefonesEntidadePK telefonesEntidadePK, String cdDDInumero, String cdDDDnumero, String vlNumero) {
        this.telefonesEntidadePK = telefonesEntidadePK;
        this.cdDDInumero = cdDDInumero;
        this.cdDDDnumero = cdDDDnumero;
        this.vlNumero = vlNumero;
    }

    public TelefonesEntidade(int idTelefones, int idTipoTelefone) {
        this.telefonesEntidadePK = new TelefonesEntidadePK(idTelefones, idTipoTelefone);
    }

    public TelefonesEntidadePK getTelefonesEntidadePK() {
        return telefonesEntidadePK;
    }

    public void setTelefonesEntidadePK(TelefonesEntidadePK telefonesEntidadePK) {
        this.telefonesEntidadePK = telefonesEntidadePK;
    }

    public String getCdDDInumero() {
        return cdDDInumero;
    }

    public void setCdDDInumero(String cdDDInumero) {
        this.cdDDInumero = cdDDInumero;
    }

    public String getCdDDDnumero() {
        return cdDDDnumero;
    }

    public void setCdDDDnumero(String cdDDDnumero) {
        this.cdDDDnumero = cdDDDnumero;
    }

    public String getVlNumero() {
        return vlNumero;
    }

    public void setVlNumero(String vlNumero) {
        this.vlNumero = vlNumero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Entidade getIdentidadeFK() {
        return identidadeFK;
    }

    public void setIdentidadeFK(Entidade identidadeFK) {
        this.identidadeFK = identidadeFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefonesEntidadePK != null ? telefonesEntidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonesEntidade)) {
            return false;
        }
        TelefonesEntidade other = (TelefonesEntidade) object;
        if ((this.telefonesEntidadePK == null && other.telefonesEntidadePK != null) || (this.telefonesEntidadePK != null && !this.telefonesEntidadePK.equals(other.telefonesEntidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.TelefonesEntidade[ telefonesEntidadePK=" + telefonesEntidadePK + " ]";
    }
    
}
