import java.util.Scanner;

public class exer5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x[] = new int[5];
        int pos = 0;
        for(int z = 1; z <= 5; z++){
            System.out.println("Digite o " + z + "° numero do array");
            x[z-1] = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Indique a posição do array para fazer a modificação: ");
        while(pos < 1 || pos > 5){
            pos = Integer.parseInt(scan.nextLine());
        }
        x[pos-1] = -1;
        scan.close();
        System.out.println("Todos as posições do array com o novo valor:");
        for(int z = 1; z <= 5; z++)
            System.out.println(z + "°: " + x[z-1]);
    }
}
