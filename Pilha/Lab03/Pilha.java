package atividade;

public class Pilha<T> {

    private int topo;
    private T[] elementos;

    public Pilha(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.topo = -1;
    }

    public void push(T elemento){
        elementos[++topo] = elemento;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Pilha Vazia");
        }
        T elemento = elementos[topo];
        elementos[topo--] = null;
        return elemento;
    }

    public boolean isEmpty(){
        return topo == -1;
    }

    


}