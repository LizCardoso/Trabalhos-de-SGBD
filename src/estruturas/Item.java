package estruturas;

import java.util.ArrayList;


public class Item {
	public String id;
	ArrayList<Transacao> Wait_Q = new ArrayList<Transacao>();
	

	public ArrayList<Transacao> getWait_Q() {
		return Wait_Q;
	}


	public Item(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}

	
}
	

