package com.algaworks.curso.jpa2.consultascomcriteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.algaworks.curso.jpa2.modelo.Cliente;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaComCriteria {
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.createEntityManager();
		
		//consultaSimples(em);
		consultaSimplesComLike(em);

		em.close();
		
	}

	private static void consultaSimplesComLike(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
		
		Root<Cliente> c = criteriaQuery.from(Cliente.class);
		criteriaQuery.select(c);
		criteriaQuery.where(builder.like(c.get("nome"), "Fernando%"));
		List<Cliente> clientes = em.createQuery(criteriaQuery).getResultList();
		
		for (Cliente cliente:clientes) {
			System.out.println("Código"+ cliente.getCodigo());
			System.out.println("Nome"+ cliente.getNome());	
		}
		
	}

	private static void consultaSimples(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
		
		criteriaQuery.from(Cliente.class);
		
		TypedQuery<Cliente> query = em.createQuery(criteriaQuery);
		List<Cliente> clientes = query.getResultList();
		
		for (Cliente cliente:clientes) {
			System.out.println("Código"+ cliente.getCodigo());
			System.out.println("Nome"+ cliente.getNome());
		}
	}

}
