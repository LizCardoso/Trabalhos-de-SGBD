package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import GerenciadorBloqueio.Lock_Manager;

import estruturas.Item;
import estruturas.Transacao;


public class Main2 {


public static Transacao buscarTrans(int id, ArrayList<Transacao> lista){
	for (Transacao t: lista){
		if(t.getId()==id)
			return t;
	}
	return null;
}

	public static void main(String[] args) {
		int TS = 0;

		
		Tr_Manager grafo = new Tr_Manager();
		Lock_Manager lock = new Lock_Manager();
		
		String historia;
		Scanner hist = new Scanner(System.in);
		
		ArrayList<Item> itens = new ArrayList<Item>();
		

		System.out.println("Entre a história a ser executada");
		historia=hist.next();
		historia = historia.toLowerCase(); // para tratar todos os comando mais facilmente
		
		int indice;
		char start;
		
		
		for(String comando: historia.split("\\)")){
			indice = comando.indexOf("(");
			int id;
			start = comando.charAt(0);
			switch(start){
			case 'b':
				id = Integer.parseInt(comando.substring(indice+1));
				grafo.criarTrans(id, TS++);
				break;
				
			case 'r':
				id = Integer.parseInt(comando.substring(1, indice)); 
				String item = comando.substring(indice+1);
				Transacao transacao = buscarTrans(id, grafo.getTransacoes());
				itens.add(new Item(item));
				lock.Ls(transacao, itens.get(itens.size()-1), grafo);
				
				lock.TB.listarB();
				lock.WL.listarB();
				break;
				
				
			
			case 'w':
				id = Integer.parseInt(comando.substring(1, indice));
				item = comando.substring(indice+1);
				transacao = buscarTrans(id, grafo.getTransacoes());
				itens.add(new Item(item));
				lock.Lx(transacao, itens.get(itens.size()-1), grafo);
				
				lock.TB.listarB();
				lock.WL.listarB();
				break;
				
			case 'c':
				id = Integer.parseInt(comando.substring(indice+1)); 
				transacao = buscarTrans(id, grafo.getTransacoes());
				grafo.terminate(transacao);
				grafo.commit(transacao);
				grafo.finish(transacao);
				
				lock.TB.listarB();
				lock.WL.listarB();
				
				
				
				break;
			
			default:
				System.out.println("Erro de comando");
				break;
			}
			
		}
		
		
		hist.close();
		
		
	}

}
