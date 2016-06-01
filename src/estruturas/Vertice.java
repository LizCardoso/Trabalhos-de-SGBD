package estruturas;

import java.util.ArrayList;
import estruturas.Transacao;
public class Vertice {
	
	public ArrayList <Transacao> transacaoList = new ArrayList<Transacao>();
	public String nome;
	
	
	//
	public Vertice(String nome){
		this.nome= nome;	
	}
	
	//
	public ArrayList<Transacao> getTransacaoList() {
		return transacaoList;
	}	
	
	public String getNome() {
		return nome;
	}


	//
	public void inserirNoVertice(Transacao t){
		transacaoList.add(t);	
	}
	
	public void removerDoVertice(Transacao t){
		transacaoList.remove(t);	
	}


}
