package com.algaworks.curso.jpa2.consultas.retornandoumobjetodeumalista;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarros {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select new com.algaworks.curso.jpa2.consultas.retornandoumobjetodeumalista.AluguelCarroInfo(c, count(a),max(a.valorTotal),avg(a.valorTotal),min(a.valorTotal),sum(a.valorTotal)) "
					 + " from Carro c join c.alugueis a "
					 + " group by c "
					 + " order by count(a) desc ";
					 //+ " having count(a) > 1";
		
		@SuppressWarnings("unchecked")
		List<AluguelCarroInfo> listaDeDadosDoCarros = em.createQuery(jpql).getResultList();
		
		for(AluguelCarroInfo dadosdoCarro:listaDeDadosDoCarros) {
			System.out.println("Modelo: " + dadosdoCarro.getCarro().getModelo().getDescricao());
			System.out.println("Quantidade de alugueis: " + dadosdoCarro.getTotalAlugueis());
			System.out.println("Valor máximo: " + dadosdoCarro.getValorMaximo());
			System.out.println("Valor médio: " + dadosdoCarro.getValorMedio());
			System.out.println("Valor mínimo: " + dadosdoCarro.getValorMedio());
			System.out.println("Valor Soma: " + dadosdoCarro.getValorMedio());
			System.out.println("------------------------------");
		}
		
		em.close();
	}
}
