package tecnicasjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tecnicasjpa.entidades.Cliente;

public class ConsultandoCliente {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaadvanced");
		EntityManager em = emf.createEntityManager();

		Cliente cliente = em.find(Cliente.class, 1L);

		if (cliente != null) {
			System.out.println(cliente);
		}

		em.close();

	}

}
