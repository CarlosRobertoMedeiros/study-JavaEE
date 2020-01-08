package tecnicasjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tecnicasjpa.entidades.Cliente;

public class InserindoCliente {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaadvanced");
		EntityManager em = emf.createEntityManager();


		Cliente cliente = new Cliente("Maria Rita", 20,"F", "Médica");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	

		em.close();

	}

}
