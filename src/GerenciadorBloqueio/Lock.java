package GerenciadorBloqueio;

import estruturas.Item;
import estruturas.Transacao;


//tabela de bloquei
public class Lock {
	public Item item;
	public Transacao T;
	public String TypeL;
	
	
	public Lock(Item i,Transacao T, String tb){
		this.item = i;
		this.T = T;
		this.TypeL =  tb;
		
	}
	
	public Lock(){
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
	public String getTypeL() {
		return TypeL;
	}
	public void setTypeB(String typeL) {
		TypeL = typeL;
	}
	

}
