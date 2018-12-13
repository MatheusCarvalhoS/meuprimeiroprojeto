package com.servico.rest.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "razao_social", nullable = true)
	private String razaoSocial;

	@Column(name = "cnpj", nullable = true)
	private String cnpj;

	@Column(name = "data_criacao", nullable = true)
	private Date dataCriacao;

	@Column(name = "data_atualizacao", nullable = true)
	private Date dataAtualizacao;

	/**
	 * Fecth -> Como ele irá obter os funcionários
	 * 		EAGER -> Irá executar uma segunda consulta para buscar os funcionários caso o funcionario seja ncessário
	 * 		LAZY  -> Não quer a lista de funcionários quando trazer uma empresa - Chamada preguiçosa mais utilizada
	 */ 
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> listFuncionarios;

	public Empresa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public List<Funcionario> getListFuncionarios() {
		return listFuncionarios;
	}

	public void setListFuncionarios(List<Funcionario> listFuncionarios) {
		this.listFuncionarios = listFuncionarios;
	}

	@PreUpdate
	public void preUpdate() {
		this.dataAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		this.dataCriacao = atual;
		this.dataAtualizacao = atual;
	}

}
