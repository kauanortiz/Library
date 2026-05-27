package entidade;

public class Revista extends ItemBiblioteca{
	
	private String editor;
	private String mesPublicacao;
	
	//construtor geral
	public Revista(String titulo, String genero, String editora, Integer qntDisponivel, Integer qntPag,
			String classificacaoIndicativa, String editor, String mesPublicacao) {
		
		super(titulo, genero, editora, qntDisponivel, qntPag, classificacaoIndicativa);		
		this.editor = editor;
		this.mesPublicacao = mesPublicacao;
	}
	
	//construtor principal
	public Revista(String titulo, Integer qntDisponivel) {
		super(titulo, qntDisponivel);		
	}
	
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getMesPublicacao() {
		return mesPublicacao;
	}
	public void setMesPublicacao(String mesPublicacao) {
		this.mesPublicacao = mesPublicacao;
	}
	
	@Override
	public void listarDados() {		
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Editor: " + this.getEditor());
		System.out.println("Mês de publicação: " + this.getMesPublicacao());
		System.out.println("Quantidade disponível: " + this.getQntDisponivel());		
	}
}
