package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FuncionarioDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final static String COMANDO_JPQL_LISTAR_TODOS_FUNCIONARIOS = "from Funcionario";
	private final static String COMANDO_JPQL_BUSCAR_QTDE_FUNCIONARIOS = "select count(f) from Funcionario f";
	
	@Inject
	EntityManager manager;
	
	public Funcionario buscarPeloCodigo(Long codigo) {
		return manager.find(Funcionario.class, codigo);
	}
	
	public void salvar(Funcionario funcionario) {
		manager.merge(funcionario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos(){
		return manager.createQuery(COMANDO_JPQL_LISTAR_TODOS_FUNCIONARIOS).getResultList();
	}
	
	@Transactional
	public void excluir(Funcionario funcionario) throws NegocioException {
		Funcionario funcionarioTemp = this.buscarPeloCodigo(funcionario.getCodigo());
		try {
			manager.remove(funcionarioTemp);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarComPaginacao(int first, int pageSize) {
		return manager.createQuery(COMANDO_JPQL_LISTAR_TODOS_FUNCIONARIOS)
				.setFirstResult(first)
				.setMaxResults(pageSize)
				.getResultList();		
	}

	public Long encontrarQuantidadeDeFuncionarios() {
		return manager.createQuery(COMANDO_JPQL_BUSCAR_QTDE_FUNCIONARIOS, Long.class).getSingleResult();	
	}
	

}
