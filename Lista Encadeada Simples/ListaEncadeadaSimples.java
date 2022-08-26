public class ListaEncadeadaSimples {
/*Lista encadeada/ligada (Linked List)
*/
	private NodoLES primeira = null;
	private NodoLES ultima = null;
	private int contador=0;
	
	public void Insere(Object elemento) {
		//insere no come�o da lista
		NodoLES novo = new NodoLES(elemento, this.primeira);
		this.primeira = novo;
		if (this.contador == 0) {
			this.ultima = this.primeira;
		}  
		this.contador = this.contador + 1;
	}
	public void InsereF(Object elemento) {
		//Inserir no fim da lista
		if(this.contador == 0) {
			this.Insere(elemento);
		}else {
			NodoLES novo = new NodoLES(elemento,null);
			this.ultima.setProximo(novo);
			this.ultima = novo;
			this.contador = this.contador+1;
		}
	}
	
	public Object MostraNodo(int posicao) {
		//retorna o elemento da posicao solicitada.
		//use getElemento()
		NodoLES atual = this.primeira;
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
		//Remove um elemento do fim da lista.
		//TODO
		if(this.contador == 0) {
			throw new IllegalArgumentException("Lista Vazia.");
		}
		NodoLES aux = this.primeira;
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
		//TODO
		if(this.contador == 0) {
			throw new IllegalArgumentException("Lista Vazia.");
		}
		NodoLES aux = this.primeira;
		for(int i = 1; i < this.contador; i++){
			if(obj.equals(aux.getElemento())){
				return true;
			}
			aux = aux.getProximo();
		}
		return false;
	}
	
	public String ShowList() {
		if (contador ==0) {
			return "[ ]";
		}
		NodoLES atual = primeira;
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
