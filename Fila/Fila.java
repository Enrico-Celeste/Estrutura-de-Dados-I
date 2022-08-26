public class Fila {
    public static void main(String[] args){

        banco b = new banco();
        menu(b);

    }

    public static void menu(banco b){
        int x = 0;
        while(x == 0){
            System.out.println("1-Inserir\n2-Remover\n3-Verificar primeiro elemento da fila\n4-Verificar se a"+
            " pilha esta vazia\n5-Verificar se a pilha esta cheia\noutro-Sair");
            String escolha = b.teclado.nextLine();
            if(escolha.equals("1"))
                inserir(b.fila);
            else if(escolha.equals("2"))
                remover(b.fila);
            else if(escolha.equals("3"))
                verificarprimeiroelemento(b.fila);
            else if(escolha.equals("4"))
                verificarvazia(b.fila);
            else if(escolha.equals("5"))
                verificarcheia(b.fila);
            else{
                x++;   
            }
        }
        f.teclado.close();
    }

    public static void inserir(Fila f){
        if(f.fim == 10)
            System.out.println("A fila esta cheia, exclua os itens para liberar espaco");
        else{
            System.out.println("Zero e considerado valor nulo");
            int numero = f.teclado.nextInt();
            f.fila[f.qtd] = numero;
            f.qtd++;
            f.fim++;
        }
        menu(f);
    }

    public static void remover(Fila f){
        if(f.ini <= f.fim){
            f.fila[f.ini] = 0;
            f.ini++;
        }else{
            System.out.println("A fila nao contem mais elementos");
            f.ini = 0;
            f.fim = 0;
        }
        menu(f);
    }

    public static void verificarprimeiroelemento(Fila f){
        if(f.fila[f.ini] == 0)
            System.out.println("O inicio da fila e nulo");
        else    
            System.out.println("O primeiro elemento da fila e: " + f.fila[f.ini]);
        menu(f);
    }

    public static void verificarvazia(Fila f){
        System.out.println("A pilha esta vazia? ");
        int y = 0;
        for(int x = 0; x < 10; x++){
            if(f.fila[x] != 0){
                y++;
            }
        }
        if(y == 0)
            System.out.println("Sim");
        else
            System.out.println("Nao");
        menu(f);
    }

    public static void verificarcheia(Fila f){
        System.out.println("A pilha esta cheia? ");
        int y = 0;
        for(int x = 0; x < 10; x++){
            if(f.fila[x] != 0){
                y++;
            }
        }
        if(y != 0)
            System.out.println("Sim");
        else
            System.out.println("Nao");
        menu(f);
    }
    
}
