package br.com.gerenciamentodebiblioteca.entities;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private String tema;
	private int qntPaginas;

	public void exibir() {
		System.out.println("\nId: " + id + "\nTitulo: " + titulo + "\nAutor: " + autor + "\nTema: " + tema + "\nQuantidade de Paginas: " + qntPaginas);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getQntPaginas() {
		return qntPaginas;
	}

	public void setQntPaginas(int qntPaginas) {
		this.qntPaginas = qntPaginas;
	}

	public Livro(int id, String titulo, String autor, String tema, int qntPaginas) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.tema = tema;
		this.qntPaginas = qntPaginas;
	}

	public Livro(String titulo, String autor, String tema, int qntPaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.tema = tema;
		this.qntPaginas = qntPaginas;
	}
	
	public Livro(int id) {
		this.id = id;
		
	}

	public Livro() {
	}
}
