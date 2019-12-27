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

import crudjavaeejdbc.dao.UsuarioDAOImpl;
import crudjavaeejdbc.model.Usuario;

@WebServlet(name="Usuarios", urlPatterns = {"/UsuarioController}"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LISTA_USUARIOS = "/listausuario.jsp";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";
		String action = req.getParameter("action");
		UsuarioDAOImpl listaUsuariosDao = new UsuarioDAOImpl(); 
		
		if (action.equalsIgnoreCase("listadeUsuarios")) {
			forward = LISTA_USUARIOS;
			req.setAttribute("usuarios", listaUsuariosDao.getUsuarios());
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(forward);
		//view.forward
		
	}
	
	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		UsuarioDAOImpl listaUsuariosDao = new UsuarioDAOImpl(); 
		List<Usuario> listaUsuarios = listaUsuariosDao.getUsuarios();
		request.setAttribute("listaUsuarios", listaUsuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listausuario.jsp");
		dispatcher.forward(request, response);
	}
	

}
