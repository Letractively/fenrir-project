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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_vertical")
@NamedQueries({
    @NamedQuery(name = "Vertical.findAll", query = "SELECT v FROM Vertical v")})
public class Vertical implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vertical")
    private Integer idVertical;
    @Basic(optional = false)
    @Column(name = "nm_vertical")
    private String nmVertical;
    @OneToMany(mappedBy = "idVertical")
    private Collection<Entidade> entidadeCollection;

    public Vertical() {
    }

    public Vertical(Integer idVertical) {
        this.idVertical = idVertical;
    }

    public Vertical(Integer idVertical, String nmVertical) {
        this.idVertical = idVertical;
        this.nmVertical = nmVertical;
    }

    public Integer getIdVertical() {
        return idVertical;
    }

    public void setIdVertical(Integer idVertical) {
        this.idVertical = idVertical;
    }

    public String getNmVertical() {
        return nmVertical;
    }

    public void setNmVertical(String nmVertical) {
        this.nmVertical = nmVertical;
    }

    public Collection<Entidade> getEntidadeCollection() {
        return entidadeCollection;
    }

    public void setEntidadeCollection(Collection<Entidade> entidadeCollection) {
        this.entidadeCollection = entidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVertical != null ? idVertical.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vertical)) {
            return false;
        }
        Vertical other = (Vertical) object;
        if ((this.idVertical == null && other.idVertical != null) || (this.idVertical != null && !this.idVertical.equals(other.idVertical))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Vertical[ idVertical=" + idVertical + " ]";
    }
    
}
