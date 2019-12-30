package crudjavaeejdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import crudjavaeejdbc.dao.interfaces.TodoDAO;
import crudjavaeejdbc.dao.util.JDBCUtil;
import crudjavaeejdbc.model.Todo;

public class TodoDAOImpl implements TodoDAO {

	//TODO: Implementar um ponto de conexão usando o CMT
	//TODO:Lembrando de Configurar o Pool de Conexões
	//TODO:Continuar Implementando o Servlet do Todo
	//TODO: Não deixar nenhum Warning no Código
	private static final String COMANDO_INSERIR_TODOS = "INSERT INTO TB_TODOS(TITULO, "
			+ "USUARIO, DESCRICAO, DATA, STATUS ) VALUES (? , ? , ?,  ? , ?)";

	private static final String COMANDO_LISTAR_TODOS_POR_ID = "SELECT ID, TITULO, USUARIO, "
			+ "DESCRICAO, DATA, STATUS FROM TB_TODOS WHERE ID =? ";

	private static final String COMANDO_LISTAR_TODOS = "SELECT ID, TITULO, USUARIO, "
			+ "DESCRICAO, DATA, STATUS FROM TB_TODOS";

	private static final String COMANDO_DELETA_TODO_POR_ID = "DELETE FROM TB_TODOS WHERE ID =?";

	private static final String COMANDO_ATUALIZA_TODO_POR_ID = "UPDATE TB_TODOS SET TITULO = ?, USUARIO = ?,"
			+ "DESCRICAO = ?, DATA = ?, STATUS =? WHERE ID =? ";

	@Override
	public boolean adicionaTodo(Todo todo) throws SQLException {

		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(COMANDO_INSERIR_TODOS)) {
			int i = 0;
			pstmt.setString(++i, todo.getTitulo());
			pstmt.setString(++i, todo.getUsuario());
			pstmt.setString(++i, todo.getDescricao());
			pstmt.setDate(++i, JDBCUtil.getSQLDate(todo.getData()));
			pstmt.setBoolean(++i, todo.getStatus());
			System.out.println(pstmt);

			boolean isAdicionado = pstmt.executeUpdate() > 0;
			return isAdicionado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Todo listarPorId(int todoId) {
		Todo todo = null;
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(COMANDO_LISTAR_TODOS_POR_ID)) {
			pstmt.setLong(1, todoId);
			System.out.println(pstmt);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String titulo = rs.getString("titulo");
				String usuario = rs.getString("usuario");
				String descricao = rs.getString("descricao");
				LocalDate data = rs.getDate("data").toLocalDate();
				boolean status = rs.getBoolean("status");
				todo = new Todo(id, titulo, usuario, descricao, data, status);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return todo;
	}

	@Override
	public List<Todo> listarTodos() {
		
		List<Todo> listaTodo = new ArrayList<>();
		try (Connection connection = ConnectionFactory.getConnection();
			 Statement stmt = connection.createStatement()){
			ResultSet rs = stmt.executeQuery(COMANDO_LISTAR_TODOS);
			
			while(rs.next()) {
				long id = rs.getLong("id");
				String titulo = rs.getString("titulo");
				String usuario = rs.getString("usuario");
				String descricao = rs.getString("descricao");
				LocalDate data = rs.getDate("data").toLocalDate();
				boolean status = rs.getBoolean("status");
				listaTodo.add(new Todo(id, titulo, usuario, descricao, data, status));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaTodo;
	}

	@Override
	public boolean excluirTodo(int id) throws SQLException {
		boolean isExcluiu=false;
		try(Connection connection = ConnectionFactory.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(COMANDO_DELETA_TODO_POR_ID)){
			pstmt.setLong(1,id);
			isExcluiu = pstmt.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isExcluiu;
	}

	@Override
	public boolean atualizarTodo(Todo todo) throws SQLException {
		boolean isAtualizado = false;
		try(Connection connection = ConnectionFactory.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(COMANDO_ATUALIZA_TODO_POR_ID) ) {
			int i = 0;
			pstmt.setString(++i, todo.getTitulo());
			pstmt.setString(++i, todo.getUsuario());
			pstmt.setString(++i, todo.getDescricao());
			pstmt.setDate(++i,JDBCUtil.getSQLDate(todo.getData()));
			pstmt.setBoolean(++i, todo.getStatus());
			pstmt.setLong(++i, todo.getId());
			
			isAtualizado = pstmt.executeUpdate() >0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAtualizado;
	}

}
