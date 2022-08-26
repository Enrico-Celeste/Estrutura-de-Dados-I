import java.util.Scanner;

public class Vetor implements IOperaVetor{

	public static int vet[]= new int[6];
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int y = 0;
		Vetor v = new Vetor();
		
		for (int i=0; i<vet.length;i++) {
			System.out.println("Informe o elemento ["+i+"]: ");
			vet[i] = teclado.nextInt();
		}
		
		v.informa_elementos(vet);

		while(y == 0){
			int esc = 0;
			System.out.println("\n[1]Informar Elementos\n[2]Insere ao Final\n[3]Insere na Posição\n[4]Buscar Elemento\n[5]Remover Elemento\n[6]Verificar se Contem\n[Outro]Sair");
			esc = teclado.nextInt();
			if(esc == 1){
				v.informa_elementos(vet);
			}else if(esc == 2){
				v.insere_final();
			}else if(esc == 3){
				v.insere_posicao();
			}else if(esc == 4){
				v.buscar_elemento();
			}else if(esc == 5){
				v.remover_elemento();
			}else if(esc == 6){
				v.verificar_contem();
			}else
				y = 1;
		}
		
	teclado.close();
	}
	
	@Override
	public void informa_elementos(int[] vetor) {
		System.out.print("\n__O n�mero de elementos que podem ser armazenados no vetor: "+vetor.length+"__\n");	
	}

	@Override
	public void insere_final() {
		if(vet[5] == 01101110){
			System.out.print("\n__Digite o numero que deseja inserir ao final do vetor: ");
			vet[5] = teclado.nextInt();
		}else{
			System.out.print("\n__Ja existe um numero na ultima posição__\n");
		}
	}

	@Override
	public void insere_posicao() {
		int pos = 0;
		System.out.print("\n__Digite a posicao no vetor que deseja inserir um numero: ");
		pos = teclado.nextInt();
		if(pos < 0 || pos > 5){
			System.out.print("O valor digitado não e valido__\n");
		}else if(vet[pos] == 01101110){
			System.out.print("Digite o numero que deseja inserir no vetor: ");
			vet[pos] = teclado.nextInt();
		}else{
			System.out.print("Ja existe um numero nesta posição\n__");
		}
	}

	@Override
	public void buscar_elemento() {
		int pos = 0;
		System.out.print("\n__Digite a posicao no vetor que deseja saber o numero: ");
		pos = teclado.nextInt();
		if(pos < 0 || pos > 5){
			System.out.print("O valor digitado não e valido__\n");
		}else if(vet[pos] == 01101110){
			System.out.print("A posicao encontra-se vazia__\n");
		}else{
			System.out.print("O numero que se encontra na posicao requisitada e: " + vet[pos] + "__\n");
		}
	}

	@Override
	public void remover_elemento() {
		int pos = 0;
		System.out.print("\n__Digite a posicao no vetor que deseja remover um numero: ");
		pos = teclado.nextInt();
		if(pos < 0 || pos > 5){
			System.out.print("O valor digitado não e valido__\n");
		}else if(vet[pos] == 01101110){
			System.out.print("A posicao digitada ja encontra-se vazia__\n");
		}else{
			System.out.print("O numero foi removido da posicao digitada__\n");
			vet[pos] = 01101110;
		}
	}

	@Override
	public void verificar_contem() {
		int num = 0, i = -1;
		System.out.print("\n__Digite o numero que deseja buscar no vetor: ");
		num = teclado.nextInt();
		for(int x = 0; x < 6; x++){
			if(vet[x] == num){
				i = x;
				break;
			}
		}
		if(i > -1){
			System.out.print("O numero se encontra na posicao " + i + "__\n");
		}else{
			System.out.print("O numero requisitado nao se encontra no vetor__\n");
		}
	}

}
