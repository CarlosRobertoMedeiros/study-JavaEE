package crudjavaeejdbc.dao.interfaces;

import java.sql.SQLException;

import crudjavaeejdbc.model.Todo;

import java.util.List;

public interface TodoDAO {

	boolean adicionaTodo(Todo todo) throws SQLException;

	Todo listarPorId(int todoId);

	List<Todo> listarTodos();

	boolean excluirTodo(int id) throws SQLException;

	boolean atualizarTodo(Todo todo) throws SQLException;

}
