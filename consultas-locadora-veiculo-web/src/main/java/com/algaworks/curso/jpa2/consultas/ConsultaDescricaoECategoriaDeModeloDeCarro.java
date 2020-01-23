package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaDescricaoECategoriaDeModeloDeCarro {

	private static final String COMANDO_CONSULTA_CATEGORIA_DE_MODELO_DE_CARRO = " select mc.descricao,mc.categoria from ModeloCarro mc";

	public static void main(String[] args) {

		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Object[]> listaCategoriaModeloCarro = em.createQuery(COMANDO_CONSULTA_CATEGORIA_DE_MODELO_DE_CARRO)
				.getResultList();

		for (Object[] obj : listaCategoriaModeloCarro) {
			System.out.println("Descricao: " + obj[0] + " Categoria: " + obj[1]);
		}

		em.close();

	}

}
