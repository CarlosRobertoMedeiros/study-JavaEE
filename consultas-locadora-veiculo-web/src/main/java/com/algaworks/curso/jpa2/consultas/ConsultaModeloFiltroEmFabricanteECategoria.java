package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltroEmFabricanteECategoria {

	private final static String COMANDO_LISTAR_MODELO_FILTRANDO_FABRICANTE_E_CATEGORIA = " select mc.descricao from ModeloCarro mc "
																						+ " where mc.fabricante.nome ='Honda' "
																						+ " and mc.categoria in ('SEDAN_MEDIO', 'SEDAN_GRANDE')";

	public static void main(String[] args) {

		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		List<String> listaModeloPorFabricanteECategoria = em.createQuery(COMANDO_LISTAR_MODELO_FILTRANDO_FABRICANTE_E_CATEGORIA, String.class).getResultList();

		for (String modeloPorFabricanteECategoria : listaModeloPorFabricanteECategoria) {
			System.out.println(modeloPorFabricanteECategoria);
		}

		em.close();

	}
}
