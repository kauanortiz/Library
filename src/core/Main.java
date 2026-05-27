package core;

import entidade.Livro;
import entidade.Tese;
import entidade.Usuario;
import entidade.Biblioteca;
import entidade.Revista;
import entidade.ServidorAdm;

public class Main {

	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca();
		
		//Cadastro de usuários (Cria o objeto e adiciona na lista da biblioteca)
		Usuario usr1 = new Usuario("Kauan", "12345");
		biblioteca.addUsr(usr1);
		Usuario usr2 = new Usuario("João", "54321");
		biblioteca.addUsr(usr2);
		Usuario usr3 = new Usuario("Jonas", "24112");
		biblioteca.addUsr(usr3);
		
		//Cadastro de itens (Cria o objeto e adiciona na lista da biblioteca)
		Livro livro1 = new Livro("Os sofrimentos do jovem Werther", 1);
		biblioteca.addItem(livro1);
		Livro livro2 = new Livro("Leviatã", 1);
		biblioteca.addItem(livro2);
		Revista revista1 = new Revista("Placar", 7);
		biblioteca.addItem(revista1);
		Tese tese1 = new Tese("MODELAGEM DA DINÂMICA DE ALGAS E CIANOBACTÉRIAS EM"
				+ " UM RESERVATÓRIO DE ABASTECIMENTO", 1);
		biblioteca.addItem(tese1);
		
		/*Realização de empréstimos (Verifica se o empréstimo é possível,
		se sim, realiza, se não, exibe "Item indisponível!"*/
		biblioteca.realizarEmprestimo(usr1, livro1);
		biblioteca.realizarEmprestimo(usr1, livro2);
		//tentativa de emprestar um item indisponível, adição de reserva e exposição de prioridade
		biblioteca.realizarEmprestimo(usr2, livro2);
		
		/*Devolução de item (Realiza a devolução, verifica se o item
		foi devolvido no prazo e, se não, mostra os dias de atraso e a multa a pagar, verifica
		se alguém está esperando pelo item e, se estiver, realiza um empréstimo automático*/
		biblioteca.realizarDevolucao(usr1, livro2);

		//lista os emprestimos do aluno1
		usr1.listarEmprestimos(usr1);
				
		/*Listagem final da situação da biblioteca (Lista os itens, usuários,
		empréstimos ativos e finalizados que foram cadastrados na biblioteca)*/
		biblioteca.listarItens();
		biblioteca.listarUsr();
		biblioteca.listarEmprestimosAtivos();
		biblioteca.listarEmprestimosFinalizados();			
	}
}