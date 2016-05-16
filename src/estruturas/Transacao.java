package estruturas;

public class Transacao {
	public int Id;
	public String estado;
	
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


