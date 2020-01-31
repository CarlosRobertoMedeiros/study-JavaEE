package com.algaworks.curso.jpa2.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Categoria;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class ExemplosAcoesEmCascata {

	private static EntityManagerFactory emf;
	private EntityManager em;
	
	@BeforeClass
	public static void init(){
		emf = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}
	
	@Before
	public void setUp() {
		this.em = emf.createEntityManager();
	}

	@After
	public void tearDown() {
		this.em.close();
	}
	
	
	@Test
	public void exemploEntidadeTransiente() {
		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setPlaca("AAA-1111");
		
		ModeloCarro modelo = new ModeloCarro();
		modelo.setCategoria(Categoria.ESPORTIVO);
		modelo.setDescricao("Ferrari");
		carro.setModelo(modelo);
		
		this.em.getTransaction().begin();
		this.em.persist(carro);
		this.em.getTransaction().commit();
	}
	
	
	@Test
	public void exemploSalvandoEntidadesTransientesAcessorios() {
		Carro carro = new Carro();
		carro.setCor("azul");
		carro.setPlaca("BBB-1111");
		
		Acessorio acessorio = new Acessorio();
		acessorio.setDescricao("Banco em V");
		
		Acessorio acessorio2 = new Acessorio();
		acessorio2.setDescricao("Banco em Y");
		
		List<Acessorio> acessorios = new ArrayList<>();
		acessorios.add(acessorio);
		acessorios.add(acessorio2);
		
		
		carro.setAcessorios(acessorios);
		
		
		this.em.getTransaction().begin();
		this.em.persist(carro);
		this.em.getTransaction().commit();
	}
	
	@Test
	public void exclusaoEmCascata() {
		//Tem que Atualizar o CascadeType para Remove no Carro
		// Assim o carro vai ser removido também
		Carro carro = this.em.find(Carro.class, 2L);
		this.em.getTransaction().begin();
		this.em.remove(carro);
		this.em.getTransaction().commit();
	}
	
	@Test
	public void exclusaoEmCascatadeObjetosOrfaos() {
		//Apagando um objeto em uma coleção
		//, cascade = CascadeType.PERSIST , orphanRemoval = true
		Carro carro = this.em.find(Carro.class, 2L);
		this.em.getTransaction().begin();
		carro.getAlugueis().remove(0);
		this.em.getTransaction().commit();
	}
		
}
