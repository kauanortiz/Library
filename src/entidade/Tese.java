package entidade;

public class Tese extends ItemBiblioteca{
	
	private String autor;
	private String orientador;
	private String areaPesquisa;
	
	//construtor geral
	public Tese(String titulo, String genero, String editora, Integer qntDisponivel, Integer qntPag,
			String classificacaoIndicativa, String autor, String orientador, String areaPesquisa) {
		
		super(titulo, genero, editora, qntDisponivel, qntPag, classificacaoIndicativa);		
		this.autor = autor;
		this.orientador = orientador;
		this.areaPesquisa = areaPesquisa;
	}
	
	//construtor principal
	public Tese(String titulo, Integer qntDisponivel) {
		super(titulo, qntDisponivel);		
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public String getAreaPesquisa() {
		return areaPesquisa;
	}

	public void setAreaPesquisa(String areaPesquisa) {
		this.areaPesquisa = areaPesquisa;
	}
	
	@Override
	public void listarDados() {		
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Editor: " + this.getAutor());
		System.out.println("Orientador: " + this.getOrientador());
		System.out.println("Área de pesquisa: " + this.getAreaPesquisa());
		System.out.println("Quantidade disponível: " + this.getQntDisponivel());		
	}
}
