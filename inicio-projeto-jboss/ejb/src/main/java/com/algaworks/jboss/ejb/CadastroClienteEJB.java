package com.algaworks.jboss.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.jboss.modelo.Cliente;

@Stateless
public class CadastroClienteEJB {
	
	private final String BUSCAR_TODOS_CLIENTES = "from Cliente c";
	
	@PersistenceContext(unitName = "projetoJbossPU")
	private EntityManager em;
	
	public void salvar(Cliente cliente) {
		em.persist(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		return em.createQuery(BUSCAR_TODOS_CLIENTES).getResultList();
	}
	
}
