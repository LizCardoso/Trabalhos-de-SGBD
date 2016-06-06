package Principal;

import java.util.ArrayList;

import estruturas.Aresta;
import estruturas.Transacao;
import estruturas.Vertice;

//gerencia o grafo
public class Tr_Manager {
	
	ArrayList<Transacao> transacoes;

//grafo 
	public Vertice TR_Iniciada;
	public Vertice Ativa;
	public Vertice Processo_Cancelamento;
	public Vertice Processo_Efetivacao;
	public Vertice Efetivada;
	public Vertice TR_Finalizada;
	
	
	public Aresta READ1;
	public Aresta READ2;
	public Aresta TR_Terminate;
	public Aresta TR_RollBack1;
	public Aresta TR_RollBack2;
	public Aresta TR_Commit;
	public Aresta TR_Finish1;
	public Aresta TR_Finish2;
	
	public void listarT(ArrayList<Transacao> transacoes){
		System.out.println("\nEstado do Grafo:\n");
		 for(Transacao t: transacoes){
			 System.out.println("Transacao: "+t.getId()+" -- Estado: "+t.getEstado());
		 }
		 System.out.println("---------------||---------------"); 
	}
	public Tr_Manager(){
		transacoes = new ArrayList<Transacao>();
	
	//grafo 
		TR_Iniciada = new Vertice("TR_Iniciada");
		Ativa = new Vertice("Ativa");
		Processo_Cancelamento = new Vertice("Processo_Cancelamento");
		Processo_Efetivacao = new Vertice("Processo_Efetivacao");
		Efetivada = new Vertice("Efetivada");
		TR_Finalizada = new Vertice("TR_Finalizada");
		
		
		READ1 = new Aresta(TR_Iniciada, Ativa);
		READ2 = new Aresta(Ativa, Ativa);
		TR_Terminate = new Aresta(Ativa, Processo_Efetivacao);
		TR_RollBack1 = new Aresta(Ativa, Processo_Cancelamento);
		TR_RollBack2 = new Aresta(Processo_Efetivacao, Processo_Cancelamento);
		TR_Commit = new Aresta(Processo_Efetivacao, Efetivada);
		TR_Finish1 = new Aresta(Processo_Cancelamento, TR_Finalizada);
		TR_Finish2 = new Aresta(Efetivada, TR_Finalizada);
	}	
	
	public ArrayList<Transacao> getTransacoes() {
		return transacoes;
	}

	public Vertice getTR_Iniciada() {
		return TR_Iniciada;
	}

	public Vertice getAtiva() {
		return Ativa;
	}

	public Vertice getProcesso_Cancelamento() {
		return Processo_Cancelamento;
	}

	public Vertice getProcesso_Efetivacao() {
		return Processo_Efetivacao;
	}

	public Vertice getEfetivada() {
		return Efetivada;
	}

	public Vertice getTR_Finalizada() {
		return TR_Finalizada;
	}

	public Aresta getREAD1() {
		return READ1;
	}

	public Aresta getREAD2() {
		return READ2;
	}

	public Aresta getTR_Terminate() {
		return TR_Terminate;
	}

	public Aresta getTR_RollBack1() {
		return TR_RollBack1;
	}

	public Aresta getTR_RollBack2() {
		return TR_RollBack2;
	}

	public Aresta getTR_Commit() {
		return TR_Commit;
	}

	public Aresta getTR_Finish1() {
		return TR_Finish1;
	}

	public Aresta getTR_Finish2() {
		return TR_Finish2;
	}
		
	
	public void criarTrans(int id, int TS){
		transacoes.add(new Transacao(id, TR_Iniciada, TS));
		this.listarT(transacoes);
	}
		
	public void readWrite(Transacao t)	{
		try{
			if(t.getEstado()=="TR_Iniciada")
				t.movimentar(READ1);
			else if(t.getEstado()=="Ativa")
				t.movimentar(READ2);
			else
				System.out.println("Nao foi possivel fazer a movimentacao\n");
		}catch(IndexOutOfBoundsException e){
				System.out.println("TRANSACAO NAO EXISTE\n");
		}finally{
			this.listarT(transacoes);
		}
	}
	
	public void terminate(Transacao t){
		try{
			if(t.getEstado()=="Ativa")
				t.movimentar(TR_Terminate);
			else
				System.out.println("Nao foi possivel fazer a movimentacao\n");
		}catch(IndexOutOfBoundsException e){
				System.out.println("TRANSACAO NAO EXISTE\n");
		}finally{
			this.listarT(transacoes);
		}
	}
	
	public void rollback(Transacao t){
		try{
			if(t.getEstado()=="Ativa")
				t.movimentar(TR_RollBack1);
			else if(t.getEstado()=="Processo_Efetivacao")
				t.movimentar(TR_RollBack2);
			else
				System.out.println("Nao foi possivel fazer a movimentacao\n");
		}catch(IndexOutOfBoundsException e){
				System.out.println("TRANSACAO NAO EXISTE\n");
		}finally{
			this.listarT(transacoes);
		}
	}
	
	public void commit(Transacao t){
		try{
			if(t.getEstado()=="Processo_Efetivacao")
				t.movimentar(TR_Commit);
			else
				System.out.println("Nao foi possivel fazer a movimentacao\n");
		}catch(IndexOutOfBoundsException e){
				System.out.println("TRANSACAO NAO EXISTE\n");
		}finally{
			this.listarT(transacoes);
		}
	}
	
	public void finish(Transacao t){
		try{
			if(t.getEstado()=="Processo_Cancelamento")
				t.movimentar(TR_Finish1);
			else if(t.getEstado()=="Efetivada")
				t.movimentar(TR_Finish2);
			else
				System.out.println("Nao foi possivel fazer a movimentacao\n");
		}catch(IndexOutOfBoundsException e){
				System.out.println("TRANSACAO NAO EXISTE\n");
		}finally{
			this.listarT(transacoes);
		}
	}
}
