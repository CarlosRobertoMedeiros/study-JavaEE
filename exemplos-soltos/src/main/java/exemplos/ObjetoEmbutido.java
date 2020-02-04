package exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Proprietario;
import model.Veiculo;
import model.VeiculoId;
import util.JPAUtil;

public class ObjetoEmbutido {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(new VeiculoId("AAA-1111","Rio de Janeiro"));
		veiculo.setFabricante("Volksvagen");
		veiculo.setModelo("Fusca");
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João da Silva");
		proprietario.setEmail("joaodasilva@gmail.com");
		proprietario.setTelefone("61984731630");
		
		veiculo.setProprietario(proprietario);
		
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
		
//		Veiculo v = em.find(Veiculo.class, new VeiculoId("ABC-1234","Brasília"));
//		System.out.println(v.getCodigo().getPlaca()+" - "+ v.getCodigo().getCidade());
		
		
		em.close();
	}
}
