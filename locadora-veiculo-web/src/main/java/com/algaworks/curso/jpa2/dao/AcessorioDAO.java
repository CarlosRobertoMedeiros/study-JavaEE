package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String COMANDO_JPQL_LISTAR_TODOS_ACESSORIOS = "from Acessorio";
	private static final String COMANDO_JPQL_BUSCAR_QTDE_ACESSORIOS = "select count(a) from Acessorio a";

	@Inject
	EntityManager manager;

	public Acessorio buscarPeloCodigo(Long codigo) {
		return manager.find(Acessorio.class, codigo);
	}

	public void salvar(Acessorio acessorio) {
		manager.merge(acessorio);
	}

	@SuppressWarnings("unchecked")
	public List<Acessorio> buscarTodos() {
		return manager.createQuery(COMANDO_JPQL_LISTAR_TODOS_ACESSORIOS).getResultList();
	}

	@Transactional
	public void excluir(Acessorio acessorio) throws NegocioException {
		acessorio = manager.find(Acessorio.class, acessorio.getCodigo());
		try {
			manager.remove(acessorio);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Problema ao Excluir o Acessorio " + e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public List<Acessorio> buscarComPaginacao(int first, int pageSize) {
		return manager.createQuery(COMANDO_JPQL_LISTAR_TODOS_ACESSORIOS).setFirstResult(first).setMaxResults(pageSize)
				.getResultList();

	}

	public Long encontrarQuantidadeDeAcessorios() {
		return manager.createQuery(COMANDO_JPQL_BUSCAR_QTDE_ACESSORIOS, Long.class).getSingleResult();
	}

}
