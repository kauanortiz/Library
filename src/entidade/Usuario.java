package entidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Usuario {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String cpf;
	private String registro;
	private LocalDate dataNasc;
	private String nome;
	private List<Emprestimo> emprestimosAtivos;
	
	//método construtor geral
	public Usuario(String cpf, String registro, LocalDate dataNasc, String nome) {
		this.cpf = cpf;
		this.registro = registro;
		this.dataNasc = dataNasc;
		this.nome = nome;
		this.emprestimosAtivos = new ArrayList<Emprestimo>();
	}
	
	//construtor principal
	public Usuario(String nome, String registro) {
		this.nome = nome;
		this.registro = registro;
		this.emprestimosAtivos = new ArrayList<Emprestimo>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCPF(String cpf) {
		if(cpf.length() > 11) {
			System.out.println("CPF inválido!\n");
			return;
		}
		this.cpf = cpf;
	}
	
	public String getCPF() {
		return cpf;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public void adicionarEmprestimo(Usuario usr, Emprestimo emprestimo) {
		this.emprestimosAtivos.add(emprestimo);
	}
	
	public void removerEmprestimo(Usuario usr, Emprestimo emprestimo) {
		this.emprestimosAtivos.remove(emprestimo);
	}
	
	public void listarEmprestimos(Usuario usr) {
		for(Emprestimo emprestimo : this.emprestimosAtivos) {
			
			System.out.println("\nEmpréstimos do usuário: " + usr.getNome());
			System.out.println("Item: " + emprestimo.getItem().getTitulo());			
			System.out.println("Emprestado em: " + emprestimo.getEmprestimo().format(fmt));
			System.out.println("Devolver em: " + emprestimo.getDevolucao().format(fmt));
		}
	}
}