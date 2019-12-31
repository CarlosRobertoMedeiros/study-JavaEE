package crudjavaeejdbc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudjavaeejdbc.dao.TodoDAOImpl;
import crudjavaeejdbc.dao.interfaces.TodoDAO;
import crudjavaeejdbc.model.Todo;

@WebServlet("/")
public class TodoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private TodoDAO todoDAO;

	public void init() {
		todoDAO = new TodoDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/nova":
				mostraNovoFormularioTodo(request, response);
				break;
			case "/inserir":
				inserirTodo(request, response);
				break;
			case "/excluir":
				excluirTodo(request, response);
				break;
			case "/atualizar":
				editaFormularioTodo(request, response);
				break;
			case "/update":
				atualizaTodo(request, response);
				break;
			case "/listar":
				listarTodos(request, response);
				break;
			default:
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
				requestDispatcher.forward(request, response);
				break;
			}

		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

	private void listarTodos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Todo> todoList = todoDAO.listarTodos();
		request.setAttribute("listarTodo", todoList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
		dispatcher.forward(request, response);
	}

	private void mostraNovoFormularioTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
		requestDispatcher.forward(request, response);
	}

	private void editaFormularioTodo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Todo existeTodo = todoDAO.listarPorId(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
		request.setAttribute("todo", existeTodo);
		dispatcher.forward(request, response);
	}

	private void inserirTodo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String titulo = request.getParameter("titulo");
		String usuario = request.getParameter("usuario");
		String descricao = request.getParameter("descricao");
		String data = request.getParameter("data");
		
		LocalDate dataAlvo = LocalDate.parse(data);

		/*
		 * DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd"); LocalDate
		 * targetDate = LocalDate.parse(request.getParameter("targetDate"),df);
		 */

		boolean isEstaFeito = Boolean.valueOf(request.getParameter("isEstaFeito"));
		todoDAO.adicionaTodo(new Todo(null, titulo, usuario, descricao, dataAlvo, isEstaFeito));
		response.sendRedirect("listar");

	}

	private void atualizaTodo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		String titulo = request.getParameter("titulo");
		String usuario = request.getParameter("usuario");
		String descricao = request.getParameter("descricao");
		// DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate data = LocalDate.parse(request.getParameter("data"));

		boolean isEstaFeito = Boolean.valueOf(request.getParameter("isEstaFeito"));
		todoDAO.atualizarTodo(new Todo((long) id, titulo, usuario, descricao, data, isEstaFeito));
		response.sendRedirect("listar");
	}

	private void excluirTodo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		todoDAO.excluirTodo(id);
		response.sendRedirect("listar");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
