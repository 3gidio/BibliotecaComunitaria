package br.com.gereciamentodebiblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gerenciamentodebiblioteca.conect.Conect;
import br.com.gerenciamentodebiblioteca.entities.Livro;
import br.com.gerenciamentodebiblioteca.entities.Usuario;

public class UsuarioDao {

	public void insert(Usuario usuario) throws SQLException {
		String sql = "Insert into Usuario (Nome, Email, CPF)Values (?,?,?)";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		String nome = usuario.getNome();
		estadoPreparado.setString(1, nome); // atribuicao aos valores dos pontos de interrogacao comando
												// SQL acima
		estadoPreparado.setString(2, usuario.getEmail());
		estadoPreparado.setLong(3, usuario.getCpf());
		estadoPreparado.execute(); // executar o Comando acima declarado
		estadoPreparado.close();// fechei o estado preparado
		conection.close(); // fechei a conexao

	}
	
	public void delete(int id) throws SQLException { // Transacional em relacao ao banco de dados
		String sql = "Delete from Usuario where id = ?";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		estadoPreparado.setInt(1, id);
		estadoPreparado.execute();
		estadoPreparado.close();
		conection.close();

	}

	public void update(Usuario usuario) throws SQLException { // Transacional em relacao ao banco de dados
		String sql = "Update Usuario Set Nome = ?, Email = ?, CPF = ? Where id = ?";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		estadoPreparado.setString(1, usuario.getNome()); // atribuicao aos valores dos pontos de interrogacao comando
		// SQL acima
		estadoPreparado.setString(2, usuario.getEmail());
		estadoPreparado.setLong(3, usuario.getCpf());
		estadoPreparado.setInt(4, usuario.getId());
		estadoPreparado.execute(); // executar o Comando acima declarado
		estadoPreparado.close();// fechei o estado preparado
		conection.close(); // fechei a conexao

	}

	public ArrayList<Usuario> selectAll() throws SQLException { // Nao Transacional em relacao ao banco de dados
		String sql = "Select * from Usuario";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		ResultSet resultSet = estadoPreparado.executeQuery();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		while (resultSet.next() == true) {
			String nome = resultSet.getString("Nome");
			String email = resultSet.getString("Email");
			long cpf = resultSet.getLong("CPF");
			int id = resultSet.getInt("Id");
			Usuario usuario = new Usuario(id, nome, email, cpf);
			usuarios.add(usuario);
															
		}

		return usuarios;
	}

}
