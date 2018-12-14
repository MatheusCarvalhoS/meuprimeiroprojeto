package com.servico.rest.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.servico.rest.api.enums.PerfilEnum;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "senha", nullable = true)
	private String senha;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "valor_hora", nullable = true)
	private BigDecimal valorHora;
	
	@Column(name = "qtd_horas_trabalho_dia", nullable = true)
	private Float qtdHorasTrabalhoDia;
	
	@Column(name = "qtd_horas_almoco", nullable = true)
	private Float qtdHorasAlmoco;
	
	@Enumerated(EnumType.STRING) // Diz ao JOP para salvar a referência textual e não o inteiro
	@Column(name = "perfil", nullable = true)
	private PerfilEnum perfil;
	
	@Column(name = "data_criacao", nullable = true)
	private Date dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = true)
	private Date dataAtualizacao;

	@ManyToOne(fetch = FetchType.EAGER) //////////////////////////////////////////////////////////
	private Empresa empresa;
	
	@OneToMany(mappedBy = "lancamento", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Lancamento> lancamentos;

	Funcionario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}

	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Lancamento> getListLancamentos() {
		return lancamentos;
	}

	public void setListLancamentos(List<Lancamento> listLancamentos) {
		this.lancamentos = listLancamentos;
	}
	
	@PreUpdate
	public void preUpdate() {
		this.dataAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		this.dataCriacao = this.dataAtualizacao = new Date();
	}
	
}
