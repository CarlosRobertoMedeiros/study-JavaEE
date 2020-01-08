package tecnicasjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tecnicasjpa.entidades.Cliente;

public class ConsultandoClienteJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaadvanced");
		EntityManager em = emf.createEntityManager();

		String jpqlQuery = "from Cliente where sexo='M'";
		List<Cliente> clientes =  em.createQuery(jpqlQuery, Cliente.class).getResultList();
		
		for(Cliente cliente:clientes) {
			System.out.println(cliente);
		}
		
		
	}
}
