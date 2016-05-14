package com.andreitoledo.wpc.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.wpc.model.entities.PlanoConta;
import com.andreitoledo.wpc.model.repository.PlanoContaRepository;
import com.andreitoledo.wpc.util.Transacional;

public class CadastroPlanocontaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PlanoContaRepository planocontarepository;

	@Transacional
	public void salvar(PlanoConta planoconta) {
		planocontarepository.guardar(planoconta);
	}

	@Transacional
	public void excluir(PlanoConta planoconta) {
		planocontarepository.remover(planoconta);
	}

}
