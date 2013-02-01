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
@Table(name = "tbl_continente")
@NamedQueries({
    @NamedQuery(name = "Continente.findAll", query = "SELECT c FROM Continente c")})
public class Continente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_continente")
    private Integer idContinente;
    @Basic(optional = false)
    @Column(name = "nm_continente")
    private String nmContinente;
    @Column(name = "sg_continente")
    private String sgContinente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "continente")
    private Collection<Pais> paisCollection;

    public Continente() {
    }

    public Continente(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public Continente(Integer idContinente, String nmContinente) {
        this.idContinente = idContinente;
        this.nmContinente = nmContinente;
    }

    public Integer getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public String getNmContinente() {
        return nmContinente;
    }

    public void setNmContinente(String nmContinente) {
        this.nmContinente = nmContinente;
    }

    public String getSgContinente() {
        return sgContinente;
    }

    public void setSgContinente(String sgContinente) {
        this.sgContinente = sgContinente;
    }

    public Collection<Pais> getPaisCollection() {
        return paisCollection;
    }

    public void setPaisCollection(Collection<Pais> paisCollection) {
        this.paisCollection = paisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContinente != null ? idContinente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Continente)) {
            return false;
        }
        Continente other = (Continente) object;
        if ((this.idContinente == null && other.idContinente != null) || (this.idContinente != null && !this.idContinente.equals(other.idContinente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Continente[ idContinente=" + idContinente + " ]";
    }
    
}
