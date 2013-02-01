/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_entidadeFK")
    private Integer identidadeFK;
    @Basic(optional = false)
    @Column(name = "nm_login_usuario")
    private String nmLoginUsuario;
    @Basic(optional = false)
    @Column(name = "nm_senha_usuario")
    private String nmSenhaUsuario;
    @Column(name = "vl_ip_usuario")
    private String vlIpUsuario;
    @Basic(optional = false)
    @Column(name = "ic_ativo")
    private char icAtivo;
    @Basic(optional = false)
    @Column(name = "nm_pergunta_secreta")
    private String nmPerguntaSecreta;
    @Basic(optional = false)
    @Column(name = "nm_resposta_secreta")
    private String nmRespostaSecreta;
    @Column(name = "dt_ultimo_acesso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUltimoAcesso;
    @Column(name = "qtd_acessos_usuario")
    private Integer qtdAcessosUsuario;
    @Column(name = "id_cadastro_usuario")
    private Integer idCadastroUsuario;
    @Basic(optional = false)
    @Column(name = "dt_cadastro_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastroUsuario;
    @Column(name = "id_exclusao_usuario")
    private Integer idExclusaoUsuario;
    @Column(name = "dt_exclusao_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtExclusaoUsuario;
    @Column(name = "id_update_usuario")
    private Integer idUpdateUsuario;
    @Column(name = "dt_update_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUpdateUsuario;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Privilegio> privilegioCollection;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Sistema> sistemaCollection;
    @JoinColumn(name = "id_entidadeFK", referencedColumnName = "id_entidade", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Entidade entidade;

    public Usuario() {
    }

    public Usuario(Integer identidadeFK) {
        this.identidadeFK = identidadeFK;
    }

    public Usuario(Integer identidadeFK, String nmLoginUsuario, String nmSenhaUsuario, char icAtivo, String nmPerguntaSecreta, String nmRespostaSecreta, Date dtCadastroUsuario) {
        this.identidadeFK = identidadeFK;
        this.nmLoginUsuario = nmLoginUsuario;
        this.nmSenhaUsuario = nmSenhaUsuario;
        this.icAtivo = icAtivo;
        this.nmPerguntaSecreta = nmPerguntaSecreta;
        this.nmRespostaSecreta = nmRespostaSecreta;
        this.dtCadastroUsuario = dtCadastroUsuario;
    }

    public Integer getIdentidadeFK() {
        return identidadeFK;
    }

    public void setIdentidadeFK(Integer identidadeFK) {
        this.identidadeFK = identidadeFK;
    }

    public String getNmLoginUsuario() {
        return nmLoginUsuario;
    }

    public void setNmLoginUsuario(String nmLoginUsuario) {
        this.nmLoginUsuario = nmLoginUsuario;
    }

    public String getNmSenhaUsuario() {
        return nmSenhaUsuario;
    }

    public void setNmSenhaUsuario(String nmSenhaUsuario) {
        this.nmSenhaUsuario = nmSenhaUsuario;
    }

    public String getVlIpUsuario() {
        return vlIpUsuario;
    }

    public void setVlIpUsuario(String vlIpUsuario) {
        this.vlIpUsuario = vlIpUsuario;
    }

    public char getIcAtivo() {
        return icAtivo;
    }

    public void setIcAtivo(char icAtivo) {
        this.icAtivo = icAtivo;
    }

    public String getNmPerguntaSecreta() {
        return nmPerguntaSecreta;
    }

    public void setNmPerguntaSecreta(String nmPerguntaSecreta) {
        this.nmPerguntaSecreta = nmPerguntaSecreta;
    }

    public String getNmRespostaSecreta() {
        return nmRespostaSecreta;
    }

    public void setNmRespostaSecreta(String nmRespostaSecreta) {
        this.nmRespostaSecreta = nmRespostaSecreta;
    }

    public Date getDtUltimoAcesso() {
        return dtUltimoAcesso;
    }

    public void setDtUltimoAcesso(Date dtUltimoAcesso) {
        this.dtUltimoAcesso = dtUltimoAcesso;
    }

    public Integer getQtdAcessosUsuario() {
        return qtdAcessosUsuario;
    }

    public void setQtdAcessosUsuario(Integer qtdAcessosUsuario) {
        this.qtdAcessosUsuario = qtdAcessosUsuario;
    }

    public Integer getIdCadastroUsuario() {
        return idCadastroUsuario;
    }

    public void setIdCadastroUsuario(Integer idCadastroUsuario) {
        this.idCadastroUsuario = idCadastroUsuario;
    }

    public Date getDtCadastroUsuario() {
        return dtCadastroUsuario;
    }

    public void setDtCadastroUsuario(Date dtCadastroUsuario) {
        this.dtCadastroUsuario = dtCadastroUsuario;
    }

    public Integer getIdExclusaoUsuario() {
        return idExclusaoUsuario;
    }

    public void setIdExclusaoUsuario(Integer idExclusaoUsuario) {
        this.idExclusaoUsuario = idExclusaoUsuario;
    }

    public Date getDtExclusaoUsuario() {
        return dtExclusaoUsuario;
    }

    public void setDtExclusaoUsuario(Date dtExclusaoUsuario) {
        this.dtExclusaoUsuario = dtExclusaoUsuario;
    }

    public Integer getIdUpdateUsuario() {
        return idUpdateUsuario;
    }

    public void setIdUpdateUsuario(Integer idUpdateUsuario) {
        this.idUpdateUsuario = idUpdateUsuario;
    }

    public Date getDtUpdateUsuario() {
        return dtUpdateUsuario;
    }

    public void setDtUpdateUsuario(Date dtUpdateUsuario) {
        this.dtUpdateUsuario = dtUpdateUsuario;
    }

    public Collection<Privilegio> getPrivilegioCollection() {
        return privilegioCollection;
    }

    public void setPrivilegioCollection(Collection<Privilegio> privilegioCollection) {
        this.privilegioCollection = privilegioCollection;
    }

    public Collection<Sistema> getSistemaCollection() {
        return sistemaCollection;
    }

    public void setSistemaCollection(Collection<Sistema> sistemaCollection) {
        this.sistemaCollection = sistemaCollection;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identidadeFK != null ? identidadeFK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.identidadeFK == null && other.identidadeFK != null) || (this.identidadeFK != null && !this.identidadeFK.equals(other.identidadeFK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Usuario[ identidadeFK=" + identidadeFK + " ]";
    }
    
}
