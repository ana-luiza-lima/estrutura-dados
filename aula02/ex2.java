public class ex2 {
    static void main() {

        VetorEstatico vetor = new VetorEstatico(10);

        vetor.inserir("A");
        vetor.inserir("B");
        vetor.inserir("C");
        vetor.inserir("F");

        vetor.inserir(2,"D");

        vetor.imprimir();

        vetor.remover();

        vetor.imprimir();
    }
}