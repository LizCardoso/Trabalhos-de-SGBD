package GerenciadorBloqueio;

import java.util.ArrayList;

import estruturas.Item;
import estruturas.Transacao;

public class Wait_List {
	
	public ArrayList<Lock> wait_list = new ArrayList<Lock>(); // lista do tipo fifo
	
	//se existe esse bloqueio na lista de espera
	public boolean verificaExistencia(Item I, Transacao T , String typeL){
		boolean achou = false;
		for(Lock l: wait_list)
				if (I == l.getItem() && T == l.getT() &&  typeL == l.getTypeL())
					achou = true;
		return achou;
	
	}
	
	//retorna o bloqueio 
	public Lock getLock(Item I, Transacao T, String typeL){
		for(Lock l: wait_list)
				if (I == l.getItem() && T == l.getT() &&  typeL == l.getTypeL())
					return l;
		return null;
	}
	
	public void wait( Item I, Transacao T, String typeLock){
		wait_list.add(new Lock( I, T, typeLock ));	
	}
	
	public void stopWait(Item I, Transacao T, String typeLock){
		try{
			wait_list.remove(this.getLock(I,T, typeLock));
		}catch(NullPointerException e) {
			System.out.println("O bloqueio nao pode ser apagado pq ele n existe");
		}
	
	}
}
