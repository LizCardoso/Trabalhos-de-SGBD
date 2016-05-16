package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import estruturas.Aresta;
import estruturas.Transacao;
import estruturas.Vertice;


public class Main2 {

public static void listar(ArrayList<Transacao> lista){
	System.out.println("Estas são as transações existentes\n");
	for(Transacao t: lista){
		System.out.println("Transacao "+ t.getId()+ ", Estado: "+ t.getEstado());
	}
}


public static int menu(){
	Scanner opcMenu = new Scanner(System.in);
	int saida;
	System.out.println("\nO que voce deseja fazer?");
	System.out.println("Criar uma nova transação: digite 1");
	System.out.println("Movimentar uma transação: digite 2");
	System.out.println("Sair: digite 3");
	saida=opcMenu.nextInt();
	return saida;
}

public static int operacoes(){
	Scanner opc = new Scanner(System.in);
	int saida;
	System.out.println("");
	System.out.println("O que você deseja fazer?");
	System.out.println("Read ou Write digite 1");
	System.out.println("Terminar uma Transação digite 2");
	System.out.println("Rollback digite 3 ");
	System.out.println("Commit digite 4");
	System.out.println("Finalizar digite 5");
	saida=opc.nextInt();
	return saida;
	
}

	public static void main(String[] args) {
		int iteracao = 0, //loop do menu principal
			//criacao = 0, 
			opcao, //opcao do menu principal
			operacao, //recebe a operacao a ser realizada
			tranOpc;
		
		ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
		
		Scanner opc = new Scanner(System.in);
		
		Vertice TR_Iniciada = new Vertice("TR_Iniciada");
		Vertice Ativa = new Vertice("Ativa");
		Vertice Processo_Cancelamento = new Vertice("Processo_Cancelamento");
		Vertice Processo_Efetivacao = new Vertice("Processo_Efetivacao");
		Vertice Efetivada = new Vertice("Efetivada");
		Vertice TR_Finalizada = new Vertice("TR_Finalizada");
		
		
		Aresta READ1 = new Aresta(TR_Iniciada, Ativa);
		Aresta READ2 = new Aresta(Ativa, Ativa);
		Aresta TR_Terminate = new Aresta(Ativa, Processo_Efetivacao);
		Aresta TR_RollBack1 = new Aresta(Ativa, Processo_Cancelamento);
		Aresta TR_RollBack2 = new Aresta(Processo_Efetivacao, Processo_Cancelamento);
		Aresta TR_Commit = new Aresta(Processo_Efetivacao, Efetivada);
		Aresta TR_Finish1 = new Aresta(Processo_Cancelamento, TR_Finalizada);
		Aresta TR_Finish2 = new Aresta(Efetivada, TR_Finalizada);

		
	
		
		do{
				listar(transacoes);
				
				opcao = menu();
				switch(opcao){
				
				case 1:
					transacoes.add(new Transacao(transacoes.size()+1, TR_Iniciada));
					break;
					
				case 2:
					System.out.println("Qual é a transacao que voce deseja mover?");
					tranOpc=opc.nextInt();
					operacao=operacoes();
					Transacao Tauxiliar;
					switch(operacao){
					case 1:
						try{
						Tauxiliar = transacoes.get(tranOpc-1);
						if(Tauxiliar.getEstado()=="TR_Iniciada")
							Tauxiliar.movimentar(READ1);
						else if(Tauxiliar.getEstado()=="Ativa")
							Tauxiliar.movimentar(READ2);
						else
							System.out.println("Nao foi possivel fazer a movimentacao\n");
						}catch(IndexOutOfBoundsException e){
							System.out.println("TRANSACAO NAO EXISTE\n");
						}
						break;
					case 2:
						try{
						Tauxiliar = transacoes.get(tranOpc-1);
						if(Tauxiliar.getEstado()=="Ativa")
							Tauxiliar.movimentar(TR_Terminate);
						else
							System.out.println("Nao foi possivel fazer a movimentacao\n");
						}catch(IndexOutOfBoundsException e){
							System.out.println("TRANSACAO NAO EXISTE\n");
						}
						break;
					case 3:
						try{
						Tauxiliar = transacoes.get(tranOpc-1);
						if(Tauxiliar.getEstado()=="Ativa")
							Tauxiliar.movimentar(TR_RollBack1);
						else if(Tauxiliar.getEstado()=="Processo_Efetivacao")
							Tauxiliar.movimentar(TR_RollBack2);
						else
							System.out.println("Nao foi possivel fazer a movimentacao\n");
						}catch(IndexOutOfBoundsException e){
							System.out.println("TRANSACAO NAO EXISTE\n");
						}
						break;
					case 4:
						try{
						Tauxiliar = transacoes.get(tranOpc-1);
						if(Tauxiliar.getEstado()=="Processo_Efetivacao")
							Tauxiliar.movimentar(TR_Commit);
						else
							System.out.println("Nao foi possivel fazer a movimentacao\n");
						}catch(IndexOutOfBoundsException e){
							System.out.println("TRANSACAO NAO EXISTE\n");
						}
						break;
					case 5:
						try{
						Tauxiliar = transacoes.get(tranOpc-1);
						if(Tauxiliar.getEstado()=="Processo_Cancelamento")
							Tauxiliar.movimentar(TR_Finish1);
						else if(Tauxiliar.getEstado()=="Efetivada")
							Tauxiliar.movimentar(TR_Finish2);
						else
							System.out.println("Nao foi possivel fazer a movimentacao\n");
						}catch(IndexOutOfBoundsException e){
							System.out.println("TRANSACAO NAO EXISTE\n");
						}
						break;	
					}
					break;
					
					
				case 3:
				 iteracao = 1;
				 break;
				}
				
		}while(iteracao==0);
	}

}
