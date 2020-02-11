package com.javaee.jpa.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.javaee.jpa.utils.JPAUtil;
import com.javaee.jpa21.model.Usuario;

public class UsuarioPersistenceTest {
	
	private static EntityManagerFactory fabrica;

	private EntityManager manager;

	@BeforeClass
	public static void init() {
		fabrica =  JPAUtil.createEntityManager().getEntityManagerFactory();
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
	public void deveRetornarDataNascUsuario() {
		Usuario usuario = manager.find(Usuario.class, 1L);
		
		assertEquals(LocalDate.of(1990, 10, 02), usuario.getDataNasc());
		
	}

}
