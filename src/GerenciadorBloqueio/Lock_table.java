package GerenciadorBloqueio;

import java.util.ArrayList;

import GerenciadorBloqueio.Lock;

import estruturas.Item;
import estruturas.Transacao;

public class Lock_table {
	
	ArrayList<Lock> listBloqueio;
	
	
	public Lock_table(){
		listBloqueio = new ArrayList<Lock>();
	}
	//se existe esse bloqueio
	public boolean verificaExistenciaExclusivaB(Item I){
		boolean achou = false;
		for(Lock t: listBloqueio){
			if (I.getId().equals(t.getItem().getId()) && t.getTypeL().equals("BE"))
				achou = true;
		}
		return achou;
	
	}
	
	public boolean verificaExistenciaCompartilhadaB(Item I){
		boolean achou = false;
		for(Lock t: listBloqueio){
			if (I.getId().equals(t.getItem().getId()) && t.getTypeL().equals("BC"))
				achou = true;				
		}
		return achou;
	
	}
	
	//retorna o bloqueio
	public Lock buscarB(Item I, Transacao T){
		for(Lock b: listBloqueio)
				if (I == b.getItem() && T == b.getT())
					return b;
		return null;
	}
	
	public void bloquear( Item I, Transacao T, String tipoB){
		listBloqueio.add(new Lock( I, T, tipoB ));	
	}
	
	public void desbloquear(Item I, Transacao T){
		try{
			listBloqueio.remove(this.buscarB(I,T));
		}catch(NullPointerException e) {
			System.out.println("O bloqueio nao pode ser apagado pq ele n existe");
		}
	}
	
	public void listarB(){
		System.out.println("\nBloqueioExistentes:\n");
		 for(Lock t: this.listBloqueio){
			 System.out.println("Item: "+ t.getItem().getId()+ "Transacao: "+ t.getT().Id + "Tipo: " + t.getTypeL());
		 }
		 System.out.println("---------------||---------------"); 
	}
	
	
}
