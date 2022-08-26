public class ProgramaListaDuplamenteEncadeada {
//PROGRAMA LISTA DUPLAMENTE ENCADEADAS
	public static void main(String[] args) {
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		
		System.out.println(lista.ShowList());
		lista.Insere("Jovem");
		lista.InsereF("Young");
		lista.Insere("Jovem 2");
		lista.InsereF("Rubens");
		System.out.println(lista.ShowList());
		System.out.println(lista.Tamanho());
		lista.Remove();
		lista.RemoveF();
		System.out.println(lista.ShowList());
		System.out.println(lista.Tamanho());
		System.out.println(lista.Verifica("Young"));
		System.out.println(lista.Verifica("Rubens"));
		System.out.println(lista.MostraNodo(0));

	}

}
