package br.com.gerenciamentodebiblioteca.entities;

import java.time.LocalDate;

public class Emprestimo {
	private int id;
	private int idUsuario;
	private int idLivro;
	private LocalDate dataInicio;
	private LocalDate dataDevolucao;

	public void exibir() {
		System.out.println("id: " + id + "\nidUsuario: " + idUsuario + "\nidLivro: " + idLivro +
		"Data de Retirada: " + dataInicio + "Data de Devolucao: " + dataDevolucao );
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Emprestimo(int id, int idUsuario, int idLivro, LocalDate dataInicio, LocalDate dataDevolucao) {
	
		this.id = id;
		this.idUsuario = idUsuario;
		this.idLivro = idLivro;
		this.dataInicio = dataInicio;
		this.dataDevolucao = dataDevolucao;
	}
	public Emprestimo() {
		
		
	}
	
	public Emprestimo(int idUsuario, int idLivro, LocalDate dataInicio) {
		this.idUsuario = idUsuario;
		this.idLivro = idLivro;
		this.dataInicio = dataInicio;

	}
}
