package crudjavaeejdbc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudjavaeejdbc.dao.UsuarioDAO;
import crudjavaeejdbc.dao.UsuarioDAOImpl;
import crudjavaeejdbc.model.Usuario;

@WebServlet("/registrar")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		registrar(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("registrar/registrar.jsp");
	}

	private void registrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String primeiroNome = req.getParameter("primeironome");
		String ultimoNome = req.getParameter("ultimonome");
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");

		Usuario colaborador = new Usuario();
		colaborador.setPrimeiroNome(primeiroNome);
		colaborador.setUltimoNome(ultimoNome);
		colaborador.setUsuario(usuario);
		colaborador.setSenha(senha);

		try {
			boolean adicionouColaborador = usuarioDAO.adiciona(colaborador);

			if (adicionouColaborador) {
				req.setAttribute("NOTIFICACAO", "Colaborador Cadastrado com Sucesso !");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("registrar/registrar.jsp");
		dispatcher.forward(req, resp);
	}
}
