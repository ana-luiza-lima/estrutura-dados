

public class Vetor<T>{

    private T[] elementos;
    private int tamanho; //quantos elementos já foram inseridos

    public Vetor(int quantidade){
        this.elementos = (T[]) new Object[quantidade];
        this.tamanho = 0;
    }

    public void inserir(T elemento){
        if(tamanho == elementos.length){
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public void inserir(T elemento, int indice){
        if(indice < 0 || indice > tamanho){
            System.out.println("Indice Inválido");
            return;
        }
        if(tamanho == elementos.length){
            expandir();
        }
        for (int i = tamanho - 1; i >= indice; i--){
            elementos[i + 1] = elementos[i];
        }
        elementos[indice] = elemento;
        tamanho++;
    }

    private void expandir(){
        T[] novo = (T[]) new Object[elementos.length * 2];
        for (int i = 0; i < elementos.length; i++){
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    private void reduzir(){
        if(tamanho <= elementos.length/4){
            T[] novo = (T[]) new Object[elementos.length/2];
            for (int i = 0; i < novo.length; i++){
                novo[i] = elementos[i];
            }
            elementos = novo;
        }
    }

    public void remover(int indice){
        if(indice < 0 || indice >= tamanho){
            System.out.println("Indice Inválido");
            return;
        }
        for (int i = indice; i < tamanho - 1; i++){
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho-1] = null;
        tamanho--;
        reduzir();
    }

    public void imprimir() {
        System.out.print("[");
        for(int i = 0; i < tamanho; i++){
            System.out.print(elementos[i]);
            if(i < tamanho -1){
                System.out.println(", ");
            }
        }
        System.out.println("]");
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
}