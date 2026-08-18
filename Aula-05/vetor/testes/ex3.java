package vetor.testes;

import vetor.VetorEstatico;

public class ex3 {

    static void main() {

        VetorEstatico vetor =
                new VetorEstatico(10);

        vetor.inserir("A");
        vetor.inserir("B");
        vetor.inserir("C");
        vetor.inserir("D");
        vetor.inserir("F");

        vetor.imprimir();

        // Removendo
        System.out.println("Removendo na posição 2");
        vetor.remover(2);

        System.out.println("Arranjo após a remoção");
        vetor.imprimir();



    }


}
