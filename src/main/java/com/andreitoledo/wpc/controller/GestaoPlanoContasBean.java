package com.andreitoledo.wpc.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.andreitoledo.wpc.model.entities.PlanoConta;
import com.andreitoledo.wpc.model.repository.PlanoContaRepository;
import com.andreitoledo.wpc.service.CadastroPlanocontaService;
import com.andreitoledo.wpc.util.FacesMessages;

@Named
@ViewScoped
public class GestaoPlanoContasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PlanoContaRepository contas;

	@Inject
	private CadastroPlanocontaService cadastroConta;

	@Inject
	private FacesMessages messages;

	private List<PlanoConta> todasContas;
	private PlanoConta contaEdicao = new PlanoConta();
	private PlanoConta contaSelecionada;

	public void prepararNovoCadastro() {
		contaEdicao = new PlanoConta();
	}

	public void salvar() {
		cadastroConta.salvar(contaEdicao);
		consultar();

		messages.info("Empresa salva com sucesso !");

		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:contas-table"));
	}

	public void excluir() {
		cadastroConta.excluir(contaSelecionada);
		contaSelecionada = null;

		consultar();

		messages.info("Empresa excluída com sucesso !");
	}

	public void consultar() {
		todasContas = contas.todas();
	}

	public PlanoConta getContaEdicao() {
		return contaEdicao;
	}

	public void setContaEdicao(PlanoConta contaEdicao) {
		this.contaEdicao = contaEdicao;
	}

	public PlanoConta getContaSelecionada() {
		return contaSelecionada;
	}

	public void setContaSelecionada(PlanoConta contaSelecionada) {
		this.contaSelecionada = contaSelecionada;
	}

	public List<PlanoConta> getTodasContas() {
		return todasContas;
	}

}
