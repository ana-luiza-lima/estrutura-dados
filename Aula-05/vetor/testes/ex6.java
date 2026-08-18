package vetor.testes;

import vetor.VetorDinamico;

public class ex6 {

    static void main() {

        VetorDinamico vetor = new VetorDinamico(2);

        vetor.inserir("Ana");
        vetor.inserir("Ana");
        vetor.imprimir();

        // expandir
        vetor.inserir("Ana");
        vetor.imprimir();
        vetor.inserir("Ana");
        vetor.inserir("Ana");
        vetor.inserir("Ana");

        // expandir
        vetor.inserir("Ana");
        vetor.imprimir();




    }
}
