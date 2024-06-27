package br.com.gerenciamentodebiblioteca.entities;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private Long cpf;

	public void exibir() {
		System.out.println("Id: " + id + "Nome: " + nome + "Email: " + email + "CPF: " + cpf);
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getCpf() {
		return cpf;
	}


	public void setCpf(long cpf) {
		this.cpf = cpf;
	}


	public Usuario(int id, String nome, String email, long cpf) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	public Usuario(String nome, String email, long cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

}
