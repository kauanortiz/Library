package entidade;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ItemBiblioteca {
	
	//implementar atributos e métodos que servem para livro e revista
	private String titulo;
	private String genero;
	private String editora;
	private Integer qntDisponivel;
	private Integer qntPag;
	private String classificacaoIndicativa;
	private Queue<Usuario> filaReservas = new LinkedList<>();
	
	Scanner scanner = new Scanner(System.in);
	
	//construtor geral
	public ItemBiblioteca(String titulo, String genero, String editora, Integer qntDisponivel, Integer qntPag,
			String classificacaoIndicativa) {
		this.titulo = titulo;
		this.genero = genero;
		this.editora = editora;
		this.qntDisponivel = qntDisponivel;
		this.qntPag = qntPag;
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	
	//construtor principal
	public ItemBiblioteca(String titulo, Integer qntDisponivel) {
		
		//confere se titulo é nulo ou vazio
		while(titulo == null || titulo.isBlank()) {
			System.out.println("Título inválido!");
			titulo = scanner.nextLine();
		}
		
		this.titulo = titulo;
		
		//confere se qntDisponível é válida
		while(qntDisponivel < 0) {
			System.out.println("Quantidade disponível inválida!");
			qntDisponivel = scanner.nextInt();
		}
		
		this.qntDisponivel = qntDisponivel;
		
		scanner.close();
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public Integer getQntDisponivel() {
		return qntDisponivel;
	}
	
	public void setQntDisponivel(Integer qntDisponivel) {
		this.qntDisponivel = qntDisponivel;
	}
	
	public Integer getQntPag() {
		return qntPag;
	}
	
	public Queue<Usuario> getFilaReservas() {
		return filaReservas;
	}

	public void setFilaReservas(Queue<Usuario> filaReservas) {
		this.filaReservas = filaReservas;
	}
	
	public void setQntPag(Integer qntPag) {
		while(qntPag <= 0) {
			System.out.println("Quantidade de páginas inválida!");
			qntPag = scanner.nextInt();
		}
		
		this.qntPag = qntPag;
		
		scanner.close();
	}
	
	public String getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}
	
	public void setClassificacaoIndicativa(String classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	
	public void listarDados() {		
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Quantidade disponível: " + this.getQntDisponivel());		
	}
	
	// exibir todos os dados
	public void listarTodosDados() {		
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Gênero: " + this.getGenero());
		System.out.println("Quantidade de páginas: " + this.getQntPag());		
		System.out.println("Editora: " + this.getEditora());
		System.out.println("Quantidade disponível: " + this.getQntDisponivel());
		System.out.println("Classificação indicativa: " + this.getClassificacaoIndicativa());		
	}
	
	// atualiza a qnt apos emprestimo
	public void emprestar(Usuario usr) {		
		qntDisponivel--;	
	}
	
	// atualiza a qnt apos devolução
	public void devolver() {
		qntDisponivel++;
	}

	public void reservar(Usuario usuario) {
		filaReservas.add(usuario);
	}
}