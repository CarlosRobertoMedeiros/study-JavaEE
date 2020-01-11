package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Aluguel;

public class AluguelDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;

	public Aluguel buscaPeloCodigo(Long codigo) {
		return manager.find(Aluguel.class, codigo);
	}

	public void salvar(Aluguel aluguel) {
		manager.merge(aluguel);
	}

}
