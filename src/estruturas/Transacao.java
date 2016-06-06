package estruturas;

public class Transacao {
	public int Id;
	public String estado;
	public int TS;
	public Item item;
	

	//
	public Transacao( int id, Vertice v, int TS){
		this.Id = id;
		this.estado = "TR_Iniciada";
		this.TS = TS;
		v.transacaoList.add(this);
	}
	
	
	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
	
	//
	public Transacao( int id, Vertice v){
		this.Id = id;
		this.estado = "TR_Iniciada";
		v.transacaoList.add(this);		
	}
	
	
	// 
	public int getId() {
		return Id;
	}

	public String getEstado() {
		return estado;
	}
	
	public int getTS() {
		return TS;
	}
	
	public void setTS(int TS) {
		this.TS = TS;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	//metodos
	public void movimentar(Aresta a){
			a.destino.removerDoVertice(this);
			a.origem.inserirNoVertice(this);
			this.setEstado(a.destino.getNome());			
	}
	
}


