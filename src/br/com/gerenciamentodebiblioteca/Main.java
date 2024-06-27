package br.com.gerenciamentodebiblioteca;

import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import br.com.gerenciamentodebiblioteca.entities.Emprestimo;
import br.com.gerenciamentodebiblioteca.entities.Livro;
import br.com.gerenciamentodebiblioteca.entities.Usuario;
import br.com.gerenciamentodebiblioteca.models.EmprestimoModel;
import br.com.gerenciamentodebiblioteca.models.LivroModel;
import br.com.gerenciamentodebiblioteca.models.UsuarioModel;

public class Main {

	public static void main(String[] args) throws SQLException {
		System.out.println("Bem vindo a biblioteca!!!\n");
		menu();

	}

	public static void menu() throws SQLException {
		System.out.println(
				"\nDigite uma Opcao!! \n\n 1 - Cadastrar Livro\n 2 - Visualizar Biblioteca\n 3 - Editar Livro\n "
						+ "4 - Excluir Livro\n 5 - Cadastrar Novo Usuario\n 6 - Visualizar Usuario\n 7 - Editar Usuario\n 8 - Excluir Usuario\n ");
		Scanner scan = new Scanner(System.in);
		int opcao = scan.nextInt();
		switch (opcao) {
		case 0:
			break;
		case 1:
			cadastrarLivro();
			menu();
			break;
		case 2:
			visualizarLivro();
			menu();
			break;
		case 3:
			editarLivro();
			menu();
			break;
		case 4:
			excluirLivro();
			menu();
			break;
		case 5:
			cadastrarUsuario();
			break;
		case 6:
			visualizarUsuario();
			menu();
			break;
		case 7:
			editarUsuario();
			menu();
			break;
		case 8:
			excluirUsuario();
			menu();
			break;
		default:
			menu();

		}
	}

	public static void cadastrarLivro() throws SQLException {
		System.out.println("Digite o titulo"); /// atributos da classe livro
		Scanner scan = new Scanner(System.in);
		String titulo = scan.nextLine();
		System.out.println("Digite o Autor");
		String autor = scan.nextLine();
		System.out.println("Digite o Tema");
		String tema = scan.nextLine();
		System.out.println("Digite a quantidade de Paginas");
		String qntPaginas = scan.nextLine();
		Livro livro = new Livro(titulo, autor, tema, Integer.parseInt(qntPaginas));
		LivroModel livroModel = new LivroModel();

		livroModel.insert(livro);// esse comando insert vem da classe LIVRODAO

		System.out.println("\nLivro cadastrado com sucesso!!!");
	}

	public static void visualizarLivro() throws SQLException {
		LivroModel livroModel = new LivroModel();
		ArrayList<Livro> livros = livroModel.selectAll();
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			livro.exibir();
		}

	}

	public static void editarLivro() throws SQLException {
		visualizarLivro();
		System.out.println("Qual Livro vc Gostaria de editar?\n");
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();
		System.out.println("Digite o titulo"); /// atributos da classe livro
		String titulo = scan.nextLine();
		System.out.println("Digite o Autor");
		String autor = scan.nextLine();
		System.out.println("Digite o Tema");
		String tema = scan.nextLine();
		System.out.println("Digite a quantidade de Paginas");
		String qntPaginas = scan.nextLine();
		Livro livro = new Livro(Integer.parseInt(id), titulo, autor, tema, Integer.parseInt(qntPaginas));
		LivroModel livroModel = new LivroModel();

		livroModel.update(livro); // esse comando UPDATE vem da classe LIVRODAO

		System.out.println("\nLivro Alterado com sucesso!!!");

	}

	public static void excluirLivro() throws SQLException {
		// Fazer (Criei um construtor so com o id pra facilitar a minha vida
		// depois alterei o scanner para nextInt e o ID como do tipo Int e nao String
		// como no metodo alterar.
		visualizarLivro();
		System.out.println("\nQual Livro vc gostaria de Excluir?\n");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		LivroModel livroModel = new LivroModel();

		livroModel.delete(id);
		System.out.println("\nLivro excluido com sucesso!!!\n");
	}

	public static void cadastrarUsuario() throws SQLException {

// fazer semelhante ao cadastrar livro mas com os dados do usuario
		System.out.println("Digite o seu Nome e Sobrenome"); /// atributos da classe livro
		Scanner scan = new Scanner(System.in);
		String nome = scan.nextLine();
		System.out.println("Digite o seu Email");
		String email = scan.nextLine();
		System.out.println("Digite o seu CPF");
		String cpf = scan.nextLine();
		Usuario usuario = new Usuario(nome, email, Long.parseLong(cpf));
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.insert(usuario);
		System.out.println("\nUsuario Cadastrado com sucesso!!\n");

	}

	public static void visualizarUsuario() throws SQLException {
		UsuarioModel usuarioModel = new UsuarioModel();
		ArrayList<Usuario> usuarios = usuarioModel.selectAll();
		for (int i = 0; i < usuarios.size(); i++) {
			Usuario usuario = usuarios.get(i);
			usuario.exibir();
		}

	}

	public static void editarUsuario() throws SQLException {
		visualizarUsuario();
		System.out.println("Qual Usuario vc Gostaria de editar?\n");
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();
		System.out.println("Digite o nome"); /// atributos da classe livro
		String nome = scan.nextLine();
		System.out.println("Digite o Email");
		String email = scan.nextLine();
		System.out.println("Digite o CPF");
		String cpf = scan.nextLine();

		Usuario usuario = new Usuario(Integer.parseInt(id), nome, email, Long.parseLong(cpf));
		UsuarioModel usuarioModel = new UsuarioModel();

		usuarioModel.update(usuario); // esse comando UPDATE vem da classe LIVRODAO

		System.out.println("\nUsuario Alterado com sucesso!!!");

	}

	public static void excluirUsuario() throws SQLException {
		visualizarUsuario();
		System.out.println("\nQual Usuario vc gostaria de Excluir?\n");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		UsuarioModel usuarioModel = new UsuarioModel();

		usuarioModel.delete(id);
		System.out.println("\nUsuario excluido com sucesso!!!\n");

	}

	public static void emprestimo() throws SQLException {
		visualizarLivro();
		System.out.println("\nDigite o id do Livro que vc gostaria de emprestar\n"); /// atributos da classe livro
		Scanner scan = new Scanner(System.in);
		int idLivro = scan.nextInt();
		visualizarUsuario();
		System.out.println("\nDigite o id do Usuario que vai emprestar\n");
		int idUsuario = scan.nextInt();
		Date dataDeHoje = new Date();
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String dataDeHojeFormatada = formatador.format(dataDeHoje);
		String[] dataDeHojeSplit = dataDeHojeFormatada.split("/");
		int dia = Integer.parseInt(dataDeHojeSplit[0]);
		int mes = Integer.parseInt(dataDeHojeSplit[1]);
		int ano = Integer.parseInt(dataDeHojeSplit[2]);
		LocalDate dataDeInicio = LocalDate.of(ano, mes, dia);
		Emprestimo emprestimo = new Emprestimo(idUsuario, idLivro, dataDeInicio);
		EmprestimoModel emprestimoModel = new EmprestimoModel();
		emprestimoModel.insert(emprestimo);

	}
	
	public static LocalDate calcularDataDeDevolucao(LocalDate dataInicio) {
		LocalDate dataDeDevolucao = null;
		
		Calendar calendario = new GregorianCalendar();
		calendario.set(Calendar.MONTH, dataInicio.getMonthValue() - 1);
		int diasDoMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
		int diasRestantes = 0;
		for (int i = dataInicio.getDayOfMonth(); i <= diasDoMes; i++) {
			diasRestantes ++;
		}
			if (diasRestantes >= 5) {
				dataDeDevolucao = LocalDate.of(dataInicio.getYear(), dataInicio.getMonthValue(), dataInicio.getDayOfMonth() + 5); //esse numero "5" refere-se a soma de dias em relacao data de inicio (Caso mais basico de soma a uma data)

			} else  ()
				//Paramos AQui!!!
	}

	public static void visualizarEmprestimo() {
		 EmprestimoModel emprestimoModel = new EmprestimoModel(); // mudar para emprestimo os nomes
			ArrayList<Emprestimo> emprestimos = emprestimoModel.selectAll();
			for (int i = 0; i < emprestimo.size(); i++) {
				Usuario usuario = emprestimo.get(i);
				emprestimo.exibir();
				
	}

	public static void editarEmprestimo() {
		visualizarEmprestimo();
		System.out.println("Qual Emprestimo vc Gostaria de editar?\n");
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();
		System.out.println("Digite o nome"); /// atributos da classe livro
		String nome = scan.nextLine();
		System.out.println("Digite o Email");
		String email = scan.nextLine();
		System.out.println("Digite o CPF");
		String cpf = scan.nextLine();

		Usuario usuario = new Usuario(Integer.parseInt(id), nome, email, Long.parseLong(cpf));
		UsuarioModel usuarioModel = new UsuarioModel();

		EmprestimoModel.update(usuario); // esse comando UPDATE vem da classe LIVRODAO

		System.out.println("\nEmprestimo Alterado com sucesso!!!");

	

	}

	public static void excluirEmprestimo() {
		visualizarEmprestimo();
		System.out.println("\nQual Emprestimo vc gostaria de Excluir?\n");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		UsuarioModel usuarioModel = new UsuarioModel();

		EmprestimoModel.delete(id);
		System.out.println("\nEmprestimo excluido com sucesso!!!\n");
	

	}
}
