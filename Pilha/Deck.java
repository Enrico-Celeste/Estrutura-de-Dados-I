import java.util.*;

public class Deck {
    public static void main(String[] args){
        Deque<Integer> vetor = new LinkedList<Integer>();
        Scanner teclado = new Scanner(System.in);
        menu(vetor, teclado);
    }

    public static void menu(Deque<Integer> v, Scanner t){
        int x = 0;
        while(x == 0){
            System.out.println("1-Inserir na frente\n2-Inserir atras\n3-Remover primeiro\n4-Remover ultimo"
            +"\n5-Verificar primeiro elemento da fila\n6-Verificar ultimo elemento da fila\n7-Verificar se a"
            +" pilha esta vazia\n8-Verificar se a pilha esta cheia\noutro-Sair");
            String escolha = t.nextLine();
            if(escolha.equals("1"))
                insertFront(v, t);
            else if(escolha.equals("2"))
                insertBack(v, t);
            else if(escolha.equals("3"))
                removeFirst(v, t);
            else if(escolha.equals("4"))
                removeLast(v, t);
            else if(escolha.equals("5"))
                examineFirst(v, t);
            else if(escolha.equals("6"))
                examineLast(v, t);
            else if(escolha.equals("7")){
                if(empty(v, t) == true)
                    System.out.println("A fila esta vazia");
                else
                    System.out.println("A fila nao esta vazia");
            }
            else if(escolha.equals("8")){
                if(full(v, t) == false)
                    System.out.println("A fila nao esta cheia");
            }
            else{
                x++;
            }
        }
    }

    public static void insertFront(Deque<Integer> v, Scanner t){
        System.out.println("Digite o numero que deseja adicionar");
        int numero = t.nextInt();
        v.push(numero);
        menu(v, t);
    }

    public static void insertBack(Deque<Integer> v, Scanner t){
        System.out.println("Digite o numero que deseja adicionar");
        int numero = t.nextInt();
        v.offer(numero);
        menu(v, t);
    }

    public static void removeFirst(Deque<Integer> v, Scanner t){
        if(v.isEmpty() == true)
            System.out.println("Nao ha nada para remover");
        else{
            int numero = v.pollFirst();
            v.pollFirst();
            System.out.println("Item removido: " + numero);
        }
        menu(v, t);
    }
    
    public static void removeLast(Deque<Integer> v, Scanner t){
        if(v.isEmpty() == true)
            System.out.println("Nao ha nada para remover");
        else{
            int numero = v.pollLast();
            v.pollLast();
            System.out.println("Item removido: " + numero);
        }
        menu(v, t);
    }
    
    public static void examineFirst(Deque<Integer> v, Scanner t){
        System.out.println("Primeiro na fila: " + v.getFirst());
    }
    
    public static void examineLast(Deque<Integer> v, Scanner t){
        System.out.println("Ultimo na fila: " + v.getLast());
    }
    
    public static boolean empty(Deque<Integer> v, Scanner t){
        return(v.isEmpty());
    }
    
    public static boolean full(Deque<Integer> v, Scanner t){
        return(false);
    }

}
