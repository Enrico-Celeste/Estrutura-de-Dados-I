public class NoLDC {
	private Object elemento;//gen�rico
	private NoLDC proximo;
	private NoLDC anterior;
	private NoLDC cursor;
		
	public NoLDC(Object elemento, NoLDC proximo){
		this.elemento = elemento;
		this.proximo = proximo;
	}
	public NoLDC(Object elemento){
		this(elemento,null);
	}
	
	public NoLDC getProximo() {
		return this.proximo;
	}
	public NoLDC getAnterior() {
		return this.anterior;
	}
	public NoLDC getCursor() {
		return this.cursor;
	}
	
	public void setProximo(NoLDC proximo) {
		this.proximo = proximo;
	}
	public void setAnterior(NoLDC anterior) {
		this.anterior = anterior;
	}
	public void setCursor(NoLDC cursor) {
		this.cursor = cursor;
	}
	public Object getElemento() {
		return this.elemento;
	}
}


