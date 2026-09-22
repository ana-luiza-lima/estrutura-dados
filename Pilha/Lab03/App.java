package Lab03;

public class App {

    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();
        labirinto.imprimir();

        boolean encontrado = labirinto.resolver();

        System.out.println();
        System.out.println(encontrado ? "Caminho encontrado!" : "Nenhum caminho encontrado.");
        labirinto.imprimir();
    }
    
}
