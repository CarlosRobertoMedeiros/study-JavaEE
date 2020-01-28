package com.algaworks.curso.jpa2.entitymanagerlifecicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Cliente;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class TestadorDeCicloDeVida {
	
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Fernando Alonso");
		cliente1.setIdade(32);
		cliente1.setProfissao("Piloto");
		cliente1.setSexo("M");
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(cliente1);
		em.getTransaction().commit();
		em.detach(cliente1);
		
		
		//em.close();
		
		/*
		 * Gerenciador de Transação não vai aceitar pois o EntityManage fechou
		try {
			em.getTransaction().begin();
			cliente1.setIdade(33);
			em.persist(cliente1);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Erro ao persistir a entidade. " + e.getMessage());
			em.getTransaction().rollback();
		}
		*/
		
		//Buscando o Cliente para Retornar o EntityManager como Managed
		cliente1 = em.find(Cliente.class, 7L);
		em.getTransaction().begin();
		cliente1.setIdade(33); // Agora sim conseguimos alterar a idade
		em.getTransaction().commit();
		
		//removendo o Cliente
		em.getTransaction().begin();
		em.remove(cliente1);
		em.getTransaction().commit();
		
		
		// Reconectando um objeto removido.
		//No merge a alteração é feita no outro objeto
		Cliente cliente2 = em.merge(cliente1);
		System.out.println(cliente1 == cliente2);
		em.getTransaction().begin();
		cliente1.setIdade(34); // Não irá alterar a idade!
		em.getTransaction().commit();
				
		em.getTransaction().begin();
		cliente2.setIdade(34); // Agora sim irá alterar a idade.
		em.getTransaction().commit();
		
	}
}
