package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantes {

	private static final String COMANDO_LISTAR_FABRICANTES = "select F from Fabricante f";
	private static final String COMANDO_LISTAR_NOMES_DOS_FABRICANTES = "select F.nome from Fabricante f";

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		// Lista de Fabricantes
		List<Fabricante> fabricantes = em.createQuery(COMANDO_LISTAR_FABRICANTES, Fabricante.class).getResultList();

		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante);
		}

		// Listar nome dos Fabricantes
		List<String> nomesDosFabricantes = em.createQuery(COMANDO_LISTAR_NOMES_DOS_FABRICANTES, String.class)
				.getResultList();

		for (String nomeFabricante : nomesDosFabricantes) {
			System.out.println("Nome: "+nomeFabricante);
		}

		em.close();
	}
}
