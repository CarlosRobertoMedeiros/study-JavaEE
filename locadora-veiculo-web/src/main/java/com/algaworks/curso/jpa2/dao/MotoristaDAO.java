package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class MotoristaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	private final static String COMANDO_JPQL_BUSCAR_TODOS_MOTORISTAS = "from Motorista";
	private final static String COMANDO_JPQL_BUSCAR_QTDE_MOTORISTAS = "select count(m) from Motorista m";
	
	@Inject
	private EntityManager manager;
	
	public Motorista buscarPeloCodigo(Long codigo) {
		return manager.find(Motorista.class,codigo);
	}
	
	public void salvar(Motorista motorista) {
		manager.merge(motorista);
	}
	
	@SuppressWarnings("unchecked")
	public List<Motorista> buscarTodos(){
		return manager.createQuery(COMANDO_JPQL_BUSCAR_TODOS_MOTORISTAS).getResultList();
	}
	
	@Transactional
	public void excluir(Motorista motorista) throws NegocioException{
		Motorista motoristaTemp = buscarPeloCodigo(motorista.getCodigo());
		try {
			manager.remove(motoristaTemp);
			manager.flush();
		} catch (PersistenceException ex) {
			throw new NegocioException("Motorista não pode ser excluído !!!");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Motorista> buscarComPaginacao(int first, int pageSize) {
		return manager.createQuery(COMANDO_JPQL_BUSCAR_TODOS_MOTORISTAS)
				.setFirstResult(first)
				.setMaxResults(pageSize)
				.getResultList();			
	}

	public Long encontrarQuantidadeDeFuncionarios() {
		return manager.createQuery(COMANDO_JPQL_BUSCAR_QTDE_MOTORISTAS, Long.class).getSingleResult();	
	}
	
	
	

}
