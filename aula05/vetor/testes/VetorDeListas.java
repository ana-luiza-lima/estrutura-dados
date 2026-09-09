package vetor.testes;

import vetor.VetorEstatico;

public class VetorDeListas {

    private VetorEstatico[] nomesporLetra;

    public VetorDeListas() {
        nomesporLetra = new VetorEstatico[26];
        for (int i = 0; i < nomesporLetra.length; i++) {
            nomesporLetra[i] = new VetorEstatico(20);
        }
    }

    public void inserir(String nome){
        char letra = Character.toUpperCase(nome.charAt(0));
        int indice = letra - 'A';
        nomesporLetra[indice].inserir(nome);
    }

    public void imprimir() {
        for (int i = 0; i < 26; i++) {
            char letra = (char) ('A' + i);
            System.out.print(letra + " ");
            nomesporLetra[i].imprimir();
        }


    }



}
