package br.com.gerenciamentodebiblioteca.models;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gereciamentodebiblioteca.daos.EmprestimoDao;
import br.com.gereciamentodebiblioteca.daos.UsuarioDao;
import br.com.gerenciamentodebiblioteca.entities.Emprestimo;
import br.com.gerenciamentodebiblioteca.entities.Usuario;

public class EmprestimoModel {
	public void insert(Emprestimo emprestimo) throws SQLException {
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		emprestimoDao.insert(emprestimo);

	}
	public void delete(int emprestimo) throws SQLException { // declaracao de metedo da classe LivroDAo
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		emprestimoDao.delete(emprestimo);
	}

	public void update(Emprestimo emprestimo) throws SQLException { // declaracao de metedo da classe LivroDAo
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		emprestimoDao.update(emprestimo);
	}

	public ArrayList<Emprestimo> selectAll() throws SQLException { // declaracao de metedo da classe LivroDAo
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		ArrayList<Emprestimo> emprestimo = emprestimoDao.selectAll();
		return emprestimo;
		
	
}

}
