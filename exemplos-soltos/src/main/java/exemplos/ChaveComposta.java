package exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Veiculo;
import model.VeiculoId;
import util.JPAUtil;

public class ChaveComposta {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(new VeiculoId("ABC-1235","Brasília"));
		veiculo.setFabricante("Volksvagen");
		veiculo.setModelo("Gol");
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
		
		Veiculo v = em.find(Veiculo.class, new VeiculoId("ABC-1234","Brasília"));
		System.out.println(v.getCodigo().getPlaca()+" - "+ v.getCodigo().getCidade());
		
		
		em.close();
	
	}
	
}
