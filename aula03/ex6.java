

public class ex6 {

    static void main() {
        
        VetorDinamico vetor = new VetorDinamico(2);

        vetor.inserir("Rogerio");
        vetor.inserir("Rogerio");
        vetor.imprimir();

        vetor.inserir("Rogerio");
        vetor.inserir("Rogerio");
        vetor.inserir("Rogerio");
        vetor.inserir("Rogerio");
        vetor.imprimir();

        // vetor.inserir("Rogerio");
        // vetor.imprimir();

        vetor.inserir("Rogerio");
        vetor.inserir("Rogerio");
        vetor.inserir("Rogerio");
        vetor.inserir("Rogerio 2");
        vetor.imprimir();

        vetor.remover(1);
        // vetor.remover(1);
        // vetor.remover(1);
        // vetor.remover(1);
        vetor.imprimir();


    }
    
}
