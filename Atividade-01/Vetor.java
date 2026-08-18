import java.util.Random;

public class Vetor<T> {

    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade) {
        elementos = (T[]) new Object[quantidade];
        tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    public void inserirAleatorio(int quantidadeNumeros, int limite){
        Random random = new Random();
        for(int i = 0; i < quantidadeNumeros; i++){
            int x = random.nextInt(limite);
            int v = verificaNumero(x);
            if(v != -1){
                inserir((T) Integer.valueOf(v));
                IO.println("Inserido: " + v);
                break;
            }
        }
        
    }

    public int verificaNumero(int n){
        for(int i = 0; i < tamanho; i++){
            int valor = (Integer) ler(i);
            if(valor < n){
                return i;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public void inserir(T elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
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
        if (tamanho <= elementos.length / 4) {
            T[] novo = (T[]) new Object[elementos.length / 2];
            for (int i = 0; i < tamanho; i++) {
                novo[i] = elementos[i];
            }
            elementos = novo;
        }
    }

    public T ler(int indice) {
        if (indice < 0 || indice >= tamanho) {
            return null;
        }
        return elementos[indice];
    }
    
    public int getTamanho() {
        return tamanho;
    }

    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Índice inválido");
            return;
        }

        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[tamanho - 1] = null;
        tamanho--;
        reduzir();
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i]);
            if (i < tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }




}