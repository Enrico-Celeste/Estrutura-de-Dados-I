import java.util.Scanner;
public class ArvoreAVLApplication {
    public static void main(String args[]){
        boolean i;
        int x, y;
        Scanner t = new Scanner(System.in);
        System.out.println("Digite o numero raiz da arvore");
        ArvoreAVL arvore = new ArvoreAVL(new Banco(t.nextInt()));
        arvore.calculoBalanceamento();
        arvore = arvore.verificaBalanceamento();
        
        while(i = true){
            System.out.println("1- Inserir|2- Busca|3- Remover|outro- Sair");
            x = t.nextInt(); 
            if(x == 1){
                System.out.println("Digite o numero que deseja inserir");
                y = t.nextInt();
                arvore = arvore.inserir(new Banco(y));
                arvore.calculoBalanceamento();
                arvore = arvore.verificaBalanceamento();
                System.out.println(arvore.imprimirArvore(0));
            }
            else if(x == 2){
                System.out.println("Digite o numero que deseja procurar");
                y = t.nextInt();
                if(arvore.busca(y) == true)
                    System.out.println("O elemento " + y + " existe");
                else
                    System.out.println("O elemento " + y + " nao existe");
            }
            else if(x == 3){
                System.out.println("Digite o numero que deseja remover");
                y = t.nextInt();
                arvore = arvore.inserir(new Banco(y));
                arvore.calculoBalanceamento();
                arvore = arvore.verificaBalanceamento();
                System.out.println(arvore.imprimirArvore(0));
            }
            else if(x < 1 || x > 3){
                i = false;
                t.close();
            }  
        }
    }
}