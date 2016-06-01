package estruturas;

public class Transacao {
	public int Id;
	public String estado;
<<<<<<< HEAD
	public int TS;
	public Item item;
	

	//
	public Transacao( int id, Vertice v, int TS){
		this.Id = id;
		this.estado = "TR_Iniciada";
		v.transacaoList.add(this);
		this.TS = TS;
	}
	
	
	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
=======
	
	//
	public Transacao( int id, Vertice v){
		this.Id = id;
		this.estado = "TR_Iniciada";
		v.transacaoList.add(this);		
	}
	
	
	// 
>>>>>>> 2d3227466be2cc734abdaddce45ea28243f4f4f3
	public int getId() {
		return Id;
	}

	public String getEstado() {
		return estado;
	}
<<<<<<< HEAD
	
	public int getTS() {
		return TS;
	}
	
	public void setTS(int TS) {
		this.TS = TS;
	}
=======
>>>>>>> 2d3227466be2cc734abdaddce45ea28243f4f4f3

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


