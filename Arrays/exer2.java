import java.util.Scanner;

public class exer2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double x[] = new double[10];
        double y[] = new double[10];
        for(int z = 1; z <= 10; z++){
            System.out.println("Digite o " + z + "° numero do array");
            x[z-1] = Integer.parseInt(scan.nextLine());
        }
        scan.close();
        for(int z = 0; z < 10; z++)
            y[z] = Math.pow(x[z], 2);
        System.out.println("Todos as posições do array ao quadrado:");
        for(int z = 1; z <= 10; z++)
            System.out.println(z + "°: " + y[z-1]);
    }
}