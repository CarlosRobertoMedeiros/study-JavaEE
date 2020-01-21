package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FuncionarioDAO;
import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioDAO funcionarioDao;
	
	
	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {
		if (funcionario.getNome() == null || funcionario.getNome().trim().equals("")) {
			throw new NegocioException("O nome do funcionário é Obrigatório");
		}

		this.funcionarioDao.salvar(funcionario);

	}
}
