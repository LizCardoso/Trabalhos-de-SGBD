package GerenciadorBloqueio;

import java.util.ArrayList;

import estruturas.Item;
import estruturas.Transacao;

public class Lock_table {
	
	ArrayList<Bloqueio> listBloqueio = new ArrayList<Bloqueio>();
	
	
	//se existe esse bloqueio
	public boolean buscarTB(Item I){
		boolean achou = false;
		for(Bloqueio t: listBloqueio)
				if (I == t.getItem())
					achou = true;
		
		return achou;
	
	}
	
	//retorna o bloqueio
	public Bloqueio buscarB(Item I, Transacao T){
		
		for(Bloqueio b: listBloqueio)
				if (I == b.getItem() && T == b.getT())
					return b;
		return null;
	}
	
	
}
