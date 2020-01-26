package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private final static String COMANDO_JPQL_BUSCAR_TODOS_MODELOS = "from ModeloCarro";
	private final static String COMANDO_JPQL_BUSCAR_QTDE_TODOS_MODELOS = "select count(mc) from ModeloCarro mc";

	@Inject
	private EntityManager entityManager;

	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return entityManager.find(ModeloCarro.class, codigo);
	}

	public void salvar(ModeloCarro modeloCarro) {
		entityManager.merge(modeloCarro);
	}

	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() {
		return entityManager.createQuery(COMANDO_JPQL_BUSCAR_TODOS_MODELOS).getResultList();
	}

	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException {
		modeloCarro = this.buscarPeloCodigo(modeloCarro.getCodigo());
		try {
			entityManager.remove(modeloCarro);
			entityManager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esse modelo não pode ser excluído " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarComPaginacao(int first, int pageSize) {
		return entityManager.createQuery(COMANDO_JPQL_BUSCAR_TODOS_MODELOS)
				.setFirstResult(first)
				.setMaxResults(pageSize)
				.getResultList();	
	}

	public Long encontrarQuantidadeDeModeloDeCarros() {
		return entityManager.createQuery(COMANDO_JPQL_BUSCAR_QTDE_TODOS_MODELOS, Long.class).getSingleResult();
	}

}
