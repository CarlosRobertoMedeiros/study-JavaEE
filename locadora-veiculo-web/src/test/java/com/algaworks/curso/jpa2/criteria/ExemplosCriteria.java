package com.algaworks.curso.jpa2.criteria;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class ExemplosCriteria {

	private static EntityManagerFactory fabrica;

	private EntityManager manager;

	@BeforeClass
	public static void init() {
		fabrica = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}

	@Before
	public void setUp() {
		this.manager = fabrica.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}

	@Test
	public void projecoes() {

		// Busca por placas
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(carro.get("placa"));

		TypedQuery<String> query = manager.createQuery(criteriaQuery);
		List<String> placas = query.getResultList();

		for (String placa : placas) {
			System.out.println(placa);
		}

	}

	@Test
	public void funcoesDeAgregacao() {
		//Funções de Agregação sum.max,min,avg
		// Soma de Alugueis
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> criteriaQuery = builder.createQuery(BigDecimal.class);

		Root<Aluguel> aluguel = criteriaQuery.from(Aluguel.class);
		criteriaQuery.select(builder.sum(aluguel.get("valorTotal")));

		TypedQuery<BigDecimal> query = manager.createQuery(criteriaQuery);
		BigDecimal total = query.getSingleResult();

		System.out.println("Soma de Todos os Alugueis " + total);
	}
	
	@Test
	public void resultadoComplexo() {
		//Retorna Objetos como uma Lista de Objects
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.multiselect(carro.get("placa"),
								  carro.get("valorDiaria"));
		
		TypedQuery<Object[]> query = manager.createQuery(criteriaQuery);
		List<Object[]> resultado = query.getResultList();
		
		for(Object[] valores:resultado) {
			System.out.println(valores[0]+" - "+ valores[1]);
		}

	}
	
	@Test
	public void resultadoTupla() {
		//Retorna os Objetos de Acordo com o Alias
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = builder.createTupleQuery();
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.multiselect(carro.get("placa").alias("placaCarro"),
								  carro.get("valorDiaria").alias("valorCarro"));
		
		TypedQuery<Tuple> query = manager.createQuery(criteriaQuery);
		List<Tuple> resultado = query.getResultList();
		
		for(Tuple tupla:resultado) {
			System.out.println(tupla.get("placaCarro")+ "- " + tupla.get("valorCarro"));
		}
	}
	
	@Test
	public void resultadoConstrutor() {
		//Retorna um Outro Objeto "PrecoCarro"
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<PrecoCarro> criteriaQuery = builder.createQuery(PrecoCarro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(builder.construct(PrecoCarro.class, 
												carro.get("placa"),
												carro.get("valorDiaria")));
		
		TypedQuery<PrecoCarro> query = manager.createQuery(criteriaQuery);
		List<PrecoCarro> resultado = query.getResultList();
		
		for(PrecoCarro precoCarro:resultado) {
			System.out.println(precoCarro.getPlaca()+" "+precoCarro.getValor());
		}
		
		
	}
	
	@Test
	public void exemploFuncao() {
		//Lista todos os Carros de Cor prata
		//O valor está passado direto
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Predicate predicate = builder.equal(builder.upper(carro.get("cor")), 
														  "prata".toUpperCase());
		
		criteriaQuery.select(carro);
		criteriaQuery.where(predicate);
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for(Carro c:carros) {
			System.out.println(c.getPlaca()+" - " +c.getCor());
		}
	}
	
	@Test
	public void exemploOrdenacao() {
		//Usando ordenação normal
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Order order = builder.desc(carro.get("valorDiaria"));
		
		criteriaQuery.select(carro);
		criteriaQuery.orderBy(order);
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for(Carro c:carros) {
			System.out.println(c.getPlaca()+" - " +c.getValorDiaria());
		}
	}
	
	@Test
	public void joinEFetch() {
		//Nunca Tinha Implementado assim
		//Habilitei um JoinFetch e um where junto
		//Fetch busca tudo na mesma consulta
		//join faz a consulta em momentos diferentes
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		//Join<Carro, ModeloCarro> modelo = (Join)carro.fetch("modelo"); //Esse aqui é "melhor"
		Join<Carro, ModeloCarro> modelo = (Join)carro.join("modelo");
		
		criteriaQuery.where(builder.equal(modelo.get("descricao"), "Fit"));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for(Carro c:carros) {
			//System.out.println(c.getPlaca()+" - " +c.getModelo().getDescricao());
			System.out.println(c.getPlaca());
		}
		
	}
	
	@Test
	public void mediaDasDiariasDosCarros() {
		//Retorna uma média
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = builder.createQuery(Double.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(builder.avg(carro.get("valorDiaria")));
		
		TypedQuery<Double> query = manager.createQuery(criteriaQuery);
		Double total = query.getSingleResult();
		System.out.println("Média de Diária " +total);

	}
	
	@Test
	public void carrosComValoresAcimaDaMedia() {
		//Retorna valor utilizando uma SubQuery
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = criteriaBuilder.createQuery(Carro.class);
		
		Subquery<Double> subquery = criteriaQuery.subquery(Double.class);
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Root<Carro> carroSub = subquery.from(Carro.class);
		
		subquery.select(criteriaBuilder.avg(carroSub.get("valorDiaria")));
		criteriaQuery.select(carro);
		criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(carro.get("valorDiaria"), subquery));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca()+" - " +c.getValorDiaria());	
		}
	}
	
	@Test
	public void exemploMetaModel() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Join<Carro, ModeloCarro> modelo = (Join)carro.fetch("modelo");
				
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.equal(modelo.get("descricao"), "Fit"));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for(Carro c:carros) {
			System.out.println(c.getPlaca()+" - " +c.getModelo().getDescricao());
		}	
		
		
	}
}
