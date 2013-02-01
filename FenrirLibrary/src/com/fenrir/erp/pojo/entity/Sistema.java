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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_sistema")
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s")})
public class Sistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sistema")
    private Integer idSistema;
    @Basic(optional = false)
    @Column(name = "nm_sistema")
    private String nmSistema;
    @Column(name = "nm_link")
    private String nmLink;
    @Column(name = "nm_icone")
    private String nmIcone;
    @JoinTable(name = "tbl_usuario_x_sistema", joinColumns = {
        @JoinColumn(name = "id_sistemaFK", referencedColumnName = "id_sistema")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuarioFK", referencedColumnName = "id_entidadeFK")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistema")
    private Collection<RelacionamentoXEntidade> relacionamentoXEntidadeCollection;

    public Sistema() {
    }

    public Sistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public Sistema(Integer idSistema, String nmSistema) {
        this.idSistema = idSistema;
        this.nmSistema = nmSistema;
    }

    public Integer getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public String getNmSistema() {
        return nmSistema;
    }

    public void setNmSistema(String nmSistema) {
        this.nmSistema = nmSistema;
    }

    public String getNmLink() {
        return nmLink;
    }

    public void setNmLink(String nmLink) {
        this.nmLink = nmLink;
    }

    public String getNmIcone() {
        return nmIcone;
    }

    public void setNmIcone(String nmIcone) {
        this.nmIcone = nmIcone;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Collection<RelacionamentoXEntidade> getRelacionamentoXEntidadeCollection() {
        return relacionamentoXEntidadeCollection;
    }

    public void setRelacionamentoXEntidadeCollection(Collection<RelacionamentoXEntidade> relacionamentoXEntidadeCollection) {
        this.relacionamentoXEntidadeCollection = relacionamentoXEntidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSistema != null ? idSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.idSistema == null && other.idSistema != null) || (this.idSistema != null && !this.idSistema.equals(other.idSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Sistema[ idSistema=" + idSistema + " ]";
    }
    
}
