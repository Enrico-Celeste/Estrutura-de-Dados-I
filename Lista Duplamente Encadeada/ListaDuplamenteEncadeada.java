public class ListaDuplamenteEncadeada {
	private NoLDE primeira = null;
	private NoLDE ultima = null;
	private int contador=0;
	
	public void Insere(Object elemento) {
		//insere no come�o da lista
		//TODO
		NoLDE novo = new NoLDE(elemento, this.primeira);
		this.primeira = novo;
		if (this.contador == 0) {
			this.ultima = this.primeira;
		}  
		this.contador = this.contador + 1;
	}
	public void InsereF(Object elemento) {
		//Inserir no fim da lista
		//TODO
		if(this.contador == 0) {
			this.Insere(elemento);
		}else {
			NoLDE novo = new NoLDE(elemento,null);
			this.ultima.setProximo(novo);
			this.ultima = novo;
			this.contador = this.contador+1;
		}
	}
		
	public Object MostraNodo(int posicao) {
		//retorna o elemento da posicao solicitada.
		//use getElemento()
		NoLDE atual = this.primeira;
		for(int i=0;i < posicao;i++) {
			atual = atual.getProximo();
			
		}
		return atual.getElemento();
	}
	
	public int Tamanho() {
		return this.contador;
	}

	public void Remove() {
		//Remove um elemento do come�o da lista.
		//TODO
		if(this.contador == 0) {
			throw new IllegalArgumentException("Lista Vazia.");
		}		
		this.primeira=this.primeira.getProximo(); 
		this.contador=contador-1;
		if(this.contador == 0) {
			this.ultima = null;
		}
	} 	
	
	public void RemoveF() {
		//TODO
		if(this.contador == 0) {
			throw new IllegalArgumentException("Lista Vazia.");
		}
		NoLDE aux = this.primeira;
		for(int i = 1; i < this.contador; i++){
			aux = aux.getProximo();
			if(aux.getProximo().getProximo() == null){
				aux.setProximo(null);
				this.contador--;
			}
		}
	}
	
	public boolean Verifica(Object obj) {
		//Faz a busca por um elemento na lista.
		NoLDE atual = this.primeira;
		while(atual != null) {
			if(atual.getElemento().equals(obj)) {
				return true;
			}
		atual = atual.getProximo();
		}
		return false;
	}
	
	public String ShowList() {
		if (contador ==0) {
			return "[ ]";
		}
		NoLDE atual = primeira;
		StringBuilder builder = new StringBuilder("[");
		for(int i=0;i < contador;i++) {
			builder.append(atual.getElemento());
			builder.append(",");
			atual = atual.getProximo();
		}
		builder.append("]");
		return builder.toString();
	}

}

