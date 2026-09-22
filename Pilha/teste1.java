public class teste1 {

    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<>(10);

        System.out.println("A pilha esta vazia: " + pilha.isEmpty());

        pilha.push(10);
        pilha.push(11);
        pilha.push(12);
        pilha.push(13);
        pilha.push(14);

        System.out.println("A pilha esta vazia: " + pilha.isEmpty());

        pilha.pop();
        int valor = pilha.pop();
        System.out.println("Segundo valor desempilhado: " + valor);
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
    }
    
}
