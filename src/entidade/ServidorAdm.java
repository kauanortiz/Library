package entidade;

import java.time.LocalDate;

public class ServidorAdm extends Usuario{
	
	private Integer limite_emprestimos;
	
	public ServidorAdm(String cpf, String registro, LocalDate dataNasc, String nome, Integer limite_emprestimos) {
		super(cpf, registro, dataNasc, nome);
		this.limite_emprestimos = limite_emprestimos;
	}
	
	public ServidorAdm(String nome, String registro, Integer limite_emprestimos) {
		super(nome, registro);
		this.limite_emprestimos = limite_emprestimos;
	}

}
