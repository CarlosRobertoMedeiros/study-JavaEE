package crudjavaeejdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import crudjavaeejdbc.model.Login;

public class LoginDAO {

	private final String COMANDO_PESQUISAR_USUARIO = "SELECT USUARIO,SENHA FROM TB_USUARIO WHERE USUARIO = ? AND SENHA = ? ";

	public boolean usuarioEValido(Login usuario) {

		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(COMANDO_PESQUISAR_USUARIO)) {
			int i=0;
			pstmt.setString(++i, usuario.getUsuario());
			pstmt.setString(++i, usuario.getSenha());

			System.out.println(pstmt);

			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
