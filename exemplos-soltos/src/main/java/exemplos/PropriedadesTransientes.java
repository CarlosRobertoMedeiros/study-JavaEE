package exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Veiculo;
import model.VeiculoId;
import util.JPAUtil;

public class PropriedadesTransientes {
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Veiculo veiculo = em.find(Veiculo.class, new VeiculoId("AAA-1111","Rio de Janeiro"));
		System.out.println(veiculo.getDescricao());

		em.close();
	}
}
