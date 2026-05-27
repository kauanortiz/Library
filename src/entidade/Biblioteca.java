package entidade;

import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Biblioteca {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private List<ItemBiblioteca> itens;
	private List<Usuario> usuarios;
	private List<Emprestimo> emprestimos; 
	
	public Biblioteca() {
		this.itens = new ArrayList<ItemBiblioteca>();
		this.usuarios = new ArrayList<Usuario>();
		this.emprestimos = new ArrayList<Emprestimo>(); 
	}

	// add livro
	public void addItem(ItemBiblioteca item) {
		this.itens.add(item);
	}
	
	// remover livros
	public void removerItem(ItemBiblioteca item) {
		this.itens.remove(item);
	}

	// add usuários
	public void addUsr(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	// remover usuários
	public void removerUsr(Usuario usuario) {
		this.usuarios.remove(usuario);
	}
	
	// add empréstimos
	public void addEmprestimo(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
	}
	
	// remover empréstimos
	public void removeEmprestimo(Emprestimo emprestimo) {
		this.emprestimos.remove(emprestimo);
	}
	
	public void realizarEmprestimo(Usuario usuario, ItemBiblioteca item) {
		
	    if(usuario == null || item == null) {
	        throw new IllegalArgumentException("Usuário ou item inválido");
	    }
		
	    if(item.getQntDisponivel() > 0) {

	        item.emprestar(usuario);

	        Emprestimo emprestimo = new Emprestimo(usuario, item);

	        addEmprestimo(emprestimo);
	        usuario.adicionarEmprestimo(usuario, emprestimo);

	        System.out.println("Empréstimo realizado com sucesso!");

	    }else{

	        item.reservar(usuario);

	        System.out.println("Item indisponível. A prioridade é de: " + usuario.getNome());
	    }
	}
	
	public void realizarDevolucao(Usuario usuario, ItemBiblioteca item) {
		
		for(Emprestimo emprestimo : this.emprestimos) {

	        if(emprestimo.getItem() == item && emprestimo.getUsr() == usuario) {

	            emprestimo.devolucao();
	            usuario.removerEmprestimo(usuario, emprestimo);

	            if(!item.getFilaReservas().isEmpty()) {

	                Usuario proximo = item.getFilaReservas().poll();

	                if(proximo != null) {
	                    realizarEmprestimo(proximo, item);
	                }
	            }

	            return;
	        }
		}
			
			throw new RuntimeException("Empréstimo não encontrado!");
	}
	
	// listar itens usando método de ItemBiblioteca
	public void listarItens() {
		
		System.out.println("\nItems:\n");
		
		for(ItemBiblioteca item : this.itens) {
			item.listarDados();
			System.out.println("\n");
		}
	}
	
	// listar livros usando método de ItemBiblioteca
	public void listarLivros() {
		
		System.out.println("\nLivros:\n");
		
		for(ItemBiblioteca item : this.itens) {
			if(item instanceof Livro) {
				item.listarDados();
				System.out.println("\n");
			}
		}
	}
	
	// listar revistas usando método de ItemBiblioteca
	public void listarRevistas() {
		System.out.println("\nRevistas:\n");
		
		for(ItemBiblioteca item : this.itens) {
			if(item instanceof Revista) {
				item.listarDados();
				System.out.println("\n");
			}
		}
	}
	
	// listar teses usando método de ItemBiblioteca
	public void listarTeses() {
		System.out.println("\nTeses:\n");
		
		for(ItemBiblioteca item : this.itens) {
			if(item instanceof Tese) {
				item.listarDados();
				System.out.println("\n");
			}
		}
	}
	
	// lista livros disponíveis
	public void listarItensDisp() {
		
		System.out.println("Itens disponíveis:\n");
		
		for(ItemBiblioteca item : this.itens) {
			if(item.getQntDisponivel() > 0) {
				item.listarDados();
				System.out.println("\n");
			}
		}
	}
	
	// lista livros indisponíveis
	public void listarItensIndisp() {
		
		System.out.println("Itens indisponíveis:\n");
		
		for(ItemBiblioteca item : this.itens) {
			if(item.getQntDisponivel() == 0) {
				item.listarDados();
				System.out.println("\n");
			}
		}
	}
	
	// listar todos os itens e todos os dados
	public void listarItensCompleto() {
		for(ItemBiblioteca item : this.itens) {
			item.listarTodosDados();
			System.out.println("\n");
		}
	}
	
	// filtrar livros por genero
	public void filtrarItens(String genero) {
		for(ItemBiblioteca item : this.itens) {
			if(genero == item.getGenero()) {
				System.out.println("\nFiltrado por gênero: " + genero);
				System.out.println("Título: " + item.getTitulo());
				System.out.println("Gênero: " + item.getGenero());
			}
		}
	}
	
	// lista empréstimos ativos
	public void listarEmprestimosAtivos() {
		
		Integer aux = 0;
		System.out.println("Empréstimos ativos:\n");
		
		for(Emprestimo emprestimo : this.emprestimos) {
			if(emprestimo.getDevolvido() == false) {
				System.out.println("Aluno: " + emprestimo.getUsr().getNome());
				System.out.println("Item: " + emprestimo.getItem().getTitulo());
				System.out.println("Emprestado em: " + emprestimo.getEmprestimo().format(fmt));
				System.out.println("Devolver em: " + emprestimo.getDevolucao().format(fmt));
				System.out.println("Situação: ativo\n");
				
				aux = 1;
			}
		}
		
		if(aux == 0) {
			System.out.println("Nenhum empréstimo ativo!\n");
		}
	}
	
	// lista empréstimos finalizados
	public void listarEmprestimosFinalizados() {
		
		Integer aux = 0;
		System.out.println("Empréstimos finalizados:\n");
		
		for(Emprestimo emprestimo : this.emprestimos) {
			if(emprestimo.getDevolvido()) {
				System.out.println("Aluno: " + emprestimo.getUsr().getNome());
				System.out.println("Item: " + emprestimo.getItem().getTitulo());
				System.out.println("Emprestado em: " + emprestimo.getEmprestimo().format(fmt));
				System.out.println("Devolver em: " + emprestimo.getDevolucao().format(fmt));
				System.out.println("Situação: finalizado\n");
				
				aux = 1;
			}
		}
		
		if(aux == 0) {
			System.out.println("Nenhum empréstimo finalizado!\n");
		}
	}
	
	// lista empréstimos de um usuário específico
	public void listarEmprestimosUsr(Usuario usr) {
		
		Integer aux = 0;
		System.out.println("Empréstimos de: " + usr.getNome());
		
		for(Emprestimo emprestimo : this.emprestimos) {
			if(emprestimo.getUsr().getNome() == usr.getNome()) {
				System.out.println("Item: " + emprestimo.getItem().getTitulo());
				System.out.println("Emprestado em: " + emprestimo.getEmprestimo().format(fmt));
				System.out.println("Devolver em: " + emprestimo.getDevolucao().format(fmt));
				System.out.println("\n");
				
				if(emprestimo.getDevolvido()) {
					System.out.println("Situação: finalizado\n");
					
				}else {
					System.out.println("Situação: ativo\n");
				}
				aux = 1;
			}
		}
		
		if(aux == 0) {
			System.out.println("O usuário não fez nenhum empréstimo!\n");
		}
	
	}
	
	// listar usuários	
	public void listarUsr() {
		
	    if(this.usuarios == null || this.usuarios.isEmpty()) {
	        System.out.println("Nenhum usuário cadastrado.");
	        return;
	    }

	    System.out.println("Usuários:\n");
	    
	    for(Usuario usuario : this.usuarios) {	    	
	    	System.out.println("Nome: " + usuario.getNome());
	        System.out.println("Registro: " + usuario.getRegistro());
	        System.out.println("\n");
	    }
	}
}