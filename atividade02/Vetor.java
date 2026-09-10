package atividade02;

public class Vetor<T> {

    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade){
        elementos = (T[])  new Object[quantidade];
        tamanho = 0;
    }

    public void inserir(T elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public void inserirOrdenado(Comparable elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }

        int posicao = tamanho;
        for (int i = 0; i < tamanho; i++) {
            if (elemento.compareTo(elementos[i]) < 0) {
                posicao = i;
                break;
            }
        }

        for (int i = tamanho; i > posicao; i--) {
            elementos[i] = elementos[i-1];
        }

        elementos[posicao] = (T) elemento;
        tamanho++;
    }

    public T ler(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return elementos[indice];
    }

    public int obterTamanho() {
        return this.tamanho;
    }

    public Integer[] exportarArray() {
        Integer[] array = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = (Integer) elementos[i];
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    private void expandir() {
        T[] novo = (T[]) new Object[elementos.length * 2];
        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    @SuppressWarnings("unchecked")
    private void reduzir() {
        if (tamanho <= elementos.length/4) {
            T[] novo = (T[]) new Object[elementos.length/2];
            for (int i = 0; i < tamanho; i++) {
                novo[i] = elementos[i];
            }
            elementos = novo;
        }
    }

    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Indice Inválido");
            return;
        }
        for (int i = indice; i < tamanho; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho-1] = null;
        tamanho--;
        reduzir();
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < tamanho ; i++) {
            System.out.print(elementos[i]);
            if (i < tamanho -1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }



}
