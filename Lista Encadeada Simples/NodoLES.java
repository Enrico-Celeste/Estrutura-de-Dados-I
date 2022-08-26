//Nó da lista simplesmente encadeada
public class NodoLES {
	private Object elemento;//genérico
	private NodoLES proximo;
		
	public NodoLES(Object elemento, NodoLES proximo){
		this.elemento = elemento;
		this.proximo = proximo;
	}
	public NodoLES getProximo() {
		return this.proximo;
	}
	public void setProximo(NodoLES proximo) {
		this.proximo = proximo;
	}
	public Object getElemento() {
		return this.elemento;
	}
}
