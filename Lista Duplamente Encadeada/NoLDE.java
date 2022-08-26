public class NoLDE {
	private Object elemento;//gen�rico
	private NoLDE proximo;
	private NoLDE anterior;
		
	public NoLDE(Object elemento, NoLDE proximo){
		this.elemento = elemento;
		this.proximo = proximo;
	}
	public NoLDE(Object elemento){
		this(elemento,null);
	}
	
	public NoLDE getProximo() {
		return this.proximo;
	}
	public NoLDE getAnterior() {
		return this.anterior;
	}
	
	public void setProximo(NoLDE proximo) {
		this.proximo = proximo;
	}
	public void setAnterior(NoLDE anterior) {
		this.anterior = anterior;
	}
	public Object getElemento() {
		return this.elemento;
	}
}
 	 	
