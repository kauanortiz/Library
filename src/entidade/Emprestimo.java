package entidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
	
	// layout das datas
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Usuario usr;
	private ItemBiblioteca item;
	private LocalDate emprestimo;
	private LocalDate devolucao;
	private boolean devolvido = false;
	private float multa;
	
	public Emprestimo(Usuario usr, ItemBiblioteca item) {
				
		this.usr = usr;
		this.item = item;
		this.emprestimo = LocalDate.now();
		this.devolucao = emprestimo.plusDays(7);	
			
	}

	public Usuario getUsr() {
		return usr;
	}

	public ItemBiblioteca getItem() {
		return item;
	}

	public LocalDate getEmprestimo() {
		return emprestimo;
	}

	public LocalDate getDevolucao() {
		return devolucao;
	}
	
	public boolean getDevolvido() {
		return devolvido;
	}
	
	/* verifica se a data atual ultrapassou a data da devolução
	(! retorna o valor invertido, pois o false caíria em "Empréstimo vencido!\n"*/
	public boolean situacaoEmprestimo() {
		if(devolvido) return false;
		return !LocalDate.now().isAfter(devolucao);
	}
	
	public long calcularAtraso() {
		
		// verifica se já passou do prazo de devolução
		if(LocalDate.now().isAfter(devolucao)) {
			// se sim, retorna em dias o tempo entre a devolução e o prazo
			return devolucao.until(LocalDate.now()).getDays();
		}
		
		// se não, retorna 0 (0 dias de atraso)
		return 0;
	}
	
	public float calcularMulta() {
		
		if(calcularAtraso() == 0) {
			multa = 0;
			
		}else if(calcularAtraso() <= 3) {
			multa = (float) ((float) calcularAtraso() * 2.0);
			
		}else {
			multa = (float) ((float) calcularAtraso() * 5.0);
		}
		
		return multa;
	}
	
	public void devolucao() {
		
		if(devolvido) {
			throw new RuntimeException("Item já devolvido!");
		}
		
		item.devolver();
		devolvido = true;
		
		if(calcularAtraso() > 0) {
			System.out.println("Item devolvido com atraso!");
			System.out.println("Dias de atraso: " + calcularAtraso());
			System.out.println("Valor da multa: R$ " + calcularMulta());
			
		}else {
			System.out.println("Item devolvido no prazo!\n");
		}
	}
}
