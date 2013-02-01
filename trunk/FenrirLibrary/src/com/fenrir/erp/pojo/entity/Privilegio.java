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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_privilegio")
@NamedQueries({
    @NamedQuery(name = "Privilegio.findAll", query = "SELECT p FROM Privilegio p")})
public class Privilegio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_privilegio")
    private Integer idPrivilegio;
    @Basic(optional = false)
    @Column(name = "nm_privilegio")
    private String nmPrivilegio;
    @Basic(optional = false)
    @Column(name = "ds_privilegio")
    private String dsPrivilegio;
    @JoinTable(name = "tbl_usuario_x_privilegio", joinColumns = {
        @JoinColumn(name = "id_privilegioFK", referencedColumnName = "id_privilegio")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuarioFK", referencedColumnName = "id_entidadeFK")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;

    public Privilegio() {
    }

    public Privilegio(Integer idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public Privilegio(Integer idPrivilegio, String nmPrivilegio, String dsPrivilegio) {
        this.idPrivilegio = idPrivilegio;
        this.nmPrivilegio = nmPrivilegio;
        this.dsPrivilegio = dsPrivilegio;
    }

    public Integer getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(Integer idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public String getNmPrivilegio() {
        return nmPrivilegio;
    }

    public void setNmPrivilegio(String nmPrivilegio) {
        this.nmPrivilegio = nmPrivilegio;
    }

    public String getDsPrivilegio() {
        return dsPrivilegio;
    }

    public void setDsPrivilegio(String dsPrivilegio) {
        this.dsPrivilegio = dsPrivilegio;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivilegio != null ? idPrivilegio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegio)) {
            return false;
        }
        Privilegio other = (Privilegio) object;
        if ((this.idPrivilegio == null && other.idPrivilegio != null) || (this.idPrivilegio != null && !this.idPrivilegio.equals(other.idPrivilegio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Privilegio[ idPrivilegio=" + idPrivilegio + " ]";
    }
    
}
