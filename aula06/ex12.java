package aula06;

import aula06.atividade01.Vetor;

import java.util.Random;

public class ex12 {


    public static void main(String[] args) {

        Vetor<Integer> vetor =  new Vetor<>(10);
        inserirAleatorio(vetor, 100, 200);

        vetor.imprimir();

    }

    public static void inserirAleatorio(Vetor<Integer> vetor, int quantidade, int range) {

        Random aleatorio = new Random();
        while (vetor.getTamanho() < quantidade) {
            int numeroSorteado = aleatorio.nextInt(range);
//            vetor.inserirOrdenadov2(numeroSorteado);
            vetor.inserir(numeroSorteado);
        }

    }

    public int buscarLinear(Vetor<Integer> vetor, int alvo) {
        for (int i = 0 ; i < vetor.getTamanho(); i++) {
            if (vetor.ler(i) == alvo) {
                return i;
            }
        }
        return -1;
    }

    public int buscarLinearOrdenada(Vetor<Integer> vetor, int alvo) {
        for (int i = 0 ; i < vetor.getTamanho(); i++) {
            if (vetor.ler(i) == alvo) {
                return i;
            } else if (vetor.ler(i) > alvo) {
                return -1;
            }
        }
        return -1;
    }

    public int buscarBinaria(Vetor<Integer> vetor, int alvo) {

        int inicio = 0;
        int fim = vetor.getTamanho();

        while (inicio <= fim) {

            int meio = (inicio + fim)/2;

            if (vetor.ler(meio) == alvo) {
                return meio;
            }  else if (vetor.ler(meio) > alvo) {
                fim = meio -1;
            } else {
                inicio = meio + 1;
            }



        }



        return -1;

    }




}
