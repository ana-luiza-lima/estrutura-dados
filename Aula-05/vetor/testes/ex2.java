package vetor.testes;

import vetor.VetorEstatico;

public class ex2 {

    static void main() {
        VetorEstatico vetor =
                new VetorEstatico(10);

        vetor.inserir("A");
        vetor.inserir("B");
        vetor.inserir("C");
        vetor.inserir("F");

        vetor.inserir(2,"W");

        vetor.imprimir();

    }
}
