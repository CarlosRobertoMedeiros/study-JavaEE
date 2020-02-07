package com.algaworks.curso.jpa2.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;

public class ProblemaNMaisUm {
	
	private static EntityManagerFactory fabrica;

	private EntityManager manager;

	@BeforeClass
	public static void init() {
		fabrica = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}

	@Before
	public void setUp() {
		this.manager = fabrica.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}
	
	@Test
	public void problema() {
		//TODO reaplicar  o teste
		TypedQuery<Carro> query = this.manager.createQuery("from Carro c ",Carro.class);
		List<Carro> carros = query.getResultList();
		
		for(Carro c:carros) {
			System.out.println(c.getPlaca()+" - "+c.getModelo().getDescricao());
		}
	}

}
