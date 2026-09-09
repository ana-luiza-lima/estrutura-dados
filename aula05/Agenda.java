public class Agenda {


    private String[] nomes = new String[100];
    private String[] numeros = new String[100];
    private int contador = 0;

    public int getContador() {
        return contador;
    }

    public String[] getNomes() {
        return nomes;
    }

    public String[] getNumeros() {
        return numeros;
    }


    public void inserir(String nome, String numero) {
        if (contador < 100) {
            nomes[contador] = nome;
            numeros[contador] = numero;
            contador++;
        } else {
            System.out.println("Agenda cheia! Não é possível inserir mais contatos.");
        }
    }

    public void listar() {
        if (contador == 0) {
            System.out.println("Agenda vazia.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println("Nome: " + nomes[i] + " | Número: " + numeros[i]);
            }
        }
    }

}