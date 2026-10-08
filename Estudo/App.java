public class App {
    public static void main(String[] args) {
        vetorIDs v = new vetorIDs(5, false);

        v.inserir(300);
        v.inserir(100);
        v.inserir(200);
        v.inserir(200); // repetido, deve falhar
        v.imprimir();

        System.out.println("Posição do 200: " + v.localizar(200));

        v.remover(100);
        v.imprimir();
    }
}
