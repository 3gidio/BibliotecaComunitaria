package br.com.gereciamentodebiblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gerenciamentodebiblioteca.conect.Conect;
import br.com.gerenciamentodebiblioteca.entities.Livro;

public class LivroDao { // DAO - DATA ACCESS OBJECT
	public void insert(Livro livro) throws SQLException { // Transacional em relacao ao banco de dados
		String sql = "Insert into Livro (Titulo, Autor, Tema, QntPaginas)Values (?,?,?,?)";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		String titulo = livro.getTitulo();
		estadoPreparado.setString(1, titulo); // atribuicao aos valores dos pontos de interrogacao comando
												// SQL acima
		estadoPreparado.setString(2, livro.getAutor());
		estadoPreparado.setString(3, livro.getTema());
		estadoPreparado.setInt(4, livro.getQntPaginas());
		estadoPreparado.execute(); // executar o Comando acima declarado
		estadoPreparado.close();// fechei o estado preparado
		conection.close(); // fechei a conexao

	}

	public void delete(int id) throws SQLException { // Transacional em relacao ao banco de dados
		String sql = "Delete from Livro where id = ?";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		estadoPreparado.setInt(1, id);
		estadoPreparado.execute();
		estadoPreparado.close();
		conection.close();

	}

	public void update(Livro livro) throws SQLException { // Transacional em relacao ao banco de dados
		String sql = "Update Livro Set Titulo = ?, Autor = ?, Tema = ?, QntPaginas = ? Where id = ?";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		estadoPreparado.setString(1, livro.getTitulo()); // atribuicao aos valores dos pontos de interrogacao comando
		// SQL acima
		estadoPreparado.setString(2, livro.getAutor());
		estadoPreparado.setString(3, livro.getTema());
		estadoPreparado.setInt(4, livro.getQntPaginas());
		estadoPreparado.setInt(5, 0);
		estadoPreparado.execute(); // executar o Comando acima declarado
		estadoPreparado.close();// fechei o estado preparado
		conection.close(); // fechei a conexao

	}

	public ArrayList<Livro> selectAll() throws SQLException { // Nao Transacional em relacao ao banco de dados
		String sql = "Select * from Livro";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		ResultSet resultSet = estadoPreparado.executeQuery();
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		while (resultSet.next() == true) {
			String titulo = resultSet.getString("Titulo");
			String autor = resultSet.getString("Autor");
			String tema = resultSet.getString("Tema");
			int qntPaginas = resultSet.getInt("QntPaginas");
			int id = resultSet.getInt("Id");
			Livro livro = new Livro(id, titulo, autor, tema, qntPaginas); //chamada de metodo, nao se declara parametro
			livros.add(livro);
															
		}

		return livros;
	}
}
