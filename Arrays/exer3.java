import java.util.Scanner;

public class exer3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x[] = new int[6];
        for(int z = 1; z <= 6; z++){
            System.out.println("Digite o " + z + "° numero do array");
            x[z-1] = Integer.parseInt(scan.nextLine());
        }
        scan.close();
        System.out.println("Todos as posições do array invertido:");
        for(int z = 6; z > 0; z--)
            System.out.println(z + "°: " + x[z-1]);
    }
}