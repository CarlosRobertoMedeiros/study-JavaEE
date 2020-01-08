package tecnicasjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tecnicasjpa.entidades.Cliente;

public class AlterandoCliente {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaadvanced");
		EntityManager em = emf.createEntityManager();

		Cliente cliente = em.find(Cliente.class, 2L);

		em.getTransaction().begin();
		cliente.setNome("Antonio Nunes");
		cliente.setIdade(28);
		em.getTransaction().commit();

		em.close();
	}
}
