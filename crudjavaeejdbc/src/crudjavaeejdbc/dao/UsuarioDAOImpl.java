package crudjavaeejdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crudjavaeejdbc.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	private final String COMANDO_INSERIR_USUARIO = "INSERT INTO TB_USUARIO(PRIMEIRONOME, ULTIMONOME, USUARIO, SENHA) VALUES (?,?,?,?)";
	private final String COMANDO_ATUALIZAR_USUARIO = "UPDATE TB_USUARIO SET PRIMEIRONOME = ?, ULTIMONOME = ?, USUARIO = ?, SENHA = ?, SITUACAO = ? WHERE ID = ?";
	private final String COMANDO_EXCLUIR_USUARIO = "DELETE FROM TB_USUARIO WHERE ID = ?";
	private final String COMANDO_LISTAR_USUARIO = "SELECT ID, PRIMEIRONOME, ULTIMONOME, USUARIO, SENHA FROM TB_USUARIO WHERE ID = ?";
	private final String COMANDO_LISTAR_USUARIOS = "SELECT ID, PRIMEIRONOME, ULTIMONOME, USUARIO, SENHA FROM TB_USUARIO";

	@Override
	public Boolean adiciona(Usuario usuario) {
		String sql = COMANDO_INSERIR_USUARIO;
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			int i = 0;
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(i++, usuario.getPrimeiroNome());
			stmt.setString(i++, usuario.getUltimoNome());
			stmt.setString(i++, usuario.getUsuario());
			stmt.setString(i++, usuario.getSenha());

			Boolean linhasInseridas = stmt.executeUpdate() > 0;
			ConnectionFactory.closeConnection(connection, stmt);
			return linhasInseridas;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean atualiza(Usuario usuario) {
		String sql = COMANDO_ATUALIZAR_USUARIO;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			connection = ConnectionFactory.getConnection();
			pstmt = connection.prepareStatement(sql);
			int i = 0;

			pstmt.setString(i++, usuario.getPrimeiroNome().trim());
			pstmt.setString(i++, usuario.getUltimoNome().trim());
			pstmt.setString(i++, usuario.getUsuario().trim());
			pstmt.setString(i++, usuario.getSenha().trim());
			pstmt.setLong(i++, usuario.getId());

			Boolean linhasInseridas = pstmt.executeUpdate() > 0;
			ConnectionFactory.closeConnection(connection, pstmt);

			return linhasInseridas;
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao Atualizar Usuário " + ex);
		}
	}

	@Override
	public Boolean exclui(Usuario usuario) {
		String sql = COMANDO_EXCLUIR_USUARIO;
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			int i = 0;
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setLong(i++, usuario.getId());
			Boolean linhasExcluidas = stmt.executeUpdate() > 0;
			ConnectionFactory.closeConnection(connection, stmt);
			return linhasExcluidas;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		String sql = COMANDO_LISTAR_USUARIO;
		Usuario usuario = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			int i = 1;
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			usuario = new Usuario();
			statement.setLong(i++, usuario.getId());
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				usuario.setId(resultSet.getLong("id"));
				usuario.setPrimeiroNome(resultSet.getString("primeironome"));
				usuario.setUltimoNome(resultSet.getString("ultimonome"));
				usuario.setUsuario(resultSet.getString("usuario"));
				usuario.setSenha(resultSet.getString("senha"));
			}

			return usuario;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connection, (PreparedStatement) statement, resultSet);
		}

	}

	@Override
	public List<Usuario> getUsuarios() {
		String sql = COMANDO_LISTAR_USUARIOS;
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Usuario> usuarios = null;
		Usuario usuario = null;

		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			usuarios = new ArrayList<>();

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setPrimeiroNome(rs.getString("primeironome"));
				usuario.setUltimoNome(rs.getString("ultimonome"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao Listar Usuários " + ex);
		} finally {
			ConnectionFactory.closeConnection(connection, (PreparedStatement) stmt, rs);
		}

	}

}
