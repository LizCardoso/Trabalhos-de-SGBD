package GerenciadorBloqueio;

import estruturas.Item;
import estruturas.Transacao;


//tabela de bloquei
public class Bloqueio {
	public Item item;
	public Transacao T;
	public String TypeBolc;
	
	
	public Bloqueio(Item i,Transacao T, String tb){
		this.item = i;
		this.T = T;
		this.TypeBolc =  tb;
		
	}
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Transacao getT() {
		return T;
	}
	public void setT(Transacao t) {
		T = t;
	}
	public String getTypeBolc() {
		return TypeBolc;
	}
	public void setTypeBolc(String typeBolc) {
		TypeBolc = typeBolc;
	}
	

}
