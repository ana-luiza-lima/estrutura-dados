package atividade02;

import java.util.Arrays;
import java.util.Random;

public class ex {

    public static void main(String[] args) {

        int[] tamanhos = {1000, 10000, 100000};

        for (int tam : tamanhos) {

            System.out.println("TESTANDO VETOR DE TAMANHO: " + tam);

            Vetor<Integer> vetor = new Vetor<>(tam);
            inserirAleatorio(vetor, tam, tam * 10);

            int alvoInicio = vetor.ler(0);
            int alvoMeio = vetor.ler(tam / 2);
            int alvoFim = vetor.ler(tam - 1);

            testarBuscas(vetor, alvoInicio, "INÍCIO (" + alvoInicio + ")");
            testarBuscas(vetor, alvoMeio, "MEIO (" + alvoMeio + ")");
            testarBuscas(vetor, alvoFim, "FIM (" + alvoFim + ")");
        }

    }

    public static void inserirAleatorio(Vetor<Integer> vetor, int quantidade, int range) {
        Random aleatorio = new Random();
        while (vetor.obterTamanho() < quantidade) {
            int numeroSorteado = aleatorio.nextInt(range);
            boolean existe = false;

            for (int i = 0; i < vetor.obterTamanho(); i++) {
                if (vetor.ler(i) == numeroSorteado) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                vetor.inserirOrdenado(numeroSorteado);
            }
        }
    }

    // public static void preencherOrdenado(Vetor<Integer> vetor, int quantidade) {
    //     Random aleatorio = new Random();
    //     int atual = aleatorio.nextInt(10);
    //     for (int i = 0; i < quantidade; i++) {
    //         atual += aleatorio.nextInt(10) + 1;
    //         vetor.inserir(atual);
    //     }
    // }

    public static int[] buscarLinear(Vetor<Integer> vetor, int alvo) {
        int comparacoes = 0;
        for (int i = 0 ; i < vetor.obterTamanho(); i++) {
            comparacoes++;
            if (vetor.ler(i) == alvo) {
                return new int[]{i, comparacoes};
            }
        }
        return new int[]{-1, comparacoes};
    }

    public static int[] buscarLinearOrdenada(Vetor<Integer> vetor, int alvo) {
        int comparacoes = 0;
        for (int i = 0 ; i < vetor.obterTamanho(); i++) {
            comparacoes++;
            if (vetor.ler(i) == alvo) {
                return new int[]{i, comparacoes};
            } else if (vetor.ler(i) > alvo) {
                return new int[]{-1, comparacoes};
            }
        }
        return new int[]{-1, comparacoes};
    }

    public static int[] buscarBinaria(Vetor<Integer> vetor, int alvo) {
        int comparacoes = 0;
        int inicio = 0;
        int fim = vetor.obterTamanho() - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            comparacoes++;

            if (vetor.ler(meio) == alvo) {
                return new int[]{meio, comparacoes};
            } else if (vetor.ler(meio) > alvo) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return new int[]{-1, comparacoes};
    }

    public static void testarBuscas(Vetor<Integer> vetor, int alvo, String contexto) {
        System.out.println("Buscando " + contexto + ":");

        long inicioT = System.nanoTime();
        int[] resLinear = buscarLinear(vetor, alvo);
        long fimT = System.nanoTime();
        long duracaoLinear = (fimT - inicioT) / 1000000;
        System.out.println("[Busca Linear] Comparações: " + resLinear[1] + " | Tempo: " + duracaoLinear + " ms");

        inicioT = System.nanoTime();
        int[] resLinearOrdenada = buscarLinearOrdenada(vetor, alvo);
        fimT = System.nanoTime();
        long duracaoLinearOrdenada = (fimT - inicioT) / 1000000;
        System.out.println("[Busca Linear Ordenada] Comparações: " + resLinearOrdenada[1] + " | Tempo: " + duracaoLinearOrdenada + " ms");

        inicioT = System.nanoTime();
        int[] resBinaria = buscarBinaria(vetor, alvo);
        fimT = System.nanoTime();
        long duracaoBinaria = (fimT - inicioT) / 1000000;
        System.out.println("[Busca Binária] Comparações: " + resBinaria[1] + " | Tempo: " + duracaoBinaria + " ms");

        Integer[] arrayNativo = vetor.exportarArray();
        int[] arrayPrimitivo = new int[arrayNativo.length];
        for (int i = 0; i < arrayNativo.length; i++) {
            arrayPrimitivo[i] = arrayNativo[i];
        }

        inicioT = System.nanoTime();
        int pos = Arrays.binarySearch(arrayPrimitivo, alvo);
        fimT = System.nanoTime();
        long duracaoArrays = (fimT - inicioT) / 1000000;
        System.out.println("[Arrays.binarySearch] Posição: " + pos + " | Tempo: " + duracaoArrays + " ms\n");
    }

}