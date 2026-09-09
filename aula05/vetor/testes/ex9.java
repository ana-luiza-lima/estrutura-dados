package vetor.testes;

import vetor.Caixa;

public class ex9 {

    static void main() {

        Caixa<String> caixaTexto = new Caixa<>();
        caixaTexto.guardar("Olá mundo");
        System.out.println(caixaTexto.abrir());

        Caixa<Integer> caixaNumero = new Caixa<>();
        caixaNumero.guardar(50);
        System.out.println(caixaNumero.abrir());



    }



}
