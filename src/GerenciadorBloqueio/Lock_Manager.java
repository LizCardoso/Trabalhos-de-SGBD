package GerenciadorBloqueio;


import Principal.Tr_Manager;

import estruturas.Item;
import estruturas.Transacao;

//gerenciador de bloqueo
	//tabela de bloqueio e e lista de espera
public class Lock_Manager {
	
	public Lock_table TB;
	public Wait_List WL;
	
	public Lock_Manager(){
		TB= new Lock_table();
		WL = new Wait_List();
	}
	// insere um bloqueio no modo compartilhado na Lock_table spbre o item I para transacao T 
	//se puder, caso contrario cri/atualiza a Wait_Q de I com a transacao Tr
	public void Ls( Transacao T, Item I, Tr_Manager grafo){
		if(this.TB.verificaExistenciaExclusivaB(I) == true){
			WL.wait(I, T, "BC");	
		}else{
			this.TB.bloquear(I, T, "BC");
			grafo.readWrite(T);
			
		}
	}
			
	// insere um bloqueio no modo exclusivo na Lock_table spbre o item I para a transação T
	//se puder, caso contrario cri/atualiza a Wait_Q de I com a transação Tr
	public void Lx(Transacao T, Item I, Tr_Manager grafo){
		if(this.TB.verificaExistenciaExclusivaB(I) == true || this.TB.verificaExistenciaCompartilhadaB(I)== true ){
			WL.wait(I, T, "BE");	
		}else{
			this.TB.bloquear(I, T, "BE");
			grafo.readWrite(T);
			
		}
	}
		
	
	// apaga o bloqueio da transação T sobre o item I na lock_table
	public void U (Transacao T, Item I){   //procurar o bloqueio correspondente 
			TB.desbloquear(I, T);
	}
	
		
}
