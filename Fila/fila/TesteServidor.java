import java.util.Random;
import java.util.Scanner;

public class TesteServidor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Capacidade da fila: ");
        int capacidadeFila = entrada.nextInt();
        System.out.print("Quantidade de processadores: ");
        int processadores = entrada.nextInt();
        System.out.print("Máximo de chegadas por ciclo (N): ");
        int maxChegadas = entrada.nextInt();
        System.out.print("Quantidade de ciclos: ");
        int ciclos = entrada.nextInt();
        System.out.print("Quantidade de simulações: ");
        int repeticoes = entrada.nextInt();

        int totalGeradas = 0;
        int totalAtendidas = 0;
        int totalPerdidas = 0;

        for (int i = 0; i < repeticoes; i++) {
            Servidor servidor = new Servidor(capacidadeFila, processadores, maxChegadas);
            servidor.executar(ciclos);

            totalGeradas += servidor.getTotalReqGeradas();
            totalAtendidas += servidor.getTotalReqAtendidas();
            totalPerdidas += servidor.getTotalReqPerdidas();

            System.out.println("\nSimulação " + (i + 1));
            servidor.imprimirRelatorio();
        }

        System.out.println("\nResumo geral");
        System.out.println("Requisições geradas: " + totalGeradas);
        System.out.println("Requisições atendidas: " + totalAtendidas);
        System.out.println("Requisições perdidas: " + totalPerdidas);
        if (totalGeradas > 0) {
            double taxaPerda = (double) totalPerdidas / totalGeradas;
            System.out.printf("Taxa de perda agregada: %.2f%%%n", taxaPerda * 100);
        } else {
            System.out.println("Taxa de perda: não calculável");
        }
    }
}
