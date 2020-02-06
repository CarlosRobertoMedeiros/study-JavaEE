package exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Telefone;
import model.UsuarioComTelefoneEmbutido;
import util.JPAUtil;

public class ObjetoEmbutidoTipoUsuarioCollection {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		UsuarioComTelefoneEmbutido usuario = new UsuarioComTelefoneEmbutido();
		usuario.setNome("Maria Da Silva");
		usuario.getTelefones().add(new  Telefone("61", "9999-8888", "1"));
		usuario.getTelefones().add(new  Telefone("61", "9999-9999", null));
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
//		Veiculo v = em.find(Veiculo.class, new VeiculoId("ABC-1234","Brasília"));
//		System.out.println(v.getCodigo().getPlaca()+" - "+ v.getCodigo().getCidade());
		
		
		em.close();
	}
}
