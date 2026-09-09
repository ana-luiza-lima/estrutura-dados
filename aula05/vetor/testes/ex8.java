package vetor.testes;

import vetor.VetorObjeto;

public class ex8 {

    static void main() {

        VetorObjeto vetor = new VetorObjeto(10);

        vetor.inserir("Teste");
        vetor.inserir(100);
        vetor.inserir(1.99);

        String palavra = (String) vetor.ler(0);
        int numero = (Integer) vetor.ler(1);
        double preco = (Double) vetor.ler(2);

        String price = (String) vetor.ler(2);




    }
}
