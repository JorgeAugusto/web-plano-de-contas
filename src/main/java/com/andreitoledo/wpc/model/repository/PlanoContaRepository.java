package com.andreitoledo.wpc.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.andreitoledo.wpc.model.entities.PlanoConta;

public class PlanoContaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public PlanoConta porId(Long id) {
		return manager.find(PlanoConta.class, id);
	}

	public List<PlanoConta> todas() {
		return manager.createQuery("from PlanoConta", PlanoConta.class)
				.getResultList();
	}

	public PlanoConta guardar(PlanoConta planoconta) {
		return manager.merge(planoconta);
	}

	public void remover(PlanoConta planoconta) {
		planoconta = porId(planoconta.getId());
		manager.remove(planoconta);
	}

}
