package com.javaee.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class GerarTabelas {

		public static void main(String[] args) {
		
			EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
			EntityManager manager = emf.createEntityManager();

			manager.close(); 
			//emf.close();
			System.out.println(">>>>> Tabelas geradas com sucesso! <<<<<<<");
			System.exit(0);
		
		
		}
}
