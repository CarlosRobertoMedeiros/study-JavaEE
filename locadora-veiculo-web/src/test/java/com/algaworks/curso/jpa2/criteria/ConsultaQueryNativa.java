package com.algaworks.curso.jpa2.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.mysql.cj.Query;

public class ConsultaQueryNativa {
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
	public void consultar() {
		
		// TODO reaplicar o teste
		Query query = (Query) this.manager.createNativeQuery("select * from tb_carro", Carro.class);
		List<Carro> carros = ((javax.persistence.Query) query).getResultList();

		for (Carro c : carros) {
			System.out.println(c.getCodigo() + " - " + c.getPlaca());
		}
		
		System.out.println("------ sem resultados -------");

	}
}
