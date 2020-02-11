package com.javaee.jpa.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.javaee.jpa.utils.JPAUtil;

public class FaturaPersistenceTest {
	
	private static EntityManagerFactory fabrica;

	private EntityManager manager;

	@BeforeClass
	public static void init() {
		fabrica =  JPAUtil.createEntityManager().getEntityManagerFactory();
	}

	@Before
	public void setUp() {
		this.manager = fabrica.createEntityManager();
		
		if (!this.manager.getTransaction().isActive()) {
			this.manager.getTransaction().begin();
		}
	}

	@After
	public void tearDown() {
		if (this.manager.getTransaction().isActive()) {
			this.manager.getTransaction().commit();
		}
		
		this.manager.close();
	}

	
	@Test
	public void deveAtualizarFaturasVencidas() {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaUpdate<Fatura> criteria = builder.createCriteriaUpdate(Fatura.class);
		Root<Fatura> root = criteria.from(Fatura.class);

		criteria.set("vencida", true)
			.where(builder.lessThan(root.<Date>get("vencimento"), new Date()));
		
		Query query = this.manager.createQuery(criteria);
		query.executeUpdate();
	}
	
	@Test
	public void deveDeletarFaturasVencidas() {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaDelete<Fatura> criteria = builder.createCriteriaDelete(Fatura.class);
		Root<Fatura> root = criteria.from(Fatura.class);

		criteria.where(builder.lessThan(root.<Date>get("vencimento"), new Date()));
		
		Query query = this.manager.createQuery(criteria);
		query.executeUpdate();
	}

}
