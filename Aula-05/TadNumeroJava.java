
import java.util.Scanner;

public class TadNumeroJava {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        Numero numero = new Numero();

        while (true) {
            System.out.println("===================================================");
            System.out.println("            Estudo do TAD Numero");
            System.out.println("===================================================");
            System.out.println("0 - encerrar");
            System.out.println("1 - ler valor");
            System.out.println("2 - atribuir valor");

            System.out.print("Qual sua opção? ");

            int opc = leia.nextInt();

            if (opc == 0) {
                break;
            } else if (opc == 1) {
                System.out.println("\n\n" + numero.getValor() + "\n\n");
            } else if (opc == 2) {
                System.out.print("Forneça o novo valor: ");
                float v = leia.nextFloat();
                numero.setValor(v);
            }

        }
        System.out.println("--- FIM ---");
        System.out.println("Até a próxima.");

    }

}
