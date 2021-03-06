package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private final static String COMANDO_JPQL_BUSCAR_TODOS_CARROS = "from Carro";
	private final static String COMANDO_JPQL_BUSCAR_QTDE_CARROS = "select count(c) from Carro c ";

	@Inject
	EntityManager manager;

	public Carro bucarPeloCodigo(Long codigo) {
		return manager.find(Carro.class, codigo);
	}

	public void salvar(Carro fabricante) {
		manager.merge(fabricante);
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos() {
		// return manager.createQuery(COMANDO_JPQL_BUSCAR_TODOS_CARROS).getResultList();
		return manager.createNamedQuery("Carro.buscarTodos").getResultList();
	}

	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		carro = this.bucarPeloCodigo(carro.getCodigo());
		try {
			manager.remove(carro);
			manager.flush();
		} catch (PersistenceException e) {
			new NegocioException("Não Foi Possível Excluir o Carro " + e.getMessage());
		}

	}

	public Carro buscarCarroComAcessorios(Long codigo) {
		return manager.createNamedQuery("Carro.buscarCarrosComAcessorios", Carro.class).setParameter("codigo", codigo)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Carro.buscarTodos").setFirstResult(first).setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeCarros() {
		return manager.createQuery(COMANDO_JPQL_BUSCAR_QTDE_CARROS, Long.class).getSingleResult();
	}

}
