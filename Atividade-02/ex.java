import java.util.Random;

public class ex {

    static void main() {

        Vetor<Integer> vetor =  new Vetor<>(10);
        inserirAleatorio(vetor, 100, 200);

        vetor.imprimir();

    }
}