package exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Usuario;
import util.JPAUtil;

public class TiposBasicos {
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Usuario usuario = new Usuario();
		usuario.setNome("João da Silva");
		usuario.getTelefones().add("(61) 9999-9999");
		usuario.getTelefones().add("(61) 8888-8888");

		em.persist(usuario);
		em.getTransaction().commit();

		em.close();
	}

}
