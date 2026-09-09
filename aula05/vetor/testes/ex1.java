package vetor.testes;

import vetor.VetorEstatico;

public class ex1 {

    static void main() {

        VetorEstatico vetor =
                new VetorEstatico(3);

        vetor.inserir("A");
        vetor.inserir("B");
        vetor.inserir("C");
        vetor.inserir("D");

        vetor.imprimir();



    }
}
