package exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Telefone;
import model.UsuarioComTelefoneEmbutido;
import util.JPAUtil;

public class ConsultaObjetosEmbutidosTipoUsuarioCollection {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		UsuarioComTelefoneEmbutido usuario =  em.find(UsuarioComTelefoneEmbutido.class, 2L);
		
		System.out.println(usuario.getNome());
		
		for (Telefone telefone:usuario.getTelefones()) {
			System.out.println("Telefone: ("+telefone.getPrefixo()+")"
							+telefone.getNumero()
							+(telefone.getRamal()!=null ? " ramal:"+telefone.getRamal() : ""));
			
		}
		
		
		
		
		em.close();
	}
}
