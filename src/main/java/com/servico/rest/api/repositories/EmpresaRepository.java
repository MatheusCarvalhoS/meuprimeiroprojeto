package com.servico.rest.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servico.rest.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	public Empresa findByCnpj(String cnpj);
}
