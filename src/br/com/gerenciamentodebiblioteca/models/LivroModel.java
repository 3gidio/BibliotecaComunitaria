package br.com.gerenciamentodebiblioteca.models;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gereciamentodebiblioteca.daos.LivroDao;
import br.com.gerenciamentodebiblioteca.entities.Livro;

public class LivroModel {
	public void insert(Livro livro) throws SQLException { // metodo insert
		LivroDao livroDao = new LivroDao();
		livroDao.insert(livro);

	}

	public void delete(int livro) throws SQLException { // declaracao de metedo da classe LivroDAo
		LivroDao livroDao = new LivroDao();
		livroDao.delete(livro);
	}

	public void update(Livro livro) throws SQLException { // declaracao de metedo da classe LivroDAo
		LivroDao livroDao = new LivroDao();
		livroDao.update(livro);
	}

	public ArrayList<Livro> selectAll() throws SQLException { // declaracao de metedo da classe LivroDAo
		LivroDao livroDao = new LivroDao();
		ArrayList<Livro> livros = livroDao.selectAll();
		return livros;
		
	}
	
}
