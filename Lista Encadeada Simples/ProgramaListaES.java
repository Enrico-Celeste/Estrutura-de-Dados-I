public class ProgramaListaES {

	public static void main(String[] args) {
		ListaEncadeadaSimples lista = new ListaEncadeadaSimples();
		
		System.out.println(lista.ShowList());
		lista.Insere("Jovem");
		System.out.println(lista.ShowList());
		lista.Insere("Outro Jovem");
		System.out.println(lista.ShowList());
		lista.InsereF("+ 1 jovem");
		System.out.println(lista.ShowList());
		System.out.println(lista.Verifica("Outro Jovem"));
		System.out.println(lista.MostraNodo(0));
		System.out.println(lista.ShowList());
		lista.Remove();
		System.out.println(lista.Verifica("Outro Jovem"));
		System.out.println(lista.ShowList());
		System.out.println(lista.Tamanho());
		System.out.println(lista.ShowList());
		lista.Insere("Teste");
		System.out.println(lista.ShowList());
		lista.Insere("Testando");
		System.out.println(lista.ShowList());
		lista.InsereF("+Testes");
		System.out.println(lista.ShowList());
		System.out.println(lista.Tamanho());
		lista.RemoveF();
		System.out.println(lista.Tamanho());
		System.out.println(lista.ShowList());
	}

}
