import java.util.Random;

public class Servidor {
    
    private int totalReqGeradas = 0;
    private int totalReqAtendidas = 0;
    private int totalReqPerdidas = 0;
    private Random aleatorio;
    private Fila<String> fila;
    private int numProcessadores;
    private int N; /////max de requisições na fila
    private int novasReq;

    public Servidor(int capacidadeFila, int numProcessadores, int N) {
        if ((N <= 0) || (capacidadeFila <= 0) || (numProcessadores <= 0)) {
            System.out.println("Valor inválido");
        }
        this.aleatorio = new Random();
        this.fila = new Fila<>(capacidadeFila);
        this.numProcessadores = numProcessadores;
        this.N = N;
        this.novasReq = 0;
    }
    
    public void executar(int ciclos) {              //
        for (int ciclo = 0; ciclo < ciclos; ciclo++) {
            for (int i = 0; i < numProcessadores; i++) {
                if (!fila.isEmpty()) {
                    fila.desenfileirar();
                    totalReqAtendidas++;
                }
            }

            novasReq = aleatorio.nextInt(1, N-1);
            totalReqGeradas += novasReq;
            
            if (novasReq > fila.espacoDisponivel()) {
                totalReqPerdidas += (novasReq - fila.espacoDisponivel());
                novasReq = fila.espacoDisponivel();
            }
            
            for (int j = 0; j < novasReq; j++) {
                fila.enfileirar ("Requisição " + (j+1));
            }            
        }
    }

















    public int getTotalReqGeradas() {
        return totalReqGeradas;
    }

    public int getTotalReqAtendidas() {
        return totalReqAtendidas;
    }

    public int getTotalReqPerdidas() {
        return totalReqPerdidas;
    }

    public double getProbabilidadePerda() {
        if (totalReqGeradas == 0) {
            return Double.NaN;
        }
        return (double) totalReqPerdidas / totalReqGeradas;
    }

    public void imprimirRelatorio() {
        System.out.println("Requisições geradas: " + totalReqGeradas);
        System.out.println("Requisições atendidas: " + totalReqAtendidas);
        System.out.println("Requisições perdidas: " + totalReqPerdidas);

        if (totalReqGeradas == 0) {
            System.out.println("Taxa de perda: não calculável (nenhuma requisição gerada)");
        } else {
            System.out.printf("Taxa de perda: %.2f%%%n", getProbabilidadePerda() * 100);
        }
    }
}
    











    //                     if (!fila.isFull()) {
    //                         fila.enfileirar("Requisição " + (totalReqGeradas + 1));
    //                         totalReqGeradas++;
    //                     } else {
    //                         totalReqPerdidas++;
    //                     }
    //                 }             

    //             totalReqPerdidas++;
    //         }
            


    //         //simulação aqui
    //         //for pro n de pricessadoes
    //         //fila.desenfileirar();
    //         // totalReqGeradas++
    //         int novasReq = aleatorio.nextInt(1, N-1);
    //         //gerar as novasReq requisiçõies e adicionar na fila
            
    //     }

    // }






