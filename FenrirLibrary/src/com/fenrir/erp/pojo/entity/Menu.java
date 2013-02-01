/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu")
    private Integer idMenu;
    @Basic(optional = false)
    @Column(name = "nm_menu")
    private String nmMenu;
    @Basic(optional = false)
    @Column(name = "nm_viewId")
    private String nmviewId;
    @Column(name = "nm_icone")
    private String nmIcone;
    @Column(name = "id_submenu")
    private Integer idSubmenu;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Menu(Integer idMenu, String nmMenu, String nmviewId) {
        this.idMenu = idMenu;
        this.nmMenu = nmMenu;
        this.nmviewId = nmviewId;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNmMenu() {
        return nmMenu;
    }

    public void setNmMenu(String nmMenu) {
        this.nmMenu = nmMenu;
    }

    public String getNmviewId() {
        return nmviewId;
    }

    public void setNmviewId(String nmviewId) {
        this.nmviewId = nmviewId;
    }

    public String getNmIcone() {
        return nmIcone;
    }

    public void setNmIcone(String nmIcone) {
        this.nmIcone = nmIcone;
    }

    public Integer getIdSubmenu() {
        return idSubmenu;
    }

    public void setIdSubmenu(Integer idSubmenu) {
        this.idSubmenu = idSubmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Menu[ idMenu=" + idMenu + " ]";
    }
    
}
