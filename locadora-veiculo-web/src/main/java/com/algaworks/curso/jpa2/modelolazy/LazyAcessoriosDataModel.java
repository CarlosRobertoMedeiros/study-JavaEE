package com.algaworks.curso.jpa2.modelolazy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;

public class LazyAcessoriosDataModel extends LazyDataModel<Acessorio> implements Serializable {

	private static final long serialVersionUID = 1L;

	private AcessorioDAO acessorioDAO;

	public LazyAcessoriosDataModel(AcessorioDAO acessorioDAO) {
		this.acessorioDAO = acessorioDAO;

	}

	@Override
	public List<Acessorio> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Acessorio> acessorios = this.acessorioDAO.buscarComPaginacao(first, pageSize);

		this.setRowCount(this.acessorioDAO.encontrarQuantidadeDeAcessorios().intValue());

		return acessorios;
	}

}
