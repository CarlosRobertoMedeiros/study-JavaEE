package crudjavaeejdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/crud";
	private static final String jdbcUsername = "root";
	private static final String jdbcPassword = "root";

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Problema na Conexão ", ex);
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			// Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}

	}

	public static void closeConnection(Connection con, PreparedStatement statement) {
		closeConnection(con);
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void closeConnection(Connection con, PreparedStatement statement, ResultSet resultset) {
		closeConnection(con, statement);
		try {
			if (resultset != null) {
				resultset.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}