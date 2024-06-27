package br.com.gereciamentodebiblioteca.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.gerenciamentodebiblioteca.conect.Conect;
import br.com.gerenciamentodebiblioteca.entities.Emprestimo;
import br.com.gerenciamentodebiblioteca.entities.Usuario;

public class EmprestimoDao {

	public void insert(Emprestimo emprestimo) throws SQLException {
		String sql = "Insert into Emprestimo (idUsuario,idLivro,dataInicio) Values (?,?,?)";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		int idUsuario = emprestimo.getIdUsuario();
		estadoPreparado.setInt(1, idUsuario); // atribuicao aos valores dos pontos de interrogacao comando
		int idLivro = emprestimo.getIdLivro();									// SQL acima
		estadoPreparado.setInt(2,idLivro);
		Date dataInicioFormatada = Date.valueOf(emprestimo.getDataInicio()); // convertemos a data(date.valueOf)
		
		estadoPreparado.setDate(3, dataInicioFormatada);
		estadoPreparado.execute(); // executar o Comando acima declarado
		estadoPreparado.close();// fechei o estado preparado
		conection.close(); // fechei a conexao
		
		
		
	}

	public void delete(int id) throws SQLException {
		String sql = "Delete from Emprestimo where id = ?";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		estadoPreparado.setInt(1, id);
		estadoPreparado.execute();
		estadoPreparado.close();
		conection.close();
		
		
	}

	public void update(Emprestimo emprestimo) throws SQLException {
		String sql = "Update Emprestimo Set idUsuario = ?, idLivro = ?, dataInicio = ? dataDevolucao = ? where ";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		Date dataInicioFormatada = Date.valueOf(emprestimo.getDataInicio()); // converti a data com Date.valueof.
		Date dataDevolucaoFormatada = Date.valueOf(emprestimo.getDataInicio());// converti a data com Date.valueof.
		
		estadoPreparado.setInt(1, emprestimo.getIdUsuario()); // atribuicao aos valores dos pontos de interrogacao comando
		// SQL acima
		estadoPreparado.setInt(2, emprestimo.getIdLivro());
		estadoPreparado.setDate(3, dataInicioFormatada );
		estadoPreparado.setDate(4, dataDevolucaoFormatada);
		estadoPreparado.execute(); // executar o Comando acima declarado
		estadoPreparado.close();// fechei o estado preparado
		conection.close(); // fechei a conexao
		
	}

	public ArrayList<Emprestimo> selectAll()throws SQLException {
		String sql = "Select * from Emprestimo";
		Conect conect = new Conect();
		Connection conection = conect.getConnection();
		PreparedStatement estadoPreparado = conection.prepareStatement(sql);
		ResultSet resultSet = estadoPreparado.executeQuery();
		 ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		
		while (resultSet.next() == true) {
			
			int id = resultSet.getInt("id");
			int idUsuario = resultSet.getInt("idUsuario");
			int idLivro = resultSet.getInt("idLivro");
			Date dataInicio = resultSet.getDate("dataInicio");
			Date dataDevolucao= resultSet.getDate("dataDevolucao");
			DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataInicioFormat = formatador.format(dataInicio);
			String[] dataInicioSplit = dataInicioFormat.split("-");
			int diaInicio = Integer.parseInt(dataInicioSplit[0]);
			int mesInicio = Integer.parseInt(dataInicioSplit[1]);
			int anoInicio = Integer.parseInt(dataInicioSplit[2]);
			LocalDate dataDeInicio = LocalDate.of(anoInicio, mesInicio, diaInicio);
			String dataDevolucaoFormat = formatador.format(dataDevolucao);
			String[] dataDevolucaoSplit = dataDevolucaoFormat.split("-");
			int diaDevolucao = Integer.parseInt(dataDevolucaoSplit[0]);
			int mesDevolucao = Integer.parseInt(dataDevolucaoSplit[1]);
			int anoDevolucao = Integer.parseInt(dataDevolucaoSplit[2]);
			LocalDate dataDeDevolucao = LocalDate.of(anoDevolucao, mesDevolucao, diaDevolucao);
			Emprestimo emprestimo = new Emprestimo(id, idUsuario,idLivro, dataDeInicio, dataDeDevolucao);
			emprestimos.add(emprestimo);
		
		
		
	}
		return emprestimos;
	}
}
