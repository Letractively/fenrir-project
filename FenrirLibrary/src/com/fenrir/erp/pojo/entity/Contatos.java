/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_contatos")
@NamedQueries({
    @NamedQuery(name = "Contatos.findAll", query = "SELECT l FROM Contatos l")})
public class Contatos implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Contatos.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contatos")
    private Integer idContatos;
    @Basic(optional = false)
    @Column(name = "nm_contato")
    private String nmContato;
    @Column(name = "id_endereco_contato")
    private Integer idEnderecoContato;
    @Column(name = "id_telefone_contato")
    private Integer idTelefoneContato;
    @Column(name = "id_email_contato")
    private Integer idEmailContato;
    @JoinTable(name = "tbl_contato_entidade", joinColumns = {
        @JoinColumn(name = "id_contato", referencedColumnName = "id_contatos")}, inverseJoinColumns = {
        @JoinColumn(name = "id_entidadeFK", referencedColumnName = "id_entidade")})
    @ManyToMany
    private Collection<Entidade> entidadeCollection;
    @JoinColumn(name = "id_entidadeFK", referencedColumnName = "id_entidade")
    @ManyToOne
    private Entidade identidadeFK;

    public Contatos() {
    }

    public Contatos(Integer idContatos) {
        this.idContatos = idContatos;
    }

    public Contatos(Integer idContatos, String nmContato) {
        this.idContatos = idContatos;
        this.nmContato = nmContato;
    }

    public Integer getIdContatos() {
        return idContatos;
    }

    public void setIdContatos(Integer idContatos) {
        this.idContatos = idContatos;
    }

    public String getNmContato() {
        return nmContato;
    }

    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
    }

    public Integer getIdEnderecoContato() {
        return idEnderecoContato;
    }

    public void setIdEnderecoContato(Integer idEnderecoContato) {
        this.idEnderecoContato = idEnderecoContato;
    }

    public Integer getIdTelefoneContato() {
        return idTelefoneContato;
    }

    public void setIdTelefoneContato(Integer idTelefoneContato) {
        this.idTelefoneContato = idTelefoneContato;
    }

    public Integer getIdEmailContato() {
        return idEmailContato;
    }

    public void setIdEmailContato(Integer idEmailContato) {
        this.idEmailContato = idEmailContato;
    }

    public Collection<Entidade> getEntidadeCollection() {
        return entidadeCollection;
    }

    public void setEntidadeCollection(Collection<Entidade> entidadeCollection) {
        this.entidadeCollection = entidadeCollection;
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
        hash += (idContatos != null ? idContatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contatos)) {
            return false;
        }
        Contatos other = (Contatos) object;
        if ((this.idContatos == null && other.idContatos != null) || (this.idContatos != null && !this.idContatos.equals(other.idContatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Contatos[ idContatos=" + idContatos + " ]";
    }
    
}
