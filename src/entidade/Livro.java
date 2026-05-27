package entidade;

public class Livro extends ItemBiblioteca{

	private String autor;
	
	//construtor geral
	public Livro(String titulo, String genero, String editora, Integer qntDisponivel, Integer qntPag,
			String classificacaoIndicativa, String autor) {
		
		super(titulo, genero, editora, qntDisponivel, qntPag, classificacaoIndicativa);		
		this.autor = autor;
	}
	
	//construtor principal
	public Livro(String titulo, Integer qntDisponivel) {
		super(titulo, qntDisponivel);		
	}
	
	public String getAutor() {
		return autor;
	}

	// apenas setters para atributos não settados no método construtor
	public void setAutor(String autor) {
		this.autor = autor;
	}

	// exibir dados principais
	@Override
	public void listarDados() {		
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Autor: " + this.getAutor());
		System.out.println("Quantidade disponível: " + this.getQntDisponivel());		
	}
	
	// exibir todos os dados
	@Override
	public void listarTodosDados() {		
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Gênero: " + this.getGenero());
		System.out.println("Quantidade de páginas: " + this.getQntPag());
		System.out.println("Autor: " + this.getAutor());
		System.out.println("Editora: " + this.getEditora());
		System.out.println("Quantidade disponível: " + this.getQntDisponivel());
		
	}
}