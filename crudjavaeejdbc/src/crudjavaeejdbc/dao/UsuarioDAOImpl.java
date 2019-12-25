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

	private final String COMANDO_INSERIR_USUARIO = "INSERT INTO TB_USUARIO(NOME,CPF,EMAIL,TELEFONE) VALUES (?,?,?,?)";
	private final String COMANDO_ATUALIZAR_USUARIO = "UPDATE TB_USUARIO SET NOME = ?, CPF = ?, EMAIL = ?, TELEFONE = ?, SITUACAO = ? WHERE ID = ?";
	private final String COMANDO_EXCLUIR_USUARIO = "DELETE FROM TB_USUARIO WHERE ID = ?";
	private final String COMANDO_LISTAR_USUARIO = "SELECT ID, NOME, CPF, EMAIL, TELEFONE, SITUACAO FROM TB_USUARIO WHERE ID = ?";
	private final String COMANDO_LISTAR_USUARIOS = "SELECT ID, NOME, CPF, EMAIL, TELEFONE, SITUACAO FROM TB_USUARIO";

	@Override
	public Boolean adiciona(Usuario usuario) {
		String sql = COMANDO_INSERIR_USUARIO;
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			int i = 0;
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(i++, usuario.getNome());
			stmt.setString(i++, usuario.getCpf());
			stmt.setString(i++, usuario.getEmail());
			stmt.setString(i++, usuario.getTelefone());

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

			pstmt.setString(i++, usuario.getNome().trim());
			pstmt.setString(i++, usuario.getCpf().trim());
			pstmt.setString(i++, usuario.getEmail().trim());
			pstmt.setString(i++, usuario.getTelefone().trim());
			pstmt.setString(i++, usuario.getSituacao().trim());
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
				usuario.setNome(resultSet.getString("nome"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setSituacao(resultSet.getString("situacao"));
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
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSituacao(rs.getString("situacao"));
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
