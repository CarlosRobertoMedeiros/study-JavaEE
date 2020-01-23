package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAcessorioPorModeloDeCarro {

	private static final String COMANDO_LISTAR_ACESSORIO_POR_MODELO_DE_CARRO = " select a.descricao from Carro c join c.acessorios a "
																				+ " where c.modelo.descricao = 'Fit' ";
	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		@SuppressWarnings("unchecked")
		List<String> listaAcessoriosPorModelo = em.createQuery(COMANDO_LISTAR_ACESSORIO_POR_MODELO_DE_CARRO)
					.getResultList();
		
		for(String acessorioPorModelo:listaAcessoriosPorModelo) {
			System.out.println("Modelo: " + acessorioPorModelo);
		}
		
		
		
		em.close();
	}
}
