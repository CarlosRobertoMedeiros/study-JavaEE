package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final String COMANDO_JPQL_BUSCAR_FABRICANTES = "From Fabricante"; 

	@Inject
	private EntityManager em;
	
	public void salvar(Fabricante fabricante) {
		em.merge(fabricante);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> bucarTodos() {
		return em.createQuery(COMANDO_JPQL_BUSCAR_FABRICANTES).getResultList();
	}

	@Transactional
	public void excluir(Fabricante fabricanteSelecionado) throws NegocioException{
		//Retorna o estado do entitymanager
		//Sai de Detached para Managed
		Fabricante fabricanteTemp= em.find(Fabricante.class, fabricanteSelecionado.getCodigo());
		
		em.remove(fabricanteTemp);
		em.flush();
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return em.find(Fabricante.class, codigo);
	}
}
