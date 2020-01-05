package crudjavaeejdbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crudjavaeejdbc.dao.LoginDAO;
import crudjavaeejdbc.model.Login;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;
	
	public void init() {
		loginDAO = new LoginDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login/login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		autenticar(req,resp);
	}

	private void autenticar(HttpServletRequest req, HttpServletResponse resp) {
		String usuario = req.getParameter("inputUsuario");
		String senha = req.getParameter("inputSenha");
		
		Login colaborador = new Login();
		colaborador.setUsuario(usuario);
		colaborador.setSenha(senha);
		
		try {
			if (loginDAO.usuarioEValido(colaborador)) {
				//RequestDispatcher requestDispatcher = req.getRequestDispatcher("todo/todo-form.jsp");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
				//resp.sendRedirect("index.jsp");
			}else {
				HttpSession sessao = req.getSession();//TODO:Implementar a Sessão
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
