package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloCarroFiltrandoFabricante {

	private static final String COMANDO_LISTAR_CARRO_POR_FABRICANTE_COM_FILTRO = "select mc.descricao from ModeloCarro mc "
																				+ "	where mc.fabricante.nome='Honda'";
	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		List<String> nomeDosModelosDeCarroPorFabricanteComFiltro =  em.createQuery(COMANDO_LISTAR_CARRO_POR_FABRICANTE_COM_FILTRO,String.class)
			.getResultList();
		
		for (String nomeModeloCarroFabricanteComFiltro:nomeDosModelosDeCarroPorFabricanteComFiltro) {
			System.out.println(nomeModeloCarroFabricanteComFiltro);
		}
		
		em.close();
		
	}
	
}
