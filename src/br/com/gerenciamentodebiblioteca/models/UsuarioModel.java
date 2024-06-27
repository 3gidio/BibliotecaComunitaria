package br.com.gerenciamentodebiblioteca.models;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gereciamentodebiblioteca.daos.LivroDao;
import br.com.gereciamentodebiblioteca.daos.UsuarioDao;
import br.com.gerenciamentodebiblioteca.entities.Livro;
import br.com.gerenciamentodebiblioteca.entities.Usuario;

public class UsuarioModel {
	public void insert(Usuario usuario) throws SQLException {
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.insert(usuario);
	}
	
	public void delete(int usuario) throws SQLException { // declaracao de metedo da classe LivroDAo
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.delete(usuario);
	}

	public void update(Usuario usuario) throws SQLException { // declaracao de metedo da classe LivroDAo
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.update(usuario);
	}

	public ArrayList<Usuario> selectAll() throws SQLException { // declaracao de metedo da classe LivroDAo
		UsuarioDao usuarioDao = new UsuarioDao();
		ArrayList<Usuario> usuarios = usuarioDao.selectAll();
		return usuarios;
		
	}
}
