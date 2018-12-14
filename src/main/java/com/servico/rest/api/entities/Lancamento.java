package com.servico.rest.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.servico.rest.api.enums.TipoLancamentoEnum;


@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable=true)
	private Date data;
	
	@Column(name = "descricao", nullable=true)
	private String descricao;
	
	@Column(name = "localizacao", nullable=true)
	private String localizacao;
	
	@Column(name = "data_descricao", nullable=true)
	private Date dataCriacao;
	
	@Column(name = "data_atualizacao", nullable=true)
	private Date dataAtualizacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable=true)
	private TipoLancamentoEnum tipo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Funcionario funcionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
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

	public TipoLancamentoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamentoEnum tipo) {
		this.tipo = tipo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
