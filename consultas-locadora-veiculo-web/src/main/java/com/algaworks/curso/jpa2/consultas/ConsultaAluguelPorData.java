package com.algaworks.curso.jpa2.consultas;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAluguelPorData {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Calendar inicioCalendar = Calendar.getInstance();
		inicioCalendar.set(2013, 7,  28, 7, 0);
		Date dataInicio = inicioCalendar.getTime();
		
		Calendar fimCalendar = Calendar.getInstance();
		fimCalendar.set(2013, 7, 30, 18, 0); // 25 de Agosto de 2013 18:00 horas
		Date dataFim = fimCalendar.getTime();
		
		
		String jpql ="select count(a) from Aluguel a where a.dataDevolucao between (:dataInicio) and (:dataFim)";
		
		Long qtdeDevolucoes = em.createQuery(jpql,Long.class)
				.setParameter("dataInicio",dataInicio,TemporalType.TIMESTAMP)
				.setParameter("dataFim",dataFim,TemporalType.TIMESTAMP)
				.getSingleResult();
		
		System.out.println("Quantidade de Devoluções "+ qtdeDevolucoes);
		
		em.close();
		
	}

}
