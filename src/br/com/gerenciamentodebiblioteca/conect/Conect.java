package br.com.gerenciamentodebiblioteca.conect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect { // essa classe faz a coxexao entre as classes e o banco de dados
	public Connection getConnection() throws SQLException {

		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca", "root", ""); // url
																												// do
																												// meu
																												// projeto
		return conexao;
	}
}
