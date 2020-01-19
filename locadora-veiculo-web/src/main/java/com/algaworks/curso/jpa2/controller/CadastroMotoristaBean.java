package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.modelo.Sexo;
import com.algaworks.curso.jpa2.service.CadastroMotoristaService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Motorista motorista;
	private List<Sexo> sexos;

	@Inject
	CadastroMotoristaService cadastroMotoristaService;

	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.sexos = Arrays.asList(Sexo.values());
	}

	public void salvar() {
		this.cadastroMotoristaService.salvar(motorista);
		FacesUtil.addSuccessMessage("Motorista Salvo com Sucesso !!!");

		this.limpar();
	}

	private void limpar() {
		this.motorista = new Motorista();

	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public List<Sexo> getSexos() {
		return sexos;
	}
	//Continuar o vídeo 5.4 A partir de 10 minutos
}
