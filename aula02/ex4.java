public class ex4 {

    static void main() {

        VetorEstatico vetor = new VetorEstatico(10);

        vetor.inserir("A");
        vetor.inserir("B");
        vetor.inserir("C");
        vetor.inserir("F");

        vetor.imprimir();

        vetor.remover("A");

        vetor.imprimir();
    
    }
}
