package exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Usuario;
import util.JPAUtil;

public class ConsultaTiposBasicos {
	public static void main(String[] args) {
	
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Usuario usuario = em.find(Usuario.class, 1L);
		System.out.println(usuario.getNome());
		
		for(String telfone:usuario.getTelefones()) {
			System.out.println("Telefone: "+telfone);
		}
		em.close();
		
		
	}
}
