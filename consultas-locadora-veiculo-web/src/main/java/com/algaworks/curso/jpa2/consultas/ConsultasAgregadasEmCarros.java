package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarros {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select c, count(a),max(a.valorTotal),avg(a.valorTotal),min(a.valorTotal),sum(a.valorTotal) "
					 + " from Carro c join c.alugueis a "
					 + " group by c "
					 + " order by count(a) desc ";
					 //+ " having count(a) > 1";
		
		List<Object[]> listaDeDadosDoCarros = em.createQuery(jpql).getResultList();
		
		for(Object[] dadosdoCarro:listaDeDadosDoCarros) {
			System.out.println("Modelo " + ((Carro)dadosdoCarro[0]).getModelo().getDescricao());
			System.out.println("Quantidade de Alugueis " +dadosdoCarro[1]);
			System.out.println("Valor Máximo " +dadosdoCarro[2]);
			System.out.println("Valor Médio " +dadosdoCarro[3]);
			System.out.println("Valor Mínimo " +dadosdoCarro[4]);
			System.out.println("Valor Soma " +dadosdoCarro[5]);
			System.out.println("------------------------------");
		}
		
		em.close();
	}
}
