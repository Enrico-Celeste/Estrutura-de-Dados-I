import java.util.Scanner;

public class exer4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x[] = new int[6];
        int me = 0, ma = 0;
        for(int z = 1; z <= 6; z++){
            System.out.println("Digite o " + z + "° numero do array");
            x[z-1] = Integer.parseInt(scan.nextLine());
        }
        scan.close();
        for(int z = 0; z < 6; z++){
            if(z == 0){
                me = x[z]; 
                ma = x[z];
            }else{
                if(x[z] < me){
                    me = x[z];
                }else if(x[z] > ma)
                    ma = x[z];
            }
        }
        System.out.println("Maior numero: " + ma + "\nMenor numero: " + me);
    }
}