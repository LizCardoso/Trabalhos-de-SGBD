package GerenciadorBloqueio;

import estruturas.Item;
import estruturas.Transacao;

//gerenciador de bloqueo
	//tabela de bloqueio e e lista de espera
public class Lock_Manager {
	
	public Lock_table TB;

	
	// insere um bloqueio no modo compartilhado na Lock_table spbre o item I para transacao T se puder, caso contrario cri/atualiza a Wait_Q de I com a transacao Tr
	public void Ls( Transacao T, Item I){
		if(this.TB.buscarTB(I)){
			I.getWait_Q().add(T);	
		}else
			this.TB.listBloqueio.add(new Bloqueio(I, T,"BC"));	
	}
			
	// insere um bloqueio no modo exclusivo na Lock_table spbre o item I para a transação T se puder, caso contrario cri/atualiza a Wait_Q de I com a transação Tr
	public void Lx(Transacao T, Item I){
		if(this.TB.buscarTB(I)){
			I.getWait_Q().add(T);	
		}else
			this.TB.listBloqueio.add(new Bloqueio(I, T,"BE"));	
	}
		
	
	// apaga o bloqueio da transação T sobre o item I na lock_table
	public void U (Transacao T, Item I){   //procurar o bloqueio correspondente 
		if(TB.buscarB(I, T) == null)
			System.out.println("O bloqueio n pode ser apagado pq ele n existe");
		else
			TB.listBloqueio.remove(TB.buscarB(I, T));
	}
		
}
