import java.util.*;

public class fila {
    public static void main(String[] args){
        banco b = new banco();
        menu(b.queue, b.teclado);
    }

    public static void menu(Queue<Integer> q, Scanner t){
        int x = 0;
        while(x == 0){
            System.out.println("1-Inserir\n2-Remover\n3-Verificar primeiro elemento da fila\n4-Verificar se a"+
            " pilha esta vazia\noutro-Sair");
            String escolha = t.nextLine();
            if(escolha.equals("1"))
                inserir(q, t);
            else if(escolha.equals("2"))
                remover(q, t);
            else if(escolha.equals("3"))
                verificarprimeiroelemento(q, t);
            else if(escolha.equals("4"))
                verificarvazia(q, t);
            else
                x = 10;   
        }
    }

    public static void inserir(Queue<Integer> q, Scanner t){
        int numero = t.nextInt();
        q.offer(numero);
        menu(q, t);
    }

    public static void remover(Queue<Integer> q, Scanner t){
        if(q.isEmpty() == true)
            System.out.println("O inicio da fila e nulo");
        else{ 
            System.out.println("Foi removido: " + q.peek());
            q.remove();
        }
        menu(q, t);
    }

    public static void verificarprimeiroelemento(Queue<Integer> q, Scanner t){
        if(q.isEmpty() == true)
            System.out.println("O inicio da fila e nulo");
        else    
            System.out.println("O primeiro elemento da fila e: " + q.peek());
        menu(q, t);
    }

    public static void verificarvazia(Queue<Integer> q, Scanner t){
        System.out.println("A fila esta vazia? ");
        int y = 0;
        if(q.isEmpty() == true)
            y++;
        if(y == 1)
            System.out.println("Sim");
        else
            System.out.println("Nao");
        menu(q, t);
    }

}
