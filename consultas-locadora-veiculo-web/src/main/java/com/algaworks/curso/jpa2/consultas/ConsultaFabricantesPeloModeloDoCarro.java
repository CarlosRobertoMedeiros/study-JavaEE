package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantesPeloModeloDoCarro {
	private static final String COMANDO_LISTAR_FABRICANTES = "select F from Fabricante f";
	private static final String COMANDO_LISTAR_NOMES_DOS_FABRICANTES_PELO_MODELO_CARRO = "select mc.fabricante.nome from ModeloCarro mc";
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		//Lista de Fabricantes Pelo Modelo 
		List<String>nomedosFabricantes =  em.createQuery(COMANDO_LISTAR_NOMES_DOS_FABRICANTES_PELO_MODELO_CARRO,String.class)
										.getResultList();
		
		for(String nomeFabricante:nomedosFabricantes) {
			System.out.println(nomeFabricante);
		}
		
		
		em.close();
	}
}
