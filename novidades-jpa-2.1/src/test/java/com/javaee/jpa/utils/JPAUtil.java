package com.javaee.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("novidadesJPA21PU");

	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

}
