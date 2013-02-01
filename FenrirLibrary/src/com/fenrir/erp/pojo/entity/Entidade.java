/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.pojo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author felipe-andrade
 */
@Entity
@Table(name = "tbl_entidade")
@NamedQueries({
    @NamedQuery(name = "Entidade.findAll", query = "SELECT e FROM Entidade e")})
public class Entidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entidade")
    private Integer idEntidade;
    @Basic(optional = false)
    @Column(name = "nm_entidade")
    private String nmEntidade;
    @Column(name = "nm_fantasia_entidade")
    private String nmFantasiaEntidade;
    @Column(name = "id_endereco_entidade")
    private Integer idEnderecoEntidade;
    @Column(name = "ds_complemento_entidade")
    private String dsComplementoEntidade;
    @Column(name = "cd_cpfcnpj_entidade")
    private String cdCpfcnpjEntidade;
    @Column(name = "cd_rg_entidade")
    private String cdRgEntidade;
    @Column(name = "cd_inscricao_estadual_entidade")
    private String cdInscricaoEstadualEntidade;
    @Column(name = "cd_inscricao_municipal_entidade")
    private String cdInscricaoMunicipalEntidade;
    @Column(name = "dt_atualizacao_entidade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtualizacaoEntidade;
    @Basic(optional = false)
    @Column(name = "ic_tipo_pessoa_entidade")
    private String icTipoPessoaEntidade;
    @Column(name = "ic_filial_entidade")
    private String icFilialEntidade;
    @Column(name = "ic_franquia_entidade")
    private String icFranquiaEntidade;
    @Column(name = "id_entidade_matriz")
    private Integer idEntidadeMatriz;
    @Column(name = "ic_sexo_entidade")
    private String icSexoEntidade;
    @Column(name = "ic_estado_civil_entidade")
    private String icEstadoCivilEntidade;
    @Basic(optional = false)
    @Column(name = "nm_nacionalidade_entidade")
    private String nmNacionalidadeEntidade;
    @Column(name = "dt_nascimento_entidade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimentoEntidade;
    @Column(name = "ds_observacao_entidade")
    private String dsObservacaoEntidade;
    @Basic(optional = false)
    @Column(name = "ic_ativo")
    private char icAtivo;
    @ManyToMany(mappedBy = "entidadeCollection")
    private Collection<Contatos> lContatosCollection;
    @OneToMany(mappedBy = "identidadeFK")
    private Collection<TelefonesEntidade> telefonesEntidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidade")
    private Collection<RelacionamentoXEntidade> relacionamentoXEntidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidade")
    private Collection<EnderecoHasEntidade> enderecoHasEntidadeCollection;
    @OneToMany(mappedBy = "identidadeFK")
    private Collection<EmailEntidade> emailEntidadeCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "entidade")
    private Usuario usuario;
    @JoinColumn(name = "id_vertical", referencedColumnName = "id_vertical")
    @ManyToOne
    private Vertical idVertical;
    @OneToMany(mappedBy = "identidadeFK")
    private Collection<Contatos> lContatosCollection1;

    public Entidade() {
    }

    public Entidade(Integer idEntidade) {
        this.idEntidade = idEntidade;
    }

    public Entidade(Integer idEntidade, String nmEntidade, String icTipoPessoaEntidade, String nmNacionalidadeEntidade, char icAtivo) {
        this.idEntidade = idEntidade;
        this.nmEntidade = nmEntidade;
        this.icTipoPessoaEntidade = icTipoPessoaEntidade;
        this.nmNacionalidadeEntidade = nmNacionalidadeEntidade;
        this.icAtivo = icAtivo;
    }

    public Integer getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(Integer idEntidade) {
        this.idEntidade = idEntidade;
    }

    public String getNmEntidade() {
        return nmEntidade;
    }

    public void setNmEntidade(String nmEntidade) {
        this.nmEntidade = nmEntidade;
    }

    public String getNmFantasiaEntidade() {
        return nmFantasiaEntidade;
    }

    public void setNmFantasiaEntidade(String nmFantasiaEntidade) {
        this.nmFantasiaEntidade = nmFantasiaEntidade;
    }

    public Integer getIdEnderecoEntidade() {
        return idEnderecoEntidade;
    }

    public void setIdEnderecoEntidade(Integer idEnderecoEntidade) {
        this.idEnderecoEntidade = idEnderecoEntidade;
    }

    public String getDsComplementoEntidade() {
        return dsComplementoEntidade;
    }

    public void setDsComplementoEntidade(String dsComplementoEntidade) {
        this.dsComplementoEntidade = dsComplementoEntidade;
    }

    public String getCdCpfcnpjEntidade() {
        return cdCpfcnpjEntidade;
    }

    public void setCdCpfcnpjEntidade(String cdCpfcnpjEntidade) {
        this.cdCpfcnpjEntidade = cdCpfcnpjEntidade;
    }

    public String getCdRgEntidade() {
        return cdRgEntidade;
    }

    public void setCdRgEntidade(String cdRgEntidade) {
        this.cdRgEntidade = cdRgEntidade;
    }

    public String getCdInscricaoEstadualEntidade() {
        return cdInscricaoEstadualEntidade;
    }

    public void setCdInscricaoEstadualEntidade(String cdInscricaoEstadualEntidade) {
        this.cdInscricaoEstadualEntidade = cdInscricaoEstadualEntidade;
    }

    public String getCdInscricaoMunicipalEntidade() {
        return cdInscricaoMunicipalEntidade;
    }

    public void setCdInscricaoMunicipalEntidade(String cdInscricaoMunicipalEntidade) {
        this.cdInscricaoMunicipalEntidade = cdInscricaoMunicipalEntidade;
    }

    public Date getDtAtualizacaoEntidade() {
        return dtAtualizacaoEntidade;
    }

    public void setDtAtualizacaoEntidade(Date dtAtualizacaoEntidade) {
        this.dtAtualizacaoEntidade = dtAtualizacaoEntidade;
    }

    public String getIcTipoPessoaEntidade() {
        return icTipoPessoaEntidade;
    }

    public void setIcTipoPessoaEntidade(String icTipoPessoaEntidade) {
        this.icTipoPessoaEntidade = icTipoPessoaEntidade;
    }

    public String getIcFilialEntidade() {
        return icFilialEntidade;
    }

    public void setIcFilialEntidade(String icFilialEntidade) {
        this.icFilialEntidade = icFilialEntidade;
    }

    public String getIcFranquiaEntidade() {
        return icFranquiaEntidade;
    }

    public void setIcFranquiaEntidade(String icFranquiaEntidade) {
        this.icFranquiaEntidade = icFranquiaEntidade;
    }

    public Integer getIdEntidadeMatriz() {
        return idEntidadeMatriz;
    }

    public void setIdEntidadeMatriz(Integer idEntidadeMatriz) {
        this.idEntidadeMatriz = idEntidadeMatriz;
    }

    public String getIcSexoEntidade() {
        return icSexoEntidade;
    }

    public void setIcSexoEntidade(String icSexoEntidade) {
        this.icSexoEntidade = icSexoEntidade;
    }

    public String getIcEstadoCivilEntidade() {
        return icEstadoCivilEntidade;
    }

    public void setIcEstadoCivilEntidade(String icEstadoCivilEntidade) {
        this.icEstadoCivilEntidade = icEstadoCivilEntidade;
    }

    public String getNmNacionalidadeEntidade() {
        return nmNacionalidadeEntidade;
    }

    public void setNmNacionalidadeEntidade(String nmNacionalidadeEntidade) {
        this.nmNacionalidadeEntidade = nmNacionalidadeEntidade;
    }

    public Date getDtNascimentoEntidade() {
        return dtNascimentoEntidade;
    }

    public void setDtNascimentoEntidade(Date dtNascimentoEntidade) {
        this.dtNascimentoEntidade = dtNascimentoEntidade;
    }

    public String getDsObservacaoEntidade() {
        return dsObservacaoEntidade;
    }

    public void setDsObservacaoEntidade(String dsObservacaoEntidade) {
        this.dsObservacaoEntidade = dsObservacaoEntidade;
    }

    public char getIcAtivo() {
        return icAtivo;
    }

    public void setIcAtivo(char icAtivo) {
        this.icAtivo = icAtivo;
    }

    public Collection<Contatos> getLContatosCollection() {
        return lContatosCollection;
    }

    public void setLContatosCollection(Collection<Contatos> lContatosCollection) {
        this.lContatosCollection = lContatosCollection;
    }

    public Collection<TelefonesEntidade> getTelefonesEntidadeCollection() {
        return telefonesEntidadeCollection;
    }

    public void setTelefonesEntidadeCollection(Collection<TelefonesEntidade> telefonesEntidadeCollection) {
        this.telefonesEntidadeCollection = telefonesEntidadeCollection;
    }

    public Collection<RelacionamentoXEntidade> getRelacionamentoXEntidadeCollection() {
        return relacionamentoXEntidadeCollection;
    }

    public void setRelacionamentoXEntidadeCollection(Collection<RelacionamentoXEntidade> relacionamentoXEntidadeCollection) {
        this.relacionamentoXEntidadeCollection = relacionamentoXEntidadeCollection;
    }

    public Collection<EnderecoHasEntidade> getEnderecoHasEntidadeCollection() {
        return enderecoHasEntidadeCollection;
    }

    public void setEnderecoHasEntidadeCollection(Collection<EnderecoHasEntidade> enderecoHasEntidadeCollection) {
        this.enderecoHasEntidadeCollection = enderecoHasEntidadeCollection;
    }

    public Collection<EmailEntidade> getEmailEntidadeCollection() {
        return emailEntidadeCollection;
    }

    public void setEmailEntidadeCollection(Collection<EmailEntidade> emailEntidadeCollection) {
        this.emailEntidadeCollection = emailEntidadeCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vertical getIdVertical() {
        return idVertical;
    }

    public void setIdVertical(Vertical idVertical) {
        this.idVertical = idVertical;
    }

    public Collection<Contatos> getLContatosCollection1() {
        return lContatosCollection1;
    }

    public void setLContatosCollection1(Collection<Contatos> lContatosCollection1) {
        this.lContatosCollection1 = lContatosCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidade != null ? idEntidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidade)) {
            return false;
        }
        Entidade other = (Entidade) object;
        if ((this.idEntidade == null && other.idEntidade != null) || (this.idEntidade != null && !this.idEntidade.equals(other.idEntidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fenrir.erp.pojo.entity.Entidade[ idEntidade=" + idEntidade + " ]";
    }
    
}
